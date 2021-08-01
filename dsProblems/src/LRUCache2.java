import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {
    Node head, tail;
    Map<Integer, Node> map;
    final int capacity;
    int count;

    public LRUCache2(int capacity){
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.tail.next = null;
        this.tail.prev = head;
        this.head.next = tail;
        this.head.prev = null;
        this.map = new HashMap<>(capacity);
        this.count = 0;
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.set(1, 10);
        lruCache.set(2, 20);
        System.out.println(lruCache.get(1));
        lruCache.set(3, 30);
        System.out.println(lruCache.get(2));
        lruCache.set(4, 40);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));

    }

    private void addNodeToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void deleteNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void set(int key, int value){
        if (!map.containsKey(key)){
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            if (count >= capacity) {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            else {
                count++;
            }
            addNodeToHead(newNode);
        }
        else {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addNodeToHead(node);
        }
    }

    private int get(int key){
        if (map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addNodeToHead(node);
            return node.value;
        }
        return -1;
    }

}

class Node{
    Node prev;
    Node next;
    int key;
    int value;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
