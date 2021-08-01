public class CheckTreeIsBalancedOrNot {

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.left.left.left = new BinaryTree.Node(8);

        if (new CheckTreeIsBalancedOrNot().isBalanced(root))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }

    private boolean isBalanced(BinaryTree.Node root){
        if (root == null) return true;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(BinaryTree.Node root){
        if(root == null) return 0;
        int x = height(root.left);
        int y = height(root.right);
        return  x > y ? x+1 : y+1;
    }
}
