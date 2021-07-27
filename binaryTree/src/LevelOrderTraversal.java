import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(5);
        root.left = new BinaryTree.Node(3);
        root.right = new BinaryTree.Node(6);
        root.left.left = new BinaryTree.Node(2);
        root.left.right = new BinaryTree.Node(4);
        root.right.right = new BinaryTree.Node(7);
        LevelOrderTraversal.levelOrder(root);
    }

    public static void levelOrder(BinaryTree.Node root){
        if (root == null) System.out.println("No node in tree");

        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTree.Node parent = queue.remove();
            System.out.print(parent.getData() + " ");

            if (parent.getLeft() != null) queue.add(parent.getLeft());
            if (parent.getRight() != null) queue.add(parent.getRight());
        }

    }
}
