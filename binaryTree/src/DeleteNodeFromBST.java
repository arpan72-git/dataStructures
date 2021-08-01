public class DeleteNodeFromBST {

    public static void main(String[] args) {
        BinaryTree.Node root = new BinaryTree.Node(5);
        root.left = new BinaryTree.Node(3);
        root.right = new BinaryTree.Node(6);
        root.left.left = new BinaryTree.Node(2);
        root.left.right = new BinaryTree.Node(4);
        root.right.right = new BinaryTree.Node(7);

        DeleteNodeFromBST d = new DeleteNodeFromBST();
        root = d.deleteNode(root, 4);
        LevelOrderTraversal.levelOrder(root);

    }

    public BinaryTree.Node deleteNode(BinaryTree.Node root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.getData())
            root.left = deleteNode(root.left, key);
        else if(key > root.data)
            root.right = deleteNode(root.right, key);
        else{
            // if node is a leaf node, then simply delete it by returning as null
            if(root.left == null && root.right == null){
                return null;
            }
            BinaryTree.Node temp;
            if(height(root.left) > height(root.right)){
                temp = inOrderPre(root.left);
                root.data = temp.data;
                root.left = deleteNode(root.left, temp.data);
            }
            else{
                temp = inOrderSucc(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }
        return root;
    }

    public int height(BinaryTree.Node root){
        if(root == null) return 0;
        int x = height(root.left);
        int y = height(root.right);
        return  x > y ? x+1 : y+1;
    }

    public BinaryTree.Node inOrderPre(BinaryTree.Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    public BinaryTree.Node inOrderSucc(BinaryTree.Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}