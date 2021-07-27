/**
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree
 * of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree
 * and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class SubTreeOfAnotherTreeExact {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(3);
        root.left = new BinaryTree.Node(4);
        root.right = new BinaryTree.Node(5);
        root.left.left = new BinaryTree.Node(1);
        root.left.right = new BinaryTree.Node(2);
        root.left.right.left = new BinaryTree.Node(0);

        BinaryTree.Node subRoot = new BinaryTree.Node(4);
        subRoot.left = new BinaryTree.Node(1);
        subRoot.right = new BinaryTree.Node(2);

        System.out.println(new SubTreeOfAnotherTreeExact().isSubtree(root, subRoot));

        root = new BinaryTree.Node(3);
        root.left = new BinaryTree.Node(4);
        root.right = new BinaryTree.Node(5);
        root.left.left = new BinaryTree.Node(1);
        root.left.right = new BinaryTree.Node(2);

        subRoot = new BinaryTree.Node(4);
        subRoot.left = new BinaryTree.Node(1);
        subRoot.right = new BinaryTree.Node(2);

        System.out.println(new SubTreeOfAnotherTreeExact().isSubtree(root, subRoot));
    }
    public boolean isSubtree(BinaryTree.Node root, BinaryTree.Node subRoot) {
        if(root == null) return false;
        else if(isSameTree(root, subRoot)) return true;
        else{
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
    }

    public boolean isSameTree(BinaryTree.Node root, BinaryTree.Node subRoot){
        if(root == null || subRoot == null){
            return root == null && subRoot == null;
        }
        else if(root.data == subRoot.data){
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        else{
            return false;
        }
    }
}
