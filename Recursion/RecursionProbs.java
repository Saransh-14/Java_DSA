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

//MAIN FUNCTION
    public static void main(String[] args){
        solveTower(3, "A", "B", "C");
    }

}