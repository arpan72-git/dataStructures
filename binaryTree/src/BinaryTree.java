import java.util.List;

public class BinaryTree {
    private Node root;

    static class Node{
        public int data;
        public Node left;
        public Node right;

        Node(int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String  toString(){
            return this.data + "";
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public static void inorderTraversal(BinaryTree.Node node, List<BinaryTree.Node> nodes){
        if (node == null)
            return;
        inorderTraversal(node.left, nodes);
        nodes.add(node);
        inorderTraversal(node.right, nodes);
    }
}
