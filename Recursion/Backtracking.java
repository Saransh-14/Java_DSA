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

//MAIN FUNCTION
    public static void main(String[] args){
        char[][] board = new char[8][8];
        fillBoard(board);
        queensAboardSafely(board, 0);
        // printBoard(board);
    }

}