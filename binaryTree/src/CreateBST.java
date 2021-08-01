import java.util.Scanner;

public class CreateBST {

    public static void main(String[] args) {
        BinaryTree.Node root = null;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Press 1 to enter node to insert");
            System.out.println("Press 2 to exit");
            int ch = scanner.nextInt();
            switch (ch){
                case 1:
                    System.out.print("Enter key to insert : ");
                    int key = scanner.nextInt();
                    root = insertNode(root, key);
                    TreeTraversals.inOrderTraversal(root);
                    System.out.println();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    private static BinaryTree.Node insertNode(BinaryTree.Node root, int key){
        if (root == null){
            return new BinaryTree.Node(key);
        }
        if (key < root.data){
            root.left = insertNode(root.left, key);
        }
        else if (key > root.data){
            root.right = insertNode(root.right, key);
        }
        return root;
    }
}
