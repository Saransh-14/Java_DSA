public class treeOperations{
//TO CALCULATE THE HEIGHT OF THE TREE
    public static int height(Tree.Node n){
        if (n==null) return 0;
        return 1 + Math.max(height(n.left), height(n.right));
    }

//TO COUNT THE TOTAL NUMBER OF NODES IN THE TREE
    public static int countNode(Tree.Node n){
        if (n==null) return 0;
        return 1 + countNode(n.left) + countNode(n.right);
    }

//TO GET THE SUM OF ALL NODES INSIDE A TREE
    public static int sumNode(Tree.Node n){
        if (n==null) return 0;
        return n.data + sumNode(n.left) + sumNode(n.right);
    }

//TO FIND THE DIAMETER OF THE TREE
    static int maxDiameter = 0;
    public static int diameter(Tree.Node n){
        if (n==null) return 0;
        int lh = diameter(n.left);
        int rh = diameter(n.right);
        maxDiameter = Math.max(maxDiameter, rh+lh);
        return 1 + Math.max(lh, rh);
    }

    public static int calDiameter(Tree.Node n){
        maxDiameter = 0;
        diameter(n);
        return maxDiameter;
    }

//TO CHECK IF THE TREE IS BALANCED OR NOT
    public static int checkBalance(Tree.Node n){
        if (n==null) return 0;

        int lh = checkBalance(n.left);
        if (lh==-1) return -1;
        
        int rh = checkBalance(n.right);
        if (rh==-1) return -1;

        if (Math.abs(lh-rh) > 1) return -1;

        return 1 + Math.max(lh, rh);
    }

    public static boolean isBalance(Tree.Node n){
        return checkBalance(n) != -1;
    }

//MAIN FUNCTION
    public static void main(String[] args){
        Tree.Node root = new Tree.Node(5);
        root.left = new Tree.Node(3);
        root.right = new Tree.Node(8);
        // root.right.right = new Tree.Node(5);
        // root.right.right.right = new Tree.Node(6);
        root.left.right = new Tree.Node(4);
        root.left.left = new Tree.Node(2);
        root.left.left.left = new Tree.Node(9);

        System.out.println(isBalance(root));
    }
}