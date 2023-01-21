package javasolutionsforalgorithms.leettests.strings;

/**
 * Write a Java function that checks if a string xyz is a subsequence of another string eeyxdgyz
 */
public class IsASubsequence {

    public boolean isSubsequence(String sub, String str) {
        int index = -1;

        for (char c : sub.toCharArray()) {
            index = str.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }


    /**
     * This function uses two pointers, i and j, to iterate through the characters of the two strings.
     * If the characters at the current positions of the pointers match, the i pointer is incremented.
     * In any case, the j pointer is incremented.
     * If at the end of the loop, i is equal to the length of sub, that means that all characters of sub have been
     * found in str in order, so the function returns true. Otherwise, false is returned.
     *
     * @param sub small string
     * @param str large string
     * @return true|false
     */
    public boolean isSubsequence1(String sub, String str) {
        if (sub.length() > str.length()) return false;

        int i = 0;
        int j = 0;

        while (i < sub.length() && j < str.length()) {
            if (sub.charAt(i) == str.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sub.length();
    }

    public static void main(String[] args) {
        IsASubsequence aSubsequence = new IsASubsequence();
        String sub = "xyz";
        String str = "xyeyeoouexdgdydhz";

        System.out.println("Is subsequence: " + aSubsequence.isSubsequence(sub, str));
    }
}
