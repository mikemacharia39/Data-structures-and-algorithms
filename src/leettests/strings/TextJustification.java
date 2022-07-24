package leettests.strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/text-justification/">...</a>
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly max
 * Width characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line does not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TextJustification {

    /**
     *
     * @param words words
     * @param maxWidth maximum width per string
     * @return list
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        String str = "";
        int j = 0;
        for (String word : words) {
            if (!exceeds(str, word, maxWidth)) {
                if (str.isEmpty()) {
                    str = word;
                } else {
                    str = str + " " + word;
                }
            } else {
                str = str.trim();
                if (!str.isEmpty()) {
                    list.add(str);
                }
                str = word;
            }

            if (j == words.length - 1) {
                list.add(str);
            }
            j++;
        }

        Iterator<String> it = list.iterator();

        int count = 0;
        while(it.hasNext()) {
            if (count < list.size()-1) {
                list.set(count, organize(it.next(), maxWidth, false));
            } else {
                list.set(count, organize(it.next(), maxWidth, true));
            }
            count++;
        }

        return list;
    }

    /**
     * Organize string
     * @param str string
     * @param maxWidth max width
     * @param isLastWord is last word
     * @return formatted string
     */
    private String organize(String str, int maxWidth, boolean isLastWord) {
        int numOfLetters = 0;
        int numOfWords = 0;
        int numOfSpaces = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                numOfLetters++;
            }
        }
        numOfSpaces = maxWidth - numOfLetters;

        String[] words = str.split("\\s+");

        numOfWords = words.length;

        if (numOfWords < 2) {
            return str.trim() + " " . repeat(numOfSpaces);
        }

        int div = numOfSpaces/(numOfWords-1);
        int rem = numOfSpaces%(numOfWords-1);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        if (!isLastWord) {
            for (String word : words) {
                int extra = rem > 0 ? 1 : 0;
                sb.append(word);
                if (count < words.length) {
                    sb.append(" " . repeat(div+extra));
                }
                rem--;
                count++;
            }
        } else {
            for (String word : words) {
                sb.append(word);
                if (count < words.length) {
                    sb.append(" ");
                    numOfSpaces--;
                }
                count++;
            }
            sb.append(" " . repeat(numOfSpaces));
        }

        return sb.toString();
    }

    /**
     * Check if string + new str exceed
     * @param str str
     * @param nextString str to add
     * @param maxWidth maxWidth
     * @return true|false
     */
    private boolean exceeds(String str, String nextString, int maxWidth) {
        String newString = str + " " + nextString;
        return newString.length() > maxWidth;
    }
}
