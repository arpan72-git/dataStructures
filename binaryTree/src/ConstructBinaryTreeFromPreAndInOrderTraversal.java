import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndInOrderTraversal {
    private static Map<Integer, Integer> inOrderMap = new HashMap<>();
    private static int pre_index = 0;
    public static void main(String[] args) {
        int[] preOrder = new int[]{1,2,4,5,3,6,7};
        int[] inOrder = new int[]{4,2,5,1,6,3,7};

        BinaryTree.Node root = constructBinaryTreeWrap(preOrder, inOrder, 7);
        System.out.println("PreOrder : "); TreeTraversals.preOrderTraversal(root);
        System.out.println("InOrder : ");  TreeTraversals.inOrderTraversal(root);
    }

    private static BinaryTree.Node constructBinaryTreeWrap(int[] preOrder, int[] inOrder, int len){
            for (int i=0; i< len; i++){
                inOrderMap.put(inOrder[i], i);
            }
            return constructBinaryTree(preOrder, 0, len-1);
    }

    private static BinaryTree.Node constructBinaryTree(int[] preOrder, int in_start, int in_end){
        if (in_start > in_end) return  null;

        /* Pick current node from Preorder traversal using preIndex and increment preIndex */
        int curr = preOrder[pre_index++];
        BinaryTree.Node node = new BinaryTree.Node(curr);

        /* If this node has no children then return */
        if (in_start == in_end) return node;

        /* Else find the index of this node in Inorder traversal */
        int in_curr = inOrderMap.get(curr);

        /* Using index in Inorder traversal, construct left and right subtrees */
        node.left = constructBinaryTree(preOrder, in_start, in_curr-1);
        node.right = constructBinaryTree(preOrder, in_curr+1, in_end);

        return node;
    }
}
