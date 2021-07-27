public class PrintTreeInVerticalOrderWay1 {
    int max, min;

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(1);
        root.setLeft(new BinaryTree.Node(2));
        root.setRight(new BinaryTree.Node(3));
        root.getLeft().setLeft(new BinaryTree.Node(4));
        root.getLeft().setRight(new BinaryTree.Node(5));
        root.getRight().setLeft(new BinaryTree.Node(6));
        root.getRight().setRight(new BinaryTree.Node(7));

        PrintTreeInVerticalOrderWay1 p = new PrintTreeInVerticalOrderWay1();
        p.findMinMaxHorizontalDistance(root, 0, p);
        for (int line_no = p.min; line_no <= p.max; line_no++ ){
            p.findVerticalOrder(root, 0, line_no);
        }
    }
    void findMinMaxHorizontalDistance(BinaryTree.Node root, int hd, PrintTreeInVerticalOrderWay1 p){
        if (root == null)
            return;

        if (hd < p.min) p.min = hd;
        if (hd > p.max) p.max = hd;

        findMinMaxHorizontalDistance(root.getLeft(), hd-1, p);
        findMinMaxHorizontalDistance(root.getRight(), hd+1, p);
    }

    void findVerticalOrder(BinaryTree.Node node, int hd, int line_no){
        if (node == null) return;

        if (hd == line_no) System.out.println(node.getData());

        findVerticalOrder(node.getLeft(), hd-1, line_no);
        findVerticalOrder(node.getRight(), hd+1, line_no);
    }
}
