public class ReverseKNodesInLinkedLIst {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.createSinglyLinkedList(new int[]{1,2,3,4,5,6,7,8});
        SinglyLinkedList.Node newHead = reverse(singlyLinkedList.getHead(), 3);
        SinglyLinkedList.traverseLinkedList(newHead);
    }

    private static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head, int k){
        if (head == null) return null;
        SinglyLinkedList.Node prev = null, curr = head, next = null;
        int x = 0;
        while (x < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            x++;
        }

        if (next != null){
            head.next = reverse(next, k);
        }

        return prev;
    }
}
