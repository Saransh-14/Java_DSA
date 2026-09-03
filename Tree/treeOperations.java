public class treeOperations{

        public static int height(Tree.Node n){
            if (n==null) return 0;
            return 1 + Math.max(height(n.left), height(n.right));
        }

        public static int countNode(Tree.Node n){
            if (n==null) return 0;
            return 1 + countNode(n.left) + countNode(n.right);
        }


        public static void main(String[] args){
        Tree.Node root = new Tree.Node(1);
        root.left = new Tree.Node(2);
        root.right = new Tree.Node(3);
        // root.right.right = new Tree.Node(5);
        // root.right.right.right = new Tree.Node(6);
        root.left.right = new Tree.Node(5);
        root.left.left = new Tree.Node(4);

        System.out.println(countNode(root));
    }
}