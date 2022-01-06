package leettests.maps;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortMap {

    public Map<String, Integer> sortByValue(Map<String, Integer> map) {

        System.out.println("Unsorted Map : " + map);

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        // Sort in asc by value
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sort in asc: " + sortedMap.toString());

        LinkedHashMap<String, Integer> reversedSortedMap = new LinkedHashMap<>();

        // Sort in desc by Value
        sortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reversedSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sort in desc: " + reversedSortedMap.toString());

        return sortedMap;
    }

    public void sortByKey() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("math", 90);
        map.put("english", 50);
        map.put("physics", 85);
        map.put("geography", 70);

        System.out.println("Tree Automatically orders by key: " + map.toString());


        Map<String, Integer> reversedMap = new TreeMap<>(Comparator.reverseOrder());
        reversedMap.put("math", 90);
        reversedMap.put("english", 50);
        reversedMap.put("physics", 85);
        reversedMap.put("geography", 70);

        System.out.println("Tree Automatically orders by key: " + reversedMap.toString());

    }

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("math", 90);
        map.put("english", 50);
        map.put("physics", 85);
        map.put("geography", 70);

        SortMap sortMap = new SortMap();

        Logger.getLogger(SortMap.class.getName())
                .log(Level.INFO, "{0}", sortMap.sortByValue(map));

        sortMap.sortByKey();
    }
}
