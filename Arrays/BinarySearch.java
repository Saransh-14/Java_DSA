public class BinarySearch{
    
    public static int binarysearch(int[] arr, int target){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                return mid;
            }

            else if (target>arr[mid]){
                low = mid+1;
            }

            else{
                high = mid-1;
            }

        }
        return -1;
    }

    public static void main(String[] args){

        int[] array  = {10,20,30,40,50,60,70,80,90,95};
        int target_index = binarysearch(array, 60);
        System.out.println(target_index);

    }
}