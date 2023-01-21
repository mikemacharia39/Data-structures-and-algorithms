package javasolutionsforalgorithms.leettests.strings;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<String, Integer> wordOccurrence = new HashMap<>();
        for (String word : words) {
            wordOccurrence.put(word, wordOccurrence.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : wordOccurrence.entrySet()) {
            count += isSubsequence(s, entry.getKey()) ? entry.getValue() : 0;
        }

        return count;
    }

    private boolean isSubsequence(String s, String word) {
        if (word.length() > s.length()) return false;

        int index = -1;

        for (char c : word.toCharArray()) {
            index = s.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }

        return true;
    }
}
