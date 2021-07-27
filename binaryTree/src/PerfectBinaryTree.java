//A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all
// leaves are at same level. example:
//               10
//           /       \
//         20         30
//        /  \        /  \
//      40    50    60   70
public class PerfectBinaryTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(2);
        root.right = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(4);
        root.left.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(6);
        root.right.right = new BinaryTree.Node(7);
        System.out.println("Is perfect binary tree: " + isPerfectBinaryTree(root));
    }

    public static boolean isPerfectBinaryTree(BinaryTree.Node root){
        int d = findDepth(root);
        return isPerfect(root, d, 0);
    }

    public static boolean isPerfect(BinaryTree.Node root, int d, int level){
        // An empty tree is perfect
        if (root == null) return true;

        // If leaf node, then its depth must be same as
        // depth of all other leaves.
        if (root.left == null && root.right == null){
            return d == level+1;
        }

        // If internal node and one child is empty
        if (root.left == null || root.right ==null){
            return false;
        }

        // Left and right subtrees must be perfect.
        return isPerfect(root.left, d, level+1) && isPerfect(root.right, d, level+1);
    }

    public static int findDepth(BinaryTree.Node root){
        if (root == null) return 0;
        int d = 0;
        while (root != null){
            d++;
            root = root.left;
        }
        return d;
    }
}
