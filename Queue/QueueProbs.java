import java.util.Stack;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
public class QueueProbs{
//REVERSING A QUEUE USING A STACK
    public static void reverseQueue(Queue<Integer> q){
        Stack<Integer> stack = new Stack<>();
        while(!q.isEmpty()){
            int val = q.poll();
            stack.push(val);
        }
        while (!stack.isEmpty()){
            int val = stack.pop();
            q.offer(val);
        }
    }

//FINDING FIRST NEGATIVE NUMBER IN EVERY WINDOW OF SIZE K IN AN ARRAY USING QUEUE
    public static int[] firstNegativeInWindow(int[] arr, int windowSize){
        int n = arr.length;
        int[] ans = new int[n-windowSize+1];
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<windowSize; i++){
            if (arr[i]<0) q.offer(i);
        }

        ans[0] = q.isEmpty() ? 0 : arr[q.peek()];

        int idx = 1;
        for (int i=windowSize; i<n; i++){
            if (!q.isEmpty() && q.peek() < i-windowSize+1) q.poll();

            if (arr[i] < 0) q.offer(i);
            ans[idx] = q.isEmpty() ? 0 : arr[q.peek()];
            idx++;
        }
        return ans;
    }


//INTERLEAVING THE FIRST HALF OF THE QUEUE WITH THE SECOND HALF
    public static void interleave(Queue<Integer> q){
        int midPoint = q.size()/2;

        Queue<Integer> temp = new LinkedList<>();

        for (int i = 0; i<midPoint; i++){
            temp.offer(q.poll());
        }

        while(!temp.isEmpty()){
            q.offer(temp.poll());
            q.offer(q.poll());
        }
    }

//FINDING FIRST NON REPEATING CHARACTER IN A STREAM OF CHARACTERS USING QUEUE
    public static String findFirstNonRepeating(String stream){
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<stream.length(); i++){
            char c = stream.charAt(i);

            freq[c - 'a']++;
            q.offer(c);

            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.poll();
            }

            char ans = q.isEmpty() ? '#' : q.peek();
            sb.append(ans);
        }
        return sb.toString();
    }


//MAIN FUNCTION
    public static void main(String[] args){
        // Queue<Integer> queue = new LinkedList<>();
        // queue.offer(10);
        // queue.offer(20);
        // queue.offer(30);
        // System.out.println("initial queue: "+queue);
        // reverseQueue(queue);
        // System.out.println("final queue: "+queue);

        //     int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        //     int k = 3;
            
        //System.out.println("Original: " + Arrays.toString(arr));
        //int[] result = firstNegativeInWindow(arr, k);
        //System.out.println("Result:   " + Arrays.toString(result));

        Queue<Integer> q = new LinkedList<>();
        q.offer(11);
        q.offer(12);
        q.offer(13);
        q.offer(14);
        q.offer(15);
        q.offer(16);

        System.out.println("Original Queue: " + q);
        interleave(q);
        System.out.println("Interleaved:    " + q);
    }
}