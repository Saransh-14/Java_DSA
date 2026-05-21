public class FirstAndLastidx{
    public static int findFirst(int[] arr, int target){
        int start = 0,  end = arr.length-1, ans = -1;
        while (start<=end){
            int new_mid = start + (end-start)/2;
            if (arr[new_mid]==target){ 
                ans = new_mid;
                end = new_mid-1;
            }
            else if(arr[new_mid]<target) start = new_mid+1;
            else end = new_mid-1;
        }
        return ans;
    }
    public static int findLast(int[] arr, int target){
        int start = 0,  end = arr.length-1, ans = -1;
        while (start<=end){
            int new_mid = start + (end-start)/2;
            if (arr[new_mid]==target){ 
                ans = new_mid;
                start = new_mid+1;
            }
            else if(arr[new_mid]<target) start = new_mid+1;
            else end = new_mid-1;
        }
        return ans;
    }

//MAIN FUNCTION
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int target = 5;
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        System.out.println(first);
        System.out.println(last);
    }
}