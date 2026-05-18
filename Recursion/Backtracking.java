public class Backtracking{
//PRINTING BOARD
    public static void printBoard(char[][] board){
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
//FILLING BOARD
    public static void fillBoard(char[][] board){
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                board[i][j] = '.';
            }
        }
    }

//N-QUEENS WITHOUT CONDITIONS
    public static void queensAboard(char[][] board, int row){
        if (row==board.length){
            printBoard(board);
            System.out.println("--------------");
            return;
        }
        for (int i = 0; i<board[0].length; i++){
            board[row][i] = 'Q';
            queensAboard(board, row+1);
            board[row][i] = '.';

        }
    }

//N-QUEENS WITH CONDITIONS
    /* Condition says that the queeens must be places only in places such that
    none of the queeens is being attacked by neither of the queens,
     */
    //FUNCTION FOR SAFETY CHECK BEFORE PLACING THE QUEEN
    public static boolean isSafe(char[][] board, int row, int col){
        //FOR CHECKING STRAIGHT UPWARDS
        for(int i=row-1; i>=0; i--){
            if (board[i][col] == 'Q') return false;
        }
        //FOR CHECKING ON THE LEFT DIAGONAL
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if (board[i][j]=='Q') return false;
        }
        //FOR CHECKING ON THE RIGHT DIAGONAL
        for (int i=row-1, j=col+1; i>=0 && j<board[0].length; i--,j++){
            if (board[i][j]=='Q') return false;
        }
        return true;
    }

    public static void queensAboardSafely(char[][] board, int row){
        if (row==board.length){
            printBoard(board);
            System.out.println("--------------");
            return;
        }
        for (int i = 0; i<board[0].length; i++){
            if (isSafe(board, row, i)){
                board[row][i] = 'Q';
                queensAboardSafely(board, row+1);
                board[row][i] = '.';
            }

        }
    }

//RAT IN A MAZE PROBLEM
    public static void solveMaze(int[][] maze, boolean[][] visited, int row, int col, String path){

        if (row<0 || col<0 || row>=maze.length || col>=maze[0].length){
            return;
        }
        
        if (maze[row][col]==0 || visited[row][col]==true){
            return;
        }
        
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(path);
            return;
        }
        
        visited[row][col] = true;

        solveMaze(maze, visited, row, col+1, path+"R");
        solveMaze(maze, visited, row+1, col, path+"D");
        solveMaze(maze, visited, row, col-1, path+"L");
        solveMaze(maze, visited, row-1, col, path+"U");

        visited[row][col] = false;
    }

//SUDOKU SOLVER
    public static void printSudokuBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            // Har 3 rows ke baad ek line kichne ke liye (Visual Grid)
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                // Har 3 columns ke baad ek partition line
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*This function will check the safety of the cell and tell whether the cell in safe
    for placing the digit or not
    */
   public static boolean isCellSafe(int[][] board, int row, int col, int digit){
        for(int i = 0; i<board.length; i++){
            if (board[row][i]==digit){
                return false;
            }
        }

        for(int i = 0; i<board.length; i++){
            if (board[i][col]==digit){
                return false;
            }
        }

        int s_row = (row/3)*3;
        int s_col = (col/3)*3;
        for (int j = s_row; j<s_row+3; j++){
            for (int k = s_col; k<s_col+3; k++){
                if (board[j][k]==digit){
                    return false;
                }
            }
        }

        return true;
   }

   public static boolean sudokuSolver(int[][] board, int row, int col){

        if (row==9){
            printSudokuBoard(board);
            return true;
        }

        int nextRow = row;
        int nextCol = col+1;
        if (col==8){
            nextRow = row+1;
            nextCol = 0;
        }

        if (board[row][col] != 0){
            return sudokuSolver(board, nextRow, nextCol);
        }

        for (int digit = 1; digit<=9; digit++){
            if (isCellSafe(board, row, col, digit)){
                board[row][col] = digit;

                if (sudokuSolver(board, nextRow, nextCol)) return true;

                board[row][col] = 0;
            }
        }

        return false;
   }


//MAIN FUNCTION
public static void main(String[] args) {
    // 0 ka matlab hai KHALI CELL (Empty Space)
    int[][] sudoku = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    System.out.println("--- Puraana Unsolved Sudoku ---");
    printSudokuBoard(sudoku);
    System.out.println("\n--- Solving using Backtracking... ---");

    if (sudokuSolver(sudoku, 0, 0)) {
        System.out.println("\n--- Bawaal! Sudoku Solved Successfully! ---");
        // printSudokuBoard(sudoku);
    } else {
        System.out.println("Bhai, is Sudoku ka koi solution nahi mila.");
    }

    }

}