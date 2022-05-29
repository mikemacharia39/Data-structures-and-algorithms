package leettests.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * This solution gives you the longest non repeating substring
     * **** But does not show the actual longest substring ******
     */
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        int max = 0;
        int i = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();

        while (j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                max = Math.max(max, set.size());
                j++;
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }
}
