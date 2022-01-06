package leettests.arrayandstrings;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Example 4:
 *
 * Input: s = "  Bob    Loves  Alice   "
 * Output: "Alice Loves Bob"
 *
 * Example 5:
 *
 * Input: s = "Alice does not even like bob"
 * Output: "bob like even not does Alice"
 *
 */
public class ReverseStringWordByWord {

    public static void main(String[] args) {

        String str =  "  Bob    Loves  Alice   ";
        // Output -> Mike is name my

        System.out.println("Original: \"" + str + "\"");

        ReverseStringWordByWord reverse = new ReverseStringWordByWord();

        System.out.println("Reversed: \"" + reverse.solution(str) + "\"");

    }

    /**
     * The solution Splits the string with whitespace.
     *
     *
     * @param str initial string
     * @return reversed string
     */
    private String solution(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        str = str.replaceAll("\\s+", " ").trim();

        String[] splitWord = str.split(" ");
        StringBuilder sb = new StringBuilder();

        int wl = splitWord.length;

        int count = 0;
        for (int i = wl - 1; i >= 0; i--) {
            sb.append(splitWord[i]);
            count++;
            if (count < wl) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
