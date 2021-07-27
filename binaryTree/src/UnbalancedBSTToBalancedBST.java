import java.util.ArrayList;
import java.util.List;

public class UnbalancedBSTToBalancedBST {
    public static void main(String[] args) {
        /* Constructed skewed binary tree is
                10
               /
              8
             /
            7
           /
          6
         /
        5   */
        BinaryTree unbalancedBST = new BinaryTree();
        unbalancedBST.setRoot(new BinaryTree.Node(10));
        unbalancedBST.getRoot().setLeft(new BinaryTree.Node(8));
        unbalancedBST.getRoot().getLeft().setLeft(new BinaryTree.Node(7));
        unbalancedBST.getRoot().getLeft().getLeft().setLeft(new BinaryTree.Node(6));
        unbalancedBST.getRoot().getLeft().getLeft().getLeft().setLeft(new BinaryTree.Node(5));

        List<BinaryTree.Node> nodes = new ArrayList<>();
        BinaryTree.inorderTraversal(unbalancedBST.getRoot(), nodes);
        System.out.println(nodes);
        BinaryTree.Node balancedBSTRoot = unbalancedToBalancedBST(nodes, 0, nodes.size() -1);
        System.out.println();
    }

    private static BinaryTree.Node unbalancedToBalancedBST(List<BinaryTree.Node> nodes, int start, int end){
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        BinaryTree.Node root = nodes.get(mid);
        root.setLeft(unbalancedToBalancedBST(nodes, start, mid - 1));
        root.setRight(unbalancedToBalancedBST(nodes, mid + 1, end));

        return root;
    }
}
