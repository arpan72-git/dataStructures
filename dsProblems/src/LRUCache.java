import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
    Set<Integer> cache;
    int cacheCapacity;

    public LRUCache(int cacheCapacity){
        this.cache = new LinkedHashSet<>(cacheCapacity);
        this.cacheCapacity = cacheCapacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(4);
        lruCache.referCache(1);
        lruCache.referCache(2);
        lruCache.referCache(3);
        lruCache.referCache(1);
        lruCache.referCache(4);
        lruCache.referCache(5);

        lruCache.display();

    }

    private void referCache(int key){
        if (!cache.contains(key)){
            if (cache.size() == cacheCapacity){
                Integer value = cache.iterator().next();
                cache.remove(value);
            }
        }
        else {
            cache.remove(key);
        }
        cache.add(key);
    }

    private void display(){
        LinkedList<Integer> linkedList = new LinkedList<>(cache);
        Iterator<Integer> iterator = linkedList.descendingIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }


}
