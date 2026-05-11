public class BinarySearch{
//BASIC BINARY SEARCH LOGIC
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

//OCCURANCE CHECKING VARIATION OF BINARY SEARCH
    public static int findFirst(int[] arr, int target){
        int low=0, high=arr.length-1, ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                high = mid-1;
            }

            else if (target>arr[mid]){
                low = mid+1;
            }

            else{
                high = mid-1;
            }

        }
        return ans; 
    }

    public static int findLast(int[] arr, int target){
        int low=0, high=arr.length-1, ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                ans = mid;
                low = mid+1;
            }

            else if (target>arr[mid]){
                low = mid+1;
            }

            else{
                high = mid-1;
            }

        }
        return ans; 
    }

//ROTATED SORTED ARRAY
    public static int searchRotated(int[] arr, int target){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == target){
                return mid;
            }

            else if (arr[low]<=arr[mid]){
                if (target>=arr[low] && target<=arr[mid]){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }

            else{
                if (target<=arr[high] && target>=arr[mid]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
                
            }

        }
        return -1;
    }


    public static void main(String[] args){

        int[] array  = {4,5,6,7,0,1,2};
        int target_index = searchRotated(array, 6);
        System.out.println("target index:"+target_index);
        // System.out.println("first index: "+first_index+"\nlast index: "+last_index);

    }
}