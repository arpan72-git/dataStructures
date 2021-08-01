public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.createSinglyLinkedList(new int[]{1,2,3,4,5,6,7,8});
        SinglyLinkedList.Node newHead = reverse(singlyLinkedList.getHead());
        SinglyLinkedList.traverseLinkedList(newHead);
    }

    private static SinglyLinkedList.Node reverse(SinglyLinkedList.Node node){
        if (node == null) return null;

        SinglyLinkedList.Node prev = null, curr = node, next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }
}
