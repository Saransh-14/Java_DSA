import java.util.Arrays;
import java.util.Stack;
public class StackProbs2{
//NEXT GREATER ELEMENT USING STACK
    public static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] nextG = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            if (st.isEmpty()) nextG[i] = -1;
            else nextG[i] = st.peek();
            st.push(arr[i]);
        }
        return nextG;
    }

//FINDING NEXT SMALLER ELEMENT USING STACK
    public static int[] nextSmaller(int[] arr){
        int n = arr.length;
        int[] nxtS = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n-1; i>=0; i--){
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            if (st.isEmpty()) nxtS[i] = -1;
            else nxtS[i] = st.peek();
            st.push(arr[i]);
        }
        return nxtS;
    }

//STOCK SPAN PROBLEM USING STACK
    public static int[] stockSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i<n; i++){
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) st.pop();
            if (st.isEmpty()) span[i] = i+1;
            else span[i] = i-st.peek();
            st.push(i);
        }
        return span;
    }

//FINDING THE LARGEST RECTANGLE IN A HISTOGRAM
    public static int[] nsl(int[] heights, Stack<Integer> st){
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = 0; i<n; i++){
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.isEmpty()) ans[i] = n;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public static int[] nsr(int[] heights, Stack<Integer> st){
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = n-1; i>=0; i--){
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) st.pop();
            if (st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }
    public static int largestRectangle(int[] heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] nsl = nsl(heights, st);
        st.clear();
        int[] nsr = nsr(heights, st);

        int maxArea = 0;
        for (int i = 0; i<n; i++){
            int width = nsr[i] - nsl[i] - 1;
            if (width*heights[i] > maxArea) maxArea = width*heights[i];            
        }

        return maxArea;


    }

//MAIN FUNCTION
    public static void main(String[] args) {
        // int[] arr = {4, 5, 2, 25};
        // System.out.println("NGE: " + Arrays.toString(nextGreaterElement(arr)));
        
        // int[] arr = {100, 80, 60, 70, 60, 75, 85};
        // System.out.println("NGE: " + Arrays.toString(stockSpan(arr)));
        
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area in Histogram: " + largestRectangle(heights));
    }
}