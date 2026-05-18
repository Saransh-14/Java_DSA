import java.util.ArrayList;

public class PracticeProbs{
//PRINTING BOARD
    public static void printBoard(char[][] board){
        for(int i = 0; i<board.length; i++){
            for (int j = 0; j<board[0].length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }


//STRING PERMUTATIONS
    public static void printPermutes(String str, String ans){
        if (str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i=0; i<str.length(); i++){
            String rem_str = str.substring(0, i) + str.substring(i+1);
            printPermutes(rem_str, ans+str.charAt(i));
        }
    }

//COMBINATION SUM
    public static void findCombinations(int idx, int[] arr, int target, ArrayList<Integer> current){
        if (target == 0){
            System.out.println(current);
            return;
        }

        if (idx>=arr.length || target<0){
            return;
        }

        current.add(arr[idx]);
        findCombinations(idx, arr, target-arr[idx], current);
        current.remove(current.size()-1);

        findCombinations(idx+1, arr, target, current);
    }

//FINDING ALL MATCHES FROM A KEYPAD PHONE
    // 0 aur 1 par koi letters nahi hote, toh unhe khali chorr diya
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void findAllMatches(String digits, int idx, String ans){
        if (idx==digits.length()){
            System.out.println(ans);
            return;
        }

        char currChar = digits.charAt(idx);
        int button = currChar-'0';
        String letters = keypad[button];

        for (int i=0; i<letters.length(); i++){
            findAllMatches(digits, idx+1, ans+letters.charAt(i));
        }
    }

//PALINDROME PARTITIONING
    public static boolean isPalindrome(String str){
        int start = 0, end = str.length()-1;
        while (start<end){
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void partitionPalindrome(String str, int idx, ArrayList<String> current){
        if (idx==str.length()){
            System.out.println(current);
            return;
        }

        for (int i = idx; i<str.length(); i++){
            String part = str.substring(idx, i+1);
            if (isPalindrome(part)){
                current.add(part);
                partitionPalindrome(str, i+1, current);
                current.remove(current.size()-1);
            }
        }
    }

//N-KNIGHTS PROBLEM
    public static boolean isKnightSafe(char[][] board, int row, int col){
        if (row-2>=0){
            if (col-1>=0 && board[row-2][col-1]=='K') return false;
            if (col+1<board.length && board[row-2][col+1]=='K') return false;
        }

        if (col-2>=0){
            if (row-1>=0 && board[row-1][col-2]=='K') return false;
        }
        
        if (col+2<board.length){
            if (row-1>=0 && board[row-1][col+2]=='K') return false;
        }
        return true;
    }

    public static void setKnights(char[][] board, int row, int col, int knightsLeft){
        if (knightsLeft==0){
            printBoard(board);
            System.out.println("-------------------");
            return;
        }

        if (row==board.length){
            return;
        }

        int nextRow = row;
        int nextCol = col+1;
        if (col==board.length-1){
            nextRow = row+1;
            nextCol = 0;
        }

        if (isKnightSafe(board, row, col)){
            board[row][col]='K';
            setKnights(board, nextRow, nextCol, knightsLeft-1);
            board[row][col]='.';
        }

        setKnights(board, nextRow, nextCol, knightsLeft);
    }


//MAIN FUNCTION
    public static void main(String[] args){
        //printPermutes("ABC", "");
        
        // ArrayList<Integer> current = new ArrayList<>();
        // int[] arr = {2,3,5};
        // findCombinations(0, arr, 8, current);

        // findAllMatches("23", 0, "");

        // ArrayList<String> current = new ArrayList<>();
        // partitionPalindrome("aab", 0, current);

        char[][] board = {
            {'.', '.', '.', '.'},
            {'.', '.', '.', '.'},
            {'.', '.', '.', '.'},
            {'.', '.', '.', '.'}  
        };
        setKnights(board, 0, 0, 9);
    }
}