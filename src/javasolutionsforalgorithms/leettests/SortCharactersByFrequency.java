package javasolutionsforalgorithms.leettests;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/sort-characters-by-frequency/">...</a>
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {

        String myString = "tree";

        SortCharactersByFrequency sorts = new SortCharactersByFrequency();
        System.out.println(sorts.frequencySort(myString));
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet().stream()
                      .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                      .forEach(x -> sb.append(Character.toString(x.getKey()).repeat(x.getValue())));

        return sb.toString();
    }

    /**
     * This is NOT a good solution
     * @param myString string
     * @return string
     */
    public String frequencySort1(String myString) {
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
