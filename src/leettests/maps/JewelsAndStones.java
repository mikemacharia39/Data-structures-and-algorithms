package leettests.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * <a href="https://leetcode.com/problems/jewels-and-stones/">...</a>
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
 *
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 *
 * Example 1:
 *
 * Input: jewels = "aA", stones = "aAAbbbb"
 * Output: 3
 *
 * Example 2:
 *
 * Input: jewels = "z", stones = "ZZ"
 * Output: 0
 */
public class JewelsAndStones {

    /**
     * Solution 1
     * Time complexity O(n^2)
     */
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (char jewel : jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Solution 2
     * Better, but there is an aspect of search inside the loop i.e. n (n log n)
     */
    public int numJewelsInStones1(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Solution 1
     *
     * Not the best due to the new memory introduced
     */
    public int numJewelsInStones2(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (jewels.contains(entry.getKey()+"")) {
                count += entry.getValue();
            }
        }
        return count;
    }
}
