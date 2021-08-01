//                    20
//                 /     \
//                8      22
//              /   \
//             4    12
//                 /  \
//                10   14
public class LeastCommonAncestorOfTwoNodesInBST {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(20);
        root.left = new BinaryTree.Node(8);
        root.right = new BinaryTree.Node(22);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(12);
        root.left.right.left = new BinaryTree.Node(10);
        root.left.right.right = new BinaryTree.Node(14);

        //first key should be greater than second key
        System.out.println(findLCAOfTwoNodesInBST(root, 10, 14).getData());
        System.out.println(findLCAOfTwoNodesInBST(root, 8, 14).getData());
        System.out.println(findLCAOfTwoNodesInBST(root, 10, 22).getData());

    }

    private static BinaryTree.Node findLCAOfTwoNodesInBST(BinaryTree.Node root, int key1, int key2){
        if (root == null) return null;

        if (key1 < root.data && key2 < root.data)
            return findLCAOfTwoNodesInBST(root.left, key1, key2);
        else if (key1 > root.data && key2 > root.data)
            return findLCAOfTwoNodesInBST(root.right, key1, key2);

        return root;

    }
}
