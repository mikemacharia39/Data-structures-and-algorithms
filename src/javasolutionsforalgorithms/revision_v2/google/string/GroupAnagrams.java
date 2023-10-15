package javasolutionsforalgorithms.revision_v2.google.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/">...</a>
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    /**
     * Explanation: Since anagrams are made up of the same characters, we can use a hashmap to store them, where
     * the key is the sorted string and the value is the list of strings that are anagrams of each other.
     * Time complexity: O(n * mlogm) where n is the length of the array and m is the length of the longest string
     *
     * @param strs array of strings
     * @return list of lists of strings
     */
    public List<List<String>> groupAnagrams_good(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            s = s.toLowerCase();
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String theKey = String.valueOf(c);
            if (!map.containsKey(String.valueOf(c))) {
                map.put(theKey, new ArrayList<>());
            }
            map.get(theKey).add(s);
        }

        return new ArrayList<>(map.values());
    }

    /**
     * Explanation: Without sorting we can convert the string to an int array where each index represents the count of
     * the same character. We can then use this int array as the key in the hashmap.
     * Time complexity: O(n * m) where n is the length of the array and m is the length of the longest string
     * @param strs array of strings
     * @return  list of lists of strings
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String strToInt = Arrays.toString(toInt(str));
            if (!map.containsKey(strToInt)) {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(strToInt, newList);
            } else {
                map.get(strToInt).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for (List<String> anagramGroup : map.values()) {
            ans.add(anagramGroup);
        }
        return ans;
    }

    public int[] toInt(String s) {
        int n = s.length();
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        return arr;
    }
}
