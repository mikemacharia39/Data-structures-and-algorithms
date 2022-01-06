package leettests;

import java.util.*;

public class SortCharactersByFrequency {

    public static void main(String[] args) {

        String myString = "tree";

        SortCharactersByFrequency sorts = new SortCharactersByFrequency();
        System.out.println(sorts.sortByFreq(myString));
    }

    public String sortByFreq(String myString) {
        char[] chars = myString.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : list) {
            char c = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
