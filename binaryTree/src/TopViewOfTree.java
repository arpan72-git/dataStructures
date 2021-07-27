import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.setLeft(new BinaryTree.Node(2));
        root.setRight(new BinaryTree.Node(3));
        root.getLeft().setLeft(new BinaryTree.Node(4));
        root.getLeft().setRight(new BinaryTree.Node(5));
        root.getRight().setLeft(new BinaryTree.Node(6));
        root.getRight().setRight(new BinaryTree.Node(7));

        TopViewOfTree t = new TopViewOfTree();
        t.topView(root);
    }

    class Pair{
        BinaryTree.Node node;
        int distance;
        Pair(BinaryTree.Node node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public void topView(BinaryTree.Node root){
        if (root == null) return;

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        queue.add(new Pair(root, 0));
        BinaryTree.Node temp;
        while (!queue.isEmpty()){
            temp = queue.peek().node;
            int hd = queue.peek().distance;
            queue.remove();

            if (map.get(hd) == null) map.put(hd, temp.getData());

            if (temp.getLeft() != null) queue.add(new Pair(temp.getLeft(), hd-1));
            if (temp.getRight() != null) queue.add(new Pair(temp.getRight(), hd+1));
        }

        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }
}
