package leetTests;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class ValidPalindromeByRemoveOneChar {

    public static void main(String[] args) {
        ValidPalindromeByRemoveOneChar validPalindromeByRemoveOneChar = new ValidPalindromeByRemoveOneChar();
        //String s = "aba"; // true
        //String s = "beeeee"; // true
        //String s = "abcdefgfedcbaa"; // true
        String s = "abcdbaa"; //false
        System.out.println(validPalindromeByRemoveOneChar.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {

        String sanitizedStr = s.replaceAll("[^A-Za-z]", "").toLowerCase();
        int sLen = sanitizedStr.length();

        if (sLen <= 1) {
            return true;
        }

        int j = sLen - 1;
        int trackRemoval = 0;
        for (int i = 0; i < sLen/2; i++) {
            if (sanitizedStr.charAt(i) != sanitizedStr.charAt(j)) {
                trackRemoval++;

                String sanitizedStrRight = sanitizedStr.substring(0, j) + sanitizedStr.substring(j+1);
                String sanitizedStrLeft = sanitizedStr.substring(0, i) + sanitizedStr.substring(i+1);

                System.out.println(sanitizedStr);
                if (trackRemoval > 1) {
                    return false;
                }
                return rerunSubPalindrome(sanitizedStrRight) || rerunSubPalindrome(sanitizedStrLeft);
            }
            j--;
        }

        return true;
    }

    private boolean rerunSubPalindrome(String sanitizedStr) {
        int sLen = sanitizedStr.length();
        int j = sLen - 1;
        for (int i = 0; i < sLen/2; i++) {
            if (sanitizedStr.charAt(i) != sanitizedStr.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }
}
