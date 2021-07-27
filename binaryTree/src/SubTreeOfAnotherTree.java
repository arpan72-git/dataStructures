import java.util.ArrayList;
import java.util.List;

public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(3);
        root.left = new BinaryTree.Node(4);
        root.right = new BinaryTree.Node(5);
        root.left.left = new BinaryTree.Node(1);
        root.left.right = new BinaryTree.Node(2);

        BinaryTree.Node subRoot = new BinaryTree.Node(4);
        subRoot.left = new BinaryTree.Node(1);
        subRoot.right = new BinaryTree.Node(2);

        SubTreeOfAnotherTree s = new SubTreeOfAnotherTree();
        System.out.println(s.isSubtree(root, subRoot));
    }
    public boolean isSubtree(BinaryTree.Node root, BinaryTree.Node subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        List<Integer> tree = new ArrayList<>();
        preOrder(root, tree);
        List<Integer> subTree = new ArrayList<>();
        preOrder(subRoot, subTree);
        if(!isSubList(tree, subTree))
            return false;

        tree.clear();
        inOrder(root, tree);
        subTree.clear();
        inOrder(subRoot, subTree);
        if(!isSubList(tree, subTree))
            return false;

        return true;
    }

    public void preOrder(BinaryTree.Node root, List<Integer> tree){
        if(root == null) return;

        tree.add(root.data);
        preOrder(root.left, tree);
        preOrder(root.right, tree);
    }

    public void inOrder(BinaryTree.Node root, List<Integer> tree){
        if(root == null) return;

        inOrder(root.left, tree);
        tree.add(root.data);
        inOrder(root.right, tree);
    }

    public boolean isSubList(List<Integer> tree, List<Integer> subTree){
        int i =0;
        boolean isMatched = false;
        int ele = subTree.get(0);
        for(int j = 0; j < tree.size(); j++){
            if (ele == tree.get(j)) {
                if (i == subTree.size() - 1) {
                    isMatched = true;
                    break;
                }
                ele = subTree.get(++i);
            }
        }
        return isMatched;
    }
}
