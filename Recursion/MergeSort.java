public class MergeSort{
    public static void mergeSort(int[] arr, int start, int end){
        if (start==end){
            return;
        }

        int mid = start+(end-start)/2; 
        mergeSort(arr, start, mid);//FOR THE LEFT HALF
        mergeSort(arr, mid+1, end);//FOR THE RIGHT HALF

        merge(arr, start, mid, end);
        
    }

    public static void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int i=start, j=mid+1, k=0;

        while(i<=mid && j<=end){
            if (arr[i]<=arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

        while (i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }

        while (j<=end){
            temp[k]=arr[j];
            k++;
            j++;
        }

        for (int l = 0; l<temp.length; l++){
            arr[l+start] = temp[l];
        }
    }
//MAIN FUNCTION
    public static void main(String[] args){
        int[] array = {7,3,1,9,8,2,4,6,5};
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        mergeSort(array, 0, array.length-1);
        System.out.println("Sorted Array:");
        for (int i = 0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}