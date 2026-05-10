public class ArrayReverse{

    public static void PrintArr(int[] arr){
        int i = 0;
        while(i<arr.length){
             System.out.print(arr[i]);
            i++;
            if(i<arr.length){
                System.out.print(",");
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {15};
        int start=0, end=(arr.length-1), temp, i=0;

        System.out.println("Initial Array:");
        PrintArr(arr);

        while(start<end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.println("\nFinal Reversed Array:");
        PrintArr(arr);
    }
}