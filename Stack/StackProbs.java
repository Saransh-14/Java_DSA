import java.util.Stack;

public class StackProbs{
//REVERSING A STRING USING STACK
    public static String reverseString(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<s.length(); i++){
            st.push(s.charAt(i));
        }
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }

//CHECKING BALANCE OF BRACKETS
    public static boolean isMatchingPair(char a, char b){
        if (a=='(' && b==')') return true;
        if (a=='{' && b=='}') return true;
        if (a=='[' && b==']') return true;
        return false;
    }
    public static boolean balanceBrackets(String s){
        Stack<Character> stack = new Stack<>();
        String openBrackets = "({[";
        for (int i = 0; i<s.length(); i++){
            if (openBrackets.indexOf(s.charAt(i))!=-1){
                stack.push(s.charAt(i));
            }
            else{
                if (stack.isEmpty()) return false;
                char bracket = stack.peek();
                if (isMatchingPair(bracket, s.charAt(i))) stack.pop();
                else return false;                
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }

//DELETING MIDDLE ELEMENT OF A STACK WITHOUT USING ANY OTHER JAVA COLLECTION
    public static void solve(Stack<Integer> st, int current, int target){
        if (current==target){
            st.pop();
            return;
        }
        int val = st.pop();
        solve(st, current+1, target);
        st.push(val);
    }

    public static void deleteMiddle(Stack<Integer> st){
        int size = st.size();
        int middleTarget = size/2;

        solve(st, 0, middleTarget);
    }


//MAIN FUNCTION
    public static void main(String[] args){
        // System.out.println(reverseString("SARANSH"));

        // System.out.println(balanceBrackets("{[()]}")); // Output: true
        // System.out.println(balanceBrackets("{[(])}"));

        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        System.out.println("Before: " + st); // [10, 20, 30, 40, 50]
        deleteMiddle(st);
        System.out.println("After:  " + st); // [10, 20, 40, 50] (30 saaf!
    }
}