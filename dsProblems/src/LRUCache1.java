import java.util.*;

public class LRUCache1 {
    Set<Integer> set;
    Deque<Integer> doublyQueue;
    int cache_capacity;

    public LRUCache1(int cache_capacity){
        this.set = new LinkedHashSet<>(cache_capacity);
        this.doublyQueue = new LinkedList<>();
        this.cache_capacity = cache_capacity;
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(4);
        lruCache.refer(1);
        lruCache.refer(2);
        lruCache.refer(3);
        lruCache.refer(1);
        lruCache.refer(4);
        lruCache.refer(5);
        lruCache.refer(2);
        lruCache.refer(2);
        lruCache.refer(1);
        lruCache.display();
    }

    private void refer(int page){
        if (!set.contains(page)){
            if (doublyQueue.size() == cache_capacity){
                int last = doublyQueue.removeLast();
                set.remove(last);
            }
        }
        else {
            doublyQueue.remove(page);
        }

        doublyQueue.addFirst(page);
        set.add(page);
    }

    private void display(){
        Iterator<Integer> iterator = doublyQueue.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

}
