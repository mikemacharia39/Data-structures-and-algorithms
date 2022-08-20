package javasolutionsforalgorithms.leettests.trie;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/replace-words/">replace-words</a>
 *
 * In English, we have a concept called root, which can be followed by some other word to form another
 * longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other",
 * we can form a new word "another".
 *
 * Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces,
 * replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root,
 * replace it with the root that has the shortest length.
 *
 * Return the sentence after the replacement.
 *
 * Example 1:
 *
 * Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Example 2:
 *
 * Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * Output: "a a b c"
 */
public class ReplaceWords {

    /**
     * With knowledge of tries
     */
    static class HashTableSolution {

        /**
         * A better solution
         * Entry point
         * @param dictionary list of roots
         * @param sentence string
         * @return string with roots
         */
        public String replaceWords(List<String> dictionary, String sentence) {
            Set<String> set = new HashSet<>(dictionary);
            StringBuilder newSentence = new StringBuilder();
            Arrays.stream(sentence.split("\\s+")).forEach(str -> {
                String prefix = "";
                for (int i = 1; i <= str.length(); i++) {
                    prefix = str.substring(0, i);
                    if (set.contains(prefix)) {
                        break;
                    }
                }
                if (newSentence.length() > 0) {
                    newSentence.append(" ");
                }
                newSentence.append(prefix);
            });

            return newSentence.toString();
        }
    }

    /**
     * Handles solution to this question without knowledge of Trie
     */
    static class ItWorks {
        /**
         * Runtime: 621 ms, faster than 5.11% of Java online submissions for Replace Words.
         * Memory Usage: 170.3 MB, less than 6.41% of Java online submissions for Replace Words.
         *
         * Entry point
         * @param dictionary list of roots
         * @param sentence string
         * @return string with roots
         */
        public String replaceWords(List<String> dictionary, String sentence) {
            Iterator<String> it = dictionary.iterator();
            while(it.hasNext()) {
                String word = it.next();
                sentence = replaceWord(sentence, word, word.length());
            }

            return sentence;
        }

        public String replaceWord(String sentence, String dictionaryWord, final int len) {
            String[] strArr = sentence.split(" ");
            int counter = 0;
            for (String str : strArr) {
                if (str.startsWith(dictionaryWord)) {
                    int beginAt = estimatePOS(counter, sentence);
                    int start = sentence.indexOf(str, beginAt);
                    int end = start + str.length();
                    sentence = sentence.substring(0, start) + dictionaryWord + sentence.substring(end);
                }
                counter++;
            }

            return sentence;
        }

        public int estimatePOS(int counter, String sentence) {
            String[] strArr = sentence.split(" ");
            int sum = 0;
            for (int i = 0; i < counter; i++) {
                sum += strArr[i].length();
            }

            return sum+counter;
        }
    }

    public static void main(String[] args) {
        List<String> replace = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";

        ReplaceWords.ItWorks replaceWords = new ReplaceWords.ItWorks();

        System.out.println(replaceWords.replaceWords(replace, sentence));

        ReplaceWords.HashTableSolution hashTableSolution = new ReplaceWords.HashTableSolution();

        System.out.println(hashTableSolution.replaceWords(replace, sentence));
    }
}
