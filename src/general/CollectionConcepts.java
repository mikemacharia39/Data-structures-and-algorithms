package general;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java Collection Framework Hierarchy
 *
 *                      Iterable
 *                         |
 *                     Collection
 *   ---------------------|-------------------------
 *  |                     |                        |
 * List                 Queue                     Set
 *  |                    | |-PriorityQueue        | |-HashSet
 *  |- Arraylist         |                        | |-LinkedHashSet
 *  |- Linked list ----->|-Deque                  |
 *  |- Vector            |                        |-SortedSer
 *  |    |               |-ArrayDeque             |-TreeSet
 *       |-Stack
 */
public class CollectionConcepts {

    /**
     * Vector implements a dynamic array which means it can grow or shrink as required.
     * Like an array, it contains components that can be accessed using an integer index.
     * They are very similar to ArrayList, but Vector is synchronized
     *
     * Vector is synchronized, which means only one thread at a time can access the code,
     * while ArrayList is not synchronized, which means multiple threads can work on ArrayList at the same time
     *
     * Both ArrayList and Vector are implemented internally as arrays,
     * both are dynamically resized but Vector is has a capacityIncrement of double the current array size where for
     * ArrayList it is half the current size.
     */
    public static void vectors() {
        Vector<String> vector = new Vector<>();
    }

    /**
     * The SortedSet interface extends Set and declares the behavior of a set sorted in ascending order.
     * The SortedSet provides the additional methods that inhibit the natural ordering of the elements.
     */
    public static void sortedSets() {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(23);
        sortedSet.add(12);
        sortedSet.add(16);
        sortedSet.add(5);
        System.out.println(sortedSet.toString());

        sortedSet.forEach(x -> {
            if (x == 1) {

            }
        });

        // reverse sorted set
        SortedSet<Integer> reversed = new TreeSet<>(Collections.reverseOrder());
        reversed.addAll(sortedSet);
        System.out.println(reversed);
    }

    public static void hashMaps() {
        Map<String, Integer> map = new HashMap<>();
        map.put("John", 20);
        map.put("Ken", 19);
        map.put("Ian", 29);
        map.put("Brian", 28);

        sortByKey(map);
        sortByValue(map);
        sortByValueDesc(map);
        sortByKeyAndValue(map);
        extractValuesFromMapIntoList(map);
    }

    public static void sortByKey(Map<String, Integer> map) {
        Map<String, Integer> sorted = new TreeMap<>(map);

        System.out.println("sortByKey: "  + sorted);
    }

    public static void sortByValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("sortByValue: " + sortedMap);
    }

    public static void sortByValueDesc(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("sortByValueDesc: " + sortedMap);
    }

    /**
     * Let's just say, the result is the last sorted statement
     * @param map
     */
    public static void sortByKeyAndValue(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        map.entrySet()
                .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .sorted(Map.Entry.comparingByValue())
                        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("sortByKeyAndValue: " + sortedMap);
    }

    public static void extractValuesFromMapIntoList(Map<String, Integer> map) {

        List<Integer> ages = new ArrayList<>(map.values());

        System.out.println("extractValuesFromMapIntoList: " + ages);
    }

    public static void main(String[] args) {
        CollectionConcepts.sortedSets();

        CollectionConcepts.hashMaps();
    }
}
