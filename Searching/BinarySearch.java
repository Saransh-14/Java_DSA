public class BinarySearch{
//BINARY SEARCH
    public static int binarySearch(int[] arr, int start, int end, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid]==target) return mid;
            else if (arr[mid]<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }


//BINARY SEARCH USING RECURSION
    public static int recursiveBinarySearch(int[] arr, int start, int end, int target){
        if (start>end) return -1;
        int mid = start + (end-start)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid]>target) return recursiveBinarySearch(arr, start, mid-1, target);
        else return recursiveBinarySearch(arr, mid+1, end, target);
    }

//MAIN FUNCTION 
    public static void main(String[] args){
        int[] arr = {2, 4, 6, 8, 10, 12};
        int idx = recursiveBinarySearch(arr, 0, arr.length-1, 12);
        System.out.println(idx);
    }
}