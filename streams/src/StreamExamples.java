import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        lists.add(list);
        list = new ArrayList<>();
        list.add(3);
        list.add(4);
        lists.add(list);
        list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(7);
        lists.add(list);
        System.out.println(lists);
        System.out.println(lists.stream().flatMap(Collection::stream).collect(Collectors.toList()));
        Map<Integer , List<String>> map = new HashMap<>();
        map.put(1, Arrays.asList("A", "B", "C"));
        map.put(2, Arrays.asList("A", "B", "C"));
        map.put(3, Arrays.asList("A", "B", "C"));
        map.put(4, Arrays.asList("A", "B", "C"));
        map.keySet().stream().map(integer -> integer %2 ==0).collect(Collectors.toMap())
        System.out.println(map.entrySet().stream().map(stringListEntry -> new AbstractMap.SimpleEntry<>(stringListEntry.getKey(), stringListEntry.getValue()))
                .filter(stringListSimpleEntry -> stringListSimpleEntry.getKey() %2 ==0).collect(Collectors.toMap(integerListSimpleEntry -> integerListSimpleEntry.getKey(), integerListSimpleEntry -> integerListSimpleEntry.getValue())));
        System.out.println(map);
    }
}
