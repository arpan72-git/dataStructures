import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PrintTreeInVerticalOrderWay2 {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.setLeft(new BinaryTree.Node(2));
        root.setRight(new BinaryTree.Node(3));
        root.getLeft().setLeft(new BinaryTree.Node(4));
        root.getLeft().setRight(new BinaryTree.Node(5));
        root.getRight().setLeft(new BinaryTree.Node(6));
        root.getRight().setRight(new BinaryTree.Node(7));

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        PrintTreeInVerticalOrderWay2 p = new PrintTreeInVerticalOrderWay2();
        p.printVerticalOrder(root, 0, map);
        for (Integer key : map.keySet()){
            System.out.println(map.get(key));
        }
    }

    public void printVerticalOrder(BinaryTree.Node node, int hd, Map<Integer, ArrayList<Integer>> map){
        if (node == null) return;

        ArrayList<Integer> values = map.get(hd);
        if (values == null) values = new ArrayList<>();
        values.add(node.getData());
        map.put(hd, values);

        printVerticalOrder(node.getLeft(), hd-1, map);
        printVerticalOrder(node.getRight(), hd+1, map);
    }
}
