import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(12);
        set.add(1);
        set.add(3);
        set.add(0);
        System.out.println(set);
        Set<Dog> set1 = new TreeSet<>();
        set1.add(new Dog(12));
        set1.add(new Dog(1));
        set1.add(new Dog(3));
        set1.add(new Dog(0));
        System.out.println(set1);
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(5,8);
        map.put(3,8);
        map.put(8,8);
        map.put(0,8);
        System.out.println(map);

        System.out.println(Stream.of("n","c","i","a").sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
