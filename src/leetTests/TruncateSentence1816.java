package leetTests;

/**
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each of the words consists of only uppercase and lowercase English letters (no punctuation).
 *
 * For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
 * You are given a sentence s and an integer k. You want to truncate s,
 * such that it contains only the first k words. Return s after truncating it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "Hello how are you Contestant", k = 4
 * Output: "Hello how are you"
 * Explanation:
 * The words in s are ["Hello", "how" "are", "you", "Contestant"].
 * The first 4 words are ["Hello", "how", "are", "you"].
 * Hence, you should return "Hello how are you".
 * Example 2:
 *
 * Input: s = "What is the solution to this problem", k = 4
 * Output: "What is the solution"
 * Explanation:
 * The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
 * The first 4 words are ["What", "is", "the", "solution"].
 * Hence, you should return "What is the solution".
 * Example 3:
 *
 * Input: s = "chopper is not a tanuki", k = 5
 * Output: "chopper is not a tanuki"
 *
 */
public class TruncateSentence1816 {

    public static void main(String[] args) {
        TruncateSentence1816 truncateSentence = new TruncateSentence1816();
        String s = "What is the     solution to this problem"; int k = 4;
        System.out.println(truncateSentence.truncateSentence(s, k));
    }

    public String truncateSentence(String s, int k) {

        // Split s into an array of strings
        String[] splitString = s.split(" ");

        // Append the strings
        StringBuilder sb = new StringBuilder();

        int x = 0;
        for (String value : splitString) {
            // Sanitize string
            String singleString = value.replaceAll("[^A-Za-z]", "");
            if (!singleString.isEmpty()) {
                x++;
                sb.append(singleString);
                if (x >= k) {
                    break;
                }
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
