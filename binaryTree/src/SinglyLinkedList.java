public class SinglyLinkedList {
    private Node head;

    static class Node{
        private int data;
        private Node next;
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


}
