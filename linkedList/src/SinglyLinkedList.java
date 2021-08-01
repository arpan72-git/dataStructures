public class SinglyLinkedList {
    private Node head;

    static class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }
        public void setData(int data){
            this.data = data;
        }
        public Node getNext(){
            return this.next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    public Node getHead(){
        return this.head;
    }

    public void setHead(Node head){
        this.head = head;
    }

    public static SinglyLinkedList createSinglyLinkedList(int[] data) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        if (data != null && data.length != 0) {
            singlyLinkedList.setHead(new Node(data[0], null));
            Node temp = singlyLinkedList.getHead();
            for (int i = 1; i < data.length; i++) {
                Node newNode = new Node(data[i], null);
                temp.next = newNode;
                temp = newNode;
            }
        }
        return singlyLinkedList;
    }

    public static int count(SinglyLinkedList singlyLinkedList){
        if (singlyLinkedList == null || singlyLinkedList.getHead() == null)
            return 0;

        SinglyLinkedList.Node temp = singlyLinkedList.getHead();
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public static void traverseLinkedList(SinglyLinkedList.Node node){
        while (node!=null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


}
