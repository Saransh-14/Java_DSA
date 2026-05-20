public class QuickSelect{
//QUICK SELECT
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i = start -1;
        for (int j = start; j<end; j++){
            if (arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return i+1;

    }

    public static int quickSelect(int[] arr, int start, int end, int k){
        
        if (start==end){
            return arr[start];
        }
        
        int pIdx = partition(arr, start, end);

        if (k<pIdx){
            return quickSelect(arr, start, pIdx-1, k);
        }
        else if(k==pIdx){
            return arr[pIdx];
        }
        else{
            return quickSelect(arr, pIdx+1, end, k);
        }
    }
//MAIN FUNCTION
    public static void main(String[] args){
        int[] arr = {7, 10, 4, 3, 20, 15, 17};
        System.out.println(quickSelect(arr, 0, arr.length-1, 5));
    }
}