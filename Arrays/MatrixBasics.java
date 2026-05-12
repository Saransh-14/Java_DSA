import java.util.Scanner;

public class MatrixBasics{
//CREATING MATRIX
    public static int[][] createMatrix(){
        int rows, columns;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        rows = input.nextInt();
        System.out.print("\nEnter the number of columns: ");
        columns = input.nextInt();

        int[][] matrix = new int[rows][columns];
        System.out.print("\nEnter matrix elements: \n");
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                matrix[i][j] = input.nextInt();
            }
        }
        return matrix;
    }

//PRINT MATRIX
    public static void PrintMatrix(int[][] matrix){
        System.out.print("\nThe matrix elements are: \n");
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }  
    }

//PRINT DIAGONAL ELEMENTS
    public static void PrintDMatrix(int[][] matrix){
        System.out.print("\nThe matrix elements are: \n");
        for (int i=0;i<matrix.length;i++){
            System.out.print(matrix[i][i]+" ");
            }
            System.out.println();
        }  
    

//PRINT SPIRALLY
    public static void PrintSpiral(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        int top = 0, left = 0, right = column-1, bottom = row-1;

        while(top <= bottom && left <= right){
            for (int i = left;i<=right;i++){
                System.out.print(matrix[top][i]+" ");
            }
            top++;

            for(int j = top;j<=bottom; j++){
                System.out.print(matrix[j][right]+" ");
            }
            right--;

            if (top <= bottom){
                for(int i = right; i>=left; i--){
                    System.out.print(matrix[bottom][i]+" ");
                }
                bottom--;
            }

            if (left <= right){
                for(int j = bottom; j >= top; j--){
                    System.out.print(matrix[j][left]+" ");
                }
                left++;
            }

        }
    }

//ROTATING A MATRIX 90 DEGREE
    public static void Rotate90(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        int end = column-1, temp;
        //TRANSPOSING
        for(int i = 0;i<row;i++){
            for (int j = i;j<column;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //REVERSING EACH ROW
        for (int i = 0;i<row;i++){
            for (int start = 0;start<row/2;start++){
                temp = matrix[i][start];
                matrix[i][start] = matrix[i][row-start-1];
                matrix[i][row-start-1] = temp;
            }
        }
    }
            
//ROTATING THE MATRIX 90 DEGREE ANTI CLOCKWISE
    public static void RotateAnti90(int[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        int end = column-1, temp;
        //TRANSPOSING
        for(int i = 0;i<row;i++){
            for (int j = i;j<column;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //REVERSING EACH COLUMN
        for (int i = 0;i<column;i++){
            for (int start = 0;start<column/2;start++){
                temp = matrix[start][i];
                matrix[start][i] = matrix[column-start-1][i];
                matrix[column-start-1][i] = temp;
            }
        }
    }

//PERFORMING STAIRCASE SEARCH ON MATRIX
    public static boolean StaircaseSearch(int[][] matrix, int target){
        int row = matrix.length, column = matrix[0].length;
        int i = 0, j = column-1;
        while (i<matrix.length && j>=0){
            int initial = matrix[i][j];
            if (initial==target){
                return true;
            }
            else if(initial > target){
                j--;
            }   
            else{
                i++;
            }
        }
        return false;
    }




//MAIN FUNCTION
    public static void main(String[] args){
        int[][] matrix = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int target = 52;
        boolean found = StaircaseSearch(matrix, target);
        System.out.println(found);
    }
}