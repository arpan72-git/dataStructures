public class ReverseKNodesInLinkedLIst {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = SinglyLinkedList.createSinglyLinkedList(new int[]{1,2,3,4,5,6,7,8});
        SinglyLinkedList.Node newHead = reverse(singlyLinkedList.getHead(), 3);

    }

    public static SinglyLinkedList.Node reverse(SinglyLinkedList.Node head, int k){
        int count = 0;
        SinglyLinkedList.Node curr = head, prev = null, next = null, initial = head, pre_initial = null, newHead = null;
        boolean first = true;
        while (curr != null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
            if (count % k ==0){
                newHead = prev;
                if (!first){
                    initial.setNext(prev);
//                    newHead = pre_initial.getNext();

                    initial = pre_initial;
                    pre_initial.setNext(null);
                }
                pre_initial = curr;
                first = false;
            }
        }
        return prev;
    }
}
