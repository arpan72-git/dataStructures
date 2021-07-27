public class SumOfDataOfNodesOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(new BinaryTree.Node(1));
        binaryTree.getRoot().setLeft(new BinaryTree.Node(8));
        binaryTree.getRoot().getLeft().setLeft(new BinaryTree.Node(7));
        binaryTree.getRoot().getLeft().getLeft().setLeft(new BinaryTree.Node(6));
        binaryTree.getRoot().getLeft().getLeft().getLeft().setLeft(new BinaryTree.Node(5));

        System.out.println(sumOfBinaryTreeNodes(binaryTree.getRoot()));
    }

    private static int sumOfBinaryTreeNodes(BinaryTree.Node node){
        if (node == null)
            return 0;
        int x = sumOfBinaryTreeNodes(node.getLeft());
        int y = sumOfBinaryTreeNodes(node.getRight());
        return x + y + node.getData();
    }
}
