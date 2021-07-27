import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(10);
        root.setLeft(new BinaryTree.Node(2));
        root.setRight(new BinaryTree.Node(3));
        root.getLeft().setLeft(new BinaryTree.Node(7));
        root.getLeft().setRight(new BinaryTree.Node(8));
        root.getRight().setRight(new BinaryTree.Node(15));
        root.getRight().setLeft(new BinaryTree.Node(12));
        root.getRight().getRight().setLeft(new BinaryTree.Node(14));

        LeftViewOfTree l = new LeftViewOfTree();
        l.leftView(root);
    }

    public void leftView(BinaryTree.Node root){
        if (root == null) return;

        Queue<BinaryTree.Node> queue = new LinkedList<>();
        queue.add(root);
        BinaryTree.Node temp;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i= 1; i<= size; i++){
                temp = queue.remove();
                if (i ==1)
                    System.out.println(temp.getData());

                if (temp.getLeft() != null) queue.add(temp.getLeft());
                if (temp.getRight() != null) queue.add(temp.getRight());
            }
        }
    }
}
