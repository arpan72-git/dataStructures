import java.util.Stack;

public class IterativePostorderTraversal2 {

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);

        iterativePostorder(root);
    }

    private static void iterativePostorder(BinaryTree.Node root) {
        Stack<BinaryTree.Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) return;

            root = stack.pop();

            if (!stack.isEmpty() && root == stack.peek()) {
                root = root.right;
            } else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }
}
