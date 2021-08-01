import java.util.ArrayList;
import java.util.List;

public class CheckBinaryTreeIsBST {
    private BinaryTree.Node prev;
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(3);
        root.setLeft(new BinaryTree.Node(2));
        root.setRight(new BinaryTree.Node(5));
        root.getLeft().setLeft(new BinaryTree.Node(1));
//        root.getLeft().setRight(new BinaryTree.Node(4));
        List<BinaryTree.Node> nodes = new ArrayList<>();
        BinaryTree.inorderTraversal(root, nodes);
        System.out.println("Binary Tree" + nodes);

        CheckBinaryTreeIsBST tree = new CheckBinaryTreeIsBST();
        tree.prev = null;
        System.out.println(tree.isBST(root));
    }

    public boolean isBST(BinaryTree.Node node){
        //every empty tree is a BST
        if (node == null)
            return true;

        if (!isBST(node.getLeft()))
            return false;
        if (prev != null && node.getData() <= prev.getData())
            return false;
        prev = node;
        return isBST(node.getRight());
    }
}
