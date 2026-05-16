class RecursionProbs{
//TOWER OF HANOI USING RECURSION
    public static void solveTower(int n, String src, String helper, String dest){
        if (n==1){
            System.out.println("transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        solveTower(n-1,src, dest, helper);
        System.out.println("transfer disk " + n + " from " + src + " to " + dest);
        solveTower(n-1, helper, src, dest);
    }

//COUNTING GRID PATHS
    public static int countGridPath(int init_row, int init_col, int goal_row, int goal_col){
        int right_path = 0, down_path = 0;
        if (init_row == goal_row-1 && init_col==goal_col-1){
            return 1;
        }
        else if(init_row >= goal_row || init_col>=goal_col){
            return 0;
        }
        right_path = countGridPath(init_row, init_col+1, goal_row, goal_col);
        down_path = countGridPath(init_row+1, init_col, goal_row, goal_col);
        return right_path+down_path;
    }

//FINDING TARGET SUM
    public static int targetSum(int[] arr, int idx, int currSum, int target){
        if (idx == arr.length){
            if (currSum == target){
                return 1;
            }
            return 0;
        }
        int value_included = targetSum(arr, idx+1, currSum+arr[idx], target);
        int value_discluded = targetSum(arr, idx+1, currSum, target);
        return value_discluded+value_included;
    }


//MAIN FUNCTION
    public static void main(String[] args){
        // solveTower(3, "A", "B", "C");

        // int totalPath = countGridPath(0,0,3,3);
        // System.out.println(totalPath);

        int[] arr = {1,2,3,0};
        int totalWays = targetSum(arr, 0, 0, 3);
        System.out.println(totalWays);
    }

}