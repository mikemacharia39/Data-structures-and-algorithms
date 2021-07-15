package leetTests;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bab", t = "aba"
 * Output: 1
 * Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
 * Example 2:
 *
 * Input: s = "leetcode", t = "practice"
 * Output: 5
 * Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
 * Example 3:
 *
 * Input: s = "anagram", t = "mangaar"
 * Output: 0
 * Explanation: "anagram" and "mangaar" are anagrams.
 * Example 4:
 *
 * Input: s = "xxyyzz", t = "xxyyzz"
 * Output: 0
 * Example 5:
 *
 * Input: s = "friend", t = "family"
 * Output: 4
 */
public class MinNoOfStepsToMakeToStringsAnagram {

    public static void main(String[] args) {
        MinNoOfStepsToMakeToStringsAnagram toMakeToStringsAnagram = new MinNoOfStepsToMakeToStringsAnagram();
        String s = "leetcode", t = "practice";
        System.out.println(toMakeToStringsAnagram.minSteps(s, t));
    }

    /**
     * BEST SLN
     * @param s
     * @param t
     * @return
     */
    public int minSteps(String s, String t) {

        int[] count = new int[26];
        int no = 0;

        // Add to count
        for(char c : s.toCharArray()) count[c - 'a']++;

        // remove from count
        for(char b : t.toCharArray()) count[b - 'a']--;

        // add to no, those whose count is greater than 0
        for(int i=0; i<26; i++) {
            if(count[i] > 0)
                no += count[i];
        }
        return no;
    }

    public int minStepsSln2(String s, String t) {
        Map<Character, Integer> mapS = toMap(s);
        Map<Character, Integer> mapT = toMap(t);
        int numOfChanges = 0;
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            if (mapT.containsKey(entry.getKey())) {
                if (entry.getValue() >= mapT.get(entry.getKey())) {
                    int diffInVal = entry.getValue() - mapT.get(entry.getKey());
                    numOfChanges = numOfChanges + diffInVal;
                }
            } else {
                numOfChanges = numOfChanges + entry.getValue();
            }
        }

        return numOfChanges;
    }

    private Map<Character, Integer> toMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        return map;
    }
}
