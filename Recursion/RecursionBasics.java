public class RecursionBasics{
//FACTORIAL USING RECURSION
    public static int factorial(int n){
        if (n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }

//FIBONACCI USING RECURSION
    public static int fibo(int n){
        if (n==0){
            return 0;
        }
        else if (n==1){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }

//CALCULATING X TO THE POWER N
    public static int pow(int base, int power){
        if (power==0){
            return 1;
        }
        return base*pow(base, power-1);
    }

//CALCULATING X TO THE POWER N IN AN OPTIMIZED WAY
    public static int power_optimized(int base, int power){
        if (power==0){
            return 1;
        }
        int halfpow = power_optimized(base, power/2);
        if (power%2==0){
            return halfpow*halfpow;
        }
        return base*halfpow*halfpow;
    }

//TILING PROBLEM    
    /*
    The tiling problem is a classic dynamic programming question that asks
    for the total number of ways to completely cover a \(2 \times n\) board 
    using \(2 \times 1\) dominoes. Tiles can be placed vertically (\(2 \times 1\)) 
    or horizontally (\(1 \times 2\)), with the goal of finding the number of distinct
     combinations to fill the board without gaps or overlaps.
    */
    public static int tilingProblem(int width){
        if (width == 0){
            return 1;
        }
        else if (width==1){
            return 1;
        }
        return tilingProblem(width-1) + tilingProblem(width-2);
    }

//FRIEND'S PROBLEM
    /*
    The "Friends Pairing Problem" is a classic computer science and 
    combinatorial mathematics question that asks for the total number 
    of ways \(N\) friends can either stay single or be paired up with 
    someone else in a group. 
    */
   public static int Friends(int n){
    if (n==0 || n==1){
        return 1;
    }
    return Friends(n-1) + (n-1)*Friends(n-2);
   }


//MAIN FUNCTION
    public static void main(String[] args){
        int ans = Friends(10);
        System.out.println(ans);  
    }

}
