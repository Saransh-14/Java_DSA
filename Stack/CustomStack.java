public class CustomStack{
    protected int[] stack;
    private int top = -1;

    public CustomStack(int size){
        this.stack = new int[size];
    }

    public boolean push(int val){
        if (top==stack.length-1){
            System.out.println("Stack 0verflow");
            return false;
        }
        top++;
        stack[top] = val;
        return true;
    }

    public int pop(){
        if (top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = stack[top];
        top--;
        return val;
    }

    public int peek(){
        if (top==-1){
            return -1;
        }
        return stack[top];
    }

//MAIN FUNCTION
    public static void main(String[] args){
        CustomStack st = new CustomStack(5);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(20);
        st.push(30);
        st.push(30);

        // Test Case 2: 4th element daalenge toh Overflow hona chahiye
        st.push(40); // Output: Stack Overflow aana chahiye!

        
        System.out.println("Top element: " + st.peek()); // Output: 30

        
        System.out.println("Popped: " + st.pop()); // Output: 30
        System.out.println("Popped: " + st.pop()); // Output: 20
        System.out.println("Popped: " + st.pop()); // Output: 10

        
        System.out.println("Popped: " + st.pop());
    }
}