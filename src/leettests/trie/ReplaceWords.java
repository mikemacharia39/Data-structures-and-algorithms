package leettests.trie;

import java.util.Arrays;
import java.util.List;

/**
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
    static class TrieSolution {

    }

    /**
     * Handles solution to this question without knowledge of Trie
     */
    static class ItWorks {
        public String replaceWords(List<String> dictionary, String sentence) {
            for (String word : dictionary) {
                sentence = replaceWord(sentence, word);
            }

            return sentence;
        }

        public String replaceWord(String sentence, String dictionaryWord) {
            String[] strArr = sentence.split("\\s+");
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
            String[] strArr = sentence.split("\\s+");
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
    }
}
