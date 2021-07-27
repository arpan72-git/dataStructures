import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(20);
        root.setLeft(new BinaryTree.Node(8));
        root.setRight(new BinaryTree.Node(22));
        root.getLeft().setLeft(new BinaryTree.Node(5));
        root.getLeft().setRight(new BinaryTree.Node(3));
        root.getLeft().getRight().setLeft(new BinaryTree.Node(10));
        root.getLeft().getRight().setRight(new BinaryTree.Node(14));
        root.getRight().setLeft(new BinaryTree.Node(4));
        root.getRight().setRight(new BinaryTree.Node(25));

        BottomViewOfTree t = new BottomViewOfTree();
        t.bottomView(root);
    }

    class Pair{
        BinaryTree.Node node;
        int distance;
        Pair(BinaryTree.Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public void bottomView(BinaryTree.Node root){
        if (root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));
        BinaryTree.Node temp;
        while (!queue.isEmpty()){
            temp = queue.peek().node;
            int hd = queue.peek().distance;
            queue.remove();

             map.put(hd, temp.getData());

            if (temp.getLeft() != null) queue.add(new Pair(temp.getLeft(), hd-1));
            if (temp.getRight() != null) queue.add(new Pair(temp.getRight(), hd+1));
        }

        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
