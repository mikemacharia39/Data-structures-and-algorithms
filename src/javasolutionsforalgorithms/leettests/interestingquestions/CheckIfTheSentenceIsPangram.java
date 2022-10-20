package javasolutionsforalgorithms.leettests.interestingquestions;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 * Given a string sentence containing only lowercase English letters,
 * return true if sentence is a pangram, or false otherwise.
 *
 *
 * Example 1:
 *
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
 * Output: true
 * Explanation: sentence contains at least one of every letter of the English alphabet.
 *
 *
 * Example 2:
 *
 * Input: sentence = "leetcode"
 * Output: false
 */
public class CheckIfTheSentenceIsPangram {

    public boolean checkIfPangram2(String sentence) {
        int[] alphabetFeq = new int[26];

        for(int i = 0; i < sentence.length(); i++) {
            alphabetFeq[sentence.charAt(i) - 'a']++;
        }

        for (int freq : alphabetFeq) {
            if (freq == 0) {
                return false;
            }
        }

        return true;
    }
}
