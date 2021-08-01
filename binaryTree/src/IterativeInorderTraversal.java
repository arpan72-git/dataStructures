import java.util.Stack;

public class IterativeInorderTraversal {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);

        iterativeInorder(root);
    }

    private static void iterativeInorder(BinaryTree.Node root){
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node t = root;
        while (t != null || !stack.isEmpty()){
            if (t != null){
                stack.push(t);
                t = t.left;
            }
            else {
                t = stack.pop();
                System.out.print(t.data + " ");
                t = t.right;
            }
        }
    }
}
