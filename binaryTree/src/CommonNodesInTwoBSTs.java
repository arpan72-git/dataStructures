import java.util.Stack;

public class CommonNodesInTwoBSTs {

    public static void main(String[] args) {
        BinaryTree.Node root1 = new BinaryTree.Node(5);
        root1.left = new BinaryTree.Node(1);
        root1.right = new BinaryTree.Node(10);
        root1.left.left = new BinaryTree.Node(0);
        root1.left.right = new BinaryTree.Node(4);
        root1.right.left = new BinaryTree.Node(7);
        root1.right.left.right = new BinaryTree.Node(9);

        BinaryTree.Node root2 = new BinaryTree.Node(10);
        root2.left = new BinaryTree.Node(7);
        root2.right = new BinaryTree.Node(20);
        root2.left.left = new BinaryTree.Node(4);
        root2.left.right = new BinaryTree.Node(9);

        printCommonNodes(root1, root2);
    }

    private static void printCommonNodes(BinaryTree.Node root1, BinaryTree.Node root2){
        Stack<BinaryTree.Node> stack1 = new Stack<>();
        Stack<BinaryTree.Node> stack2 = new Stack<>();

        while (true){
            if (root1 != null){
                stack1.add(root1);
                root1 = root1.left;
            }
            else if (root2 != null){
                stack2.add(root2);
                root2 = root2.left;
            }
            else if (!stack1.isEmpty() && !stack2.isEmpty()){
                root1 = stack1.peek();
                root2 = stack2.peek();

                if (root1.data == root2.data){
                    System.out.println(root1.data);
                    stack1.pop();
                    stack2.pop();
                    root1 = root1.right;
                    root2 = root2.right;
                }
                else if (root1.data < root2.data){
                    stack1.pop();
                    root1 = root1.right;
                    root2 = null;
                }
                else {
                    stack2.pop();
                    root2 = root2.right;
                    root1 = null;
                }
            }
            else {
                break;
            }
        }
    }
}
