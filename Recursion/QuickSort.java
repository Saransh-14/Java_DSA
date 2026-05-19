public class QuickSort{
    public static int partition(int[] arr, int start, int end){
        int temp, pivot = arr[end];
        int i = start-1;
        int j = start;
        while (j<end){
            if (arr[j]<=pivot){
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
            j++;
        }
        temp = arr[i+1];
        arr[i+1] = pivot;
        arr[end] = temp;
        return i+1;
    }

    public static void quickSort(int[] arr, int start, int end){

        if (start>=end){
            return;
        }

        int pivot_idx = partition(arr, start, end);
        quickSort(arr, start, pivot_idx-1);
        quickSort(arr, pivot_idx+1, end);
    }

//MAIN FUNCTION
    public static void main(String[] args){
        int[] array = {7,3,1,9,8,2,4,6,5};
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        quickSort(array, 0, array.length-1);
        System.out.println("Sorted Array:");
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}