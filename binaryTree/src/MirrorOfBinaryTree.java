import java.util.ArrayList;
import java.util.List;

public class MirrorOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(new BinaryTree.Node(1));
        binaryTree.getRoot().setLeft(new BinaryTree.Node(2));
        binaryTree.getRoot().setRight(new BinaryTree.Node(3));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTree.Node(4));
        binaryTree.getRoot().getLeft().setRight(new BinaryTree.Node(5));

        List<BinaryTree.Node> nodes = new ArrayList<>();
        BinaryTree.Node newRoot = mirror(binaryTree.getRoot());
        BinaryTree.inorderTraversal(newRoot, nodes);
        System.out.println(nodes);
    }

    public static BinaryTree.Node mirror(BinaryTree.Node root){
        if (root == null)
            return null;
        else {
            BinaryTree.Node left = mirror(root.getLeft());
            BinaryTree.Node right = mirror(root.getRight());

            root.setLeft(right);
            root.setRight(left);
            return root;
        }
    }
}
