//                    1
//                 /     \
//                2      3
//              /   \  /   \
//             4    5 6     7
public class LeastCommonAncestorOfTwoNodesInSimpleBinaryTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);

        System.out.println(findLCA(root, 4, 5).getData());
        System.out.println(findLCA(root, 4, 6).getData());
        System.out.println(findLCA(root, 3, 4).getData());
        System.out.println(findLCA(root, 2, 4).getData());

    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    private static BinaryTree.Node findLCA(BinaryTree.Node node, int n1, int n2)
    {
        if (node == null) return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        BinaryTree.Node left_lca = findLCA(node.left, n1, n2);
        BinaryTree.Node right_lca = findLCA(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca!=null && right_lca!=null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
}
