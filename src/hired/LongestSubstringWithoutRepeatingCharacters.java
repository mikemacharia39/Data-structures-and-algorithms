package hired;

import java.util.HashSet;

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

        HashSet<Character> set = new HashSet<>();

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

    public int lengthOfLongestSubstringSln1(String s) {

        int len = s.length();
        int max = 0;

        for (int i = 0; i < len; i++) {
            boolean[] isVisited = new boolean[256];
            for (int j = i; j < len; j++) {
                if (isVisited[s.charAt(j)] == true) {
                    break;
                } else {
                    max = Math.max(max, j-i+1);
                    isVisited[s.charAt(j)] = true;
                }
            }
        }

        return max;
    }
}
