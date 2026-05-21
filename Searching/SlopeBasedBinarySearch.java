public class SlopeBasedBinarySearch{
    public static int mountainSearch(int[] arr){
        int start = 0, end = arr.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (arr[mid] < arr[mid+1]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
//MAIN FUNCTION
    public static void main(String[] args){
        int[] arr = {1, 3, 6, 22, 4, 2, 0};
        System.out.println(mountainSearch(arr));
    }
}