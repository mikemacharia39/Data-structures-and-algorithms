package leettests.strings;

/**
 * <a href="https://leetcode.com/problems/rearrange-spaces-between-words/">...</a>
 *
 * You are given a string text of words that are placed among some number of spaces.
 * Each word consists of one or more lowercase English letters and are separated by at least one space.
 * It's guaranteed that text contains at least one word.
 *
 * Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized.
 * If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string
 * should be the same length as text.
 *
 * Return the string after rearranging the spaces.
 *
 * Example 1:
 *
 * Input: text = "  this   is  a sentence "
 * Output: "this   is   a   sentence"
 * Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
 *
 * Example 2:
 *
 * Input: text = " practice   makes   perfect"
 * Output: "practice   makes   perfect "
 * Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space.
 * We place this extra space at the end of the string.
 */
public class RearrangeSpacesBetweenWords {

    public String reorderSpaces(String text) {
        int numOfSpaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                numOfSpaces++;
            }
        }

        text = text.replaceAll("\\s+", " ").trim();
        String[] words = text.split(" ");
        int numOfWords = words.length;

        if (numOfWords < 2 && numOfSpaces == 0) {
            return text;
        }

        if (numOfWords < 2 && numOfSpaces > 0) {
            return text + " " . repeat(numOfSpaces);
        }

        int div = numOfSpaces/(numOfWords-1);
        int rem = numOfSpaces%(numOfWords-1);

        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            if (count < words.length) {
                sb.append(" " . repeat(div));
            }
            count++;
        }

        return sb + " " . repeat(rem);
    }

    /**
     * @param text original text
     * @return updated text
     */
    public String reorderSpacesSln1(String text) {
        int numOfWords = 0;
        int numOfSpaces = 0;
        int len = text.length() - 1; // to not throw Array
        boolean isWord = false;

        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                numOfSpaces++;
            }

            if (Character.isLetterOrDigit(text.charAt(i)) && i != len) {
                isWord = true;
            } else if (!Character.isLetterOrDigit(text.charAt(i)) && isWord) {
                isWord = false;
                numOfWords++;
            } else if (Character.isLetterOrDigit(text.charAt(i)) && i == len) {
                numOfWords++;
            }
        }

        if (numOfWords < 2 && numOfSpaces == 0) {
            return text;
        }

        text = text.replaceAll("\\s+", " ").trim();

        if (numOfWords < 2 && numOfSpaces > 0) {
            return text + " " . repeat(numOfSpaces);
        }

        int div = numOfSpaces/(numOfWords-1);
        int rem = numOfSpaces%(numOfWords-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isWhitespace(text.charAt(i))) {
                String space = " " . repeat(div);
                sb.append(space);
            } else {
                sb.append(text.charAt(i));
            }
        }

        return sb + " " . repeat(rem);
    }

    public static void main(String[] args) {

    }
}
