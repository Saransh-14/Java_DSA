public class BasicSorting{
//PRINT ARRAY
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
//BUBBLE SORT
    public static void BubbleSort(int[] arr){
        int temp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

//SELECTION SORT
    public static void SelectionSort(int[] arr){
        int temp;
        for (int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }

            temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

//INSERTION SORT
    public static void InsertionSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int current = arr[i];
            int prev = i-1;

            while(prev>=0 && arr[prev]>current){
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev+1] = current;
        }
    }

//MAIN FUNCTION
    public static void main(String[] args){
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("initial Array:");
        PrintArray(arr);
        InsertionSort(arr);
        System.out.println("\nFinal Array:");
        PrintArray(arr);


    }
}