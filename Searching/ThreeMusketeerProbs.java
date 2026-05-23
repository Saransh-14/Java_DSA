import java.util.Arrays;
public class ThreeMusketeerProbs{
//SQUARE ROOT FINDING USING BINARY SEARCH
    public static int squareRoot(int n){
        int start = 1, end = n, ans = 0;
        while (start <= end){
            int mid = start+(end-start)/2;
            if ((long)mid*mid==n) return mid;
            else if((long)mid*mid>n) end = mid-1;
            else{
                ans = mid;
                start = mid+1;
            }
        }
        return ans;
    }

//BOOK ALLOCATION PROBLEM
    public static boolean isPossible(int[] arr, int totalStudents, int loadPerHead){
        int studentCount = 1;
        int currentLoadSum = 0;
        for (int i=0; i<arr.length; i++){
            if (currentLoadSum + arr[i] <= loadPerHead){
                currentLoadSum += arr[i];
            }
            else{
                studentCount++;
                if (studentCount>totalStudents) return false;
                currentLoadSum = arr[i];
            }
        }
        return true;
    }

    public static int allocateBooks(int[] pages, int totalStu){
        int n = pages.length;
        if (totalStu > n) return -1;

        int start = 0, end = 0;
        for (int i = 0; i<n; i++){
            start = Math.max(start, pages[i]);
            end = end+pages[i];
        }

        int ans = -1;
        while (start <= end){
            int mid = start+ (end-start)/2;

            if (isPossible(pages, totalStu, mid)){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }   
        return ans;
    }

//AGGRESSIVE COWS PROBLEM
    public static boolean isTyingPossible(int[] stalls, int totalCows, int mid){
        int i = 0;
        int lastPosition = i;
        totalCows--;
        for (i = 1; i<stalls.length; i++){
            if (stalls[i]-stalls[lastPosition]>=mid){
                lastPosition = i;
                totalCows--;
            }
            if (totalCows==0) return true;
        }
        return false;
    }

    public static int tieAngryCows(int[] stalls, int totalMoos){
        Arrays.sort(stalls);
        int start = 1, end = stalls[stalls.length-1] - stalls[0];
        int ans = -1;
        while (start<=end){
            int mid = start+(end-start)/2;

            if (isTyingPossible(stalls, totalMoos, mid)){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return ans;
    }


//MAIN FUNCTION
    public static void main(String[] args){
        // System.out.println(squareRoot(17));

        // int[] pages = {12, 34, 67, 90};
        // int m = 2;
        // System.out.println(allocateBooks(pages, m));
    
        int[] stalls = {7, 9, 1, 14, 11};
        int totalMoos = 3;
        System.out.println(tieAngryCows(stalls, totalMoos));
    }

}