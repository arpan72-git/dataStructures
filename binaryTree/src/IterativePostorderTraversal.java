import java.util.Stack;

public class IterativePostorderTraversal {

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

    static class Pair{
        int key;
        BinaryTree.Node node;

        public Pair(int key, BinaryTree.Node node){
            this.key = key;
            this.node = node;
        }
    }

    private static void iterativePostorder(BinaryTree.Node root){
        Stack<Pair> stack = new Stack<>();
        BinaryTree.Node t = root;
        while (t!= null || !stack.isEmpty()){
            Pair p;
            if (t != null){
                stack.push(new Pair(0, t));
                t = t.left;
            }
            else {
                p = stack.pop();
                if (p.key == 0){
                    stack.push(new Pair(1, p.node));
                    t = p.node.right;
                }
                else {
                    System.out.print(p.node.data + " ");
                }
            }
        }
    }
}
