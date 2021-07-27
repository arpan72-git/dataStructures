public class CountLengthOfLinkedList {
    public static int count(SinglyLinkedList singlyLinkedList){
        if (singlyLinkedList == null || singlyLinkedList.getHead() == null)
            return 0;
//        if (singlyLinkedList.getHead().getNext() == null)
//            return 0;

        SinglyLinkedList.Node temp = singlyLinkedList.getHead();
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
