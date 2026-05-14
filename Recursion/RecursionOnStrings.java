public class RecursionOnStrings{
//REMOVING DUPLICATES
    public static void RemoveDupes(String str, int idx, StringBuilder newStr, boolean tracker[]){
        if (idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if (tracker[currChar - 'a']==false){
            newStr.append(currChar);
            tracker[currChar-'a'] = true;
        }
        RemoveDupes(str, idx+1, newStr, tracker);
    }

//FINDING ALL POSSIBLE SUBSETS OF A STRING
    public static void subSets(String str, int idx, String newStr){
        if (idx==str.length()){
            System.out.println(newStr);
            return;
        }
        subSets(str, idx+1, newStr+str.charAt(idx));
        subSets(str, idx+1, newStr);
    }

//FINDING ALL POSSIBLE COMBINATION OF A STRING
    public static void findPermutations(String str, String ans){
        if (str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i<str.length();i++){
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutations(newStr, ans + currChar);
        }
    }

//PRINTING BINARY STRINGS WITH NO CONSECUTIVE ONE'S
    public static void printBinString(int n, int lastPlace, String str){
        if (n==0){
            System.out.println(str);
            return;
        }
        printBinString(n-1,0,str+"0");
        if (lastPlace==0){
            printBinString(n-1,1,str+"1");
        }
    }


//MAIN FUNCTION
    public static void main(String[] args){
        solveTower(3,'A','B','C');
    }


}
