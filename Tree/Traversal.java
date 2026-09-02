public class Traversal{

    public static void inorder(Tree.Node n){
        if (n==null) return;
        inorder(n.left);
        System.out.print(n.data + " -> ");
        inorder(n.right);
    }

    public static void preorder(Tree.Node n){
        if (n==null) return;
        System.out.print(n.data + " -> ");
        preorder(n.left);
        preorder(n.right);
    }

    public static void postorder(Tree.Node n){
        if (n==null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data + " -> ");
    }
    
    public static void main(String[] args){
        Tree.Node root = new Tree.Node(1);
        root.left = new Tree.Node(2);
        root.right = new Tree.Node(3);
        root.left.left = new Tree.Node(4);

        inorder(root);
        System.out.println("\n");
        preorder(root);
        System.out.println("\n");
        postorder(root);
    }
}