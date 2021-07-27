//Given a Singly Linked List which has data members sorted in ascending order. Construct a Balanced Binary Search Tree which has same data members as the given Linked List.
//
//Examples:
//
//Input:  Linked List 1->2->3
//Output: A Balanced BST
//     2
//   /  \
//  1    3
//
//
//Input: Linked List 1->2->3->4->5->6->7
//Output: A Balanced BST
//        4
//      /   \
//     2     6
//   /  \   / \
//  1   3  5   7
//
//Input: Linked List 1->2->3->4
//Output: A Balanced BST
//      3
//    /  \
//   2    4
// /
//1
//
//Input:  Linked List 1->2->3->4->5->6
//Output: A Balanced BST
//      4
//    /   \
//   2     6
// /  \   /
//1   3  5
public class SortedLinkedListToBST {
    static SinglyLinkedList.Node head;
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7};
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.createSinglyLinkedList(data);
        head = singlyLinkedList.getHead();
        int length = CountLengthOfLinkedList.count(singlyLinkedList);
        BinaryTree.Node root = recursivelyCreateBST(length);
        System.out.println();
    }

    private static BinaryTree.Node recursivelyCreateBST(int length){
        if (length <= 0)
            return null;

        BinaryTree.Node left= recursivelyCreateBST(length/2);

        BinaryTree.Node root = new BinaryTree.Node(head.getData());
        head = head.getNext();
        root.setLeft(left);
        BinaryTree.Node right = recursivelyCreateBST(length - length/2 - 1);
        root.setRight(right);

        return root;
    }

}
