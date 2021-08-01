public class TreeTraversals {

    public static void preOrderTraversal(BinaryTree.Node root){
        if (root == null) return;

        System.out.print(root.getData() + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(BinaryTree.Node root){
        if (root == null) return;

        inOrderTraversal(root.left);
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(BinaryTree.Node root){
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.getData() + " ");
    }
}
