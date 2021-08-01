import java.util.Stack;

public class IterativePreorderTraversal {

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);

        iterativePreorder(root);
    }
    private static void iterativePreorder(BinaryTree.Node root){
        Stack<BinaryTree.Node> stack = new Stack<>();
        BinaryTree.Node t = root;
        while (t!= null || !stack.isEmpty()){
            if (t != null){
                System.out.print(t.data + " ");
                stack.push(t);
                t = t.left;
            }
            else {
                t = stack.pop();
                t = t.right;
            }
        }
    }
}
