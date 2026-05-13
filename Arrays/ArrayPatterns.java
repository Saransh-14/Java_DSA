public class ArrayPatterns{
//PRINTING ARRAY
    public static void PrintArray(int[] arr){
        int i = 0;
        while(i<arr.length){
             System.out.print(arr[i]);
            i++;
            if(i<arr.length){
                System.out.print(",");
            }
        }
    }


//TWO POINTER IMPLEMENTATION
    public static boolean pairSum(int[] arr, int target){
        int i = 0,j = arr.length-1;
        while (i!=j){
            int     sum = arr[i]+arr[j];
            if (sum==target){
                return true;
            }
            else if (sum<target){
                i++;
            }
            else{
                j--;
            }
        }
        return false;
    }

//SORTING 0s AND 1s
    public static void sort0_1(int[] arr){
        int i = 0, j = arr.length-1;
        while(i<j){
            if (arr[i]==1 && arr[j]==0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            else if(arr[j] == 1){
                j--;
            }
            else if(arr[i] == 0){
                i++;
            }
        }
    }

//SLIDING WINDOW
    public static int subArraySum(int arr[], int k){
        int maxSum = 0, windowSum=0;
        for (int i = 0; i<k; i++){
            windowSum += arr[i];
        }

        for (int j = k; j<arr.length; j++){
            int currentSum = windowSum + arr[j] - arr[j-k]; 
            windowSum = currentSum;
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

//KADANE'S ALGORITHM
    public static int kadane(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i<arr.length; i++){
            currentSum += arr[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
            if (currentSum<0){
                currentSum = 0;
            }
        }

        return maxSum;
    }
//PREFIX SUM IMPLEMENTATION
    public static int[] buildPrefixArray(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i<arr.length; i++){
            prefix[i] = prefix[i-1] + arr[i];

        }
        return prefix;
    }

    public static int rangeSum(int[] prefix, int left, int right){
        if (left==0){
            return prefix[right];
        }
        return prefix[right] - prefix[left-1];
    }


//MAIN FUNCTION
    public static void main(String[] args) {
            int[] arr = {-8, -3, -10, -2, -5}; // Array already sorted hai
            int[] prefix = buildPrefixArray(arr);
            int ans = rangeSum(prefix, 2,4);
            System.out.println(ans);

            
        }

}

