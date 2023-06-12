package javasolutionsforalgorithms.revision_v2.leetcode.google.string;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isVisited = new boolean[256];
            for (int j = i; j < n; j++) {
                if (isVisited[s.charAt(j)]) {
                    break;
                } else {
                    max = Math.max(max, j - i + 1);
                    isVisited[s.charAt(j)] = true;
                }
            }
        }

        return max;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;
            } else {
                set.remove(s.charAt(j));
                j++;
            }
        }

        return max;
    }
}
