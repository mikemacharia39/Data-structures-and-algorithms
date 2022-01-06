package leettests;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * https://leetcode.com/problems/to-lower-case/
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 *
 * Example 2:
 * Input: "here"
 * Output: "here"
 *
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 *
 */
public class ToLowerCaseUsingAscii {

    public static void main(String[] args) {
        ToLowerCaseUsingAscii toLowerCaseUsingAscii = new ToLowerCaseUsingAscii();

        String s = "LOVELY";
        System.out.println(toLowerCaseUsingAscii.toLowerCase(s));
    }

    public String toLowerCase(String str) {

        StringBuilder sb = new StringBuilder();
        int toAscii;
        for (char c : str.toCharArray()) {
            toAscii = (int) c;
            sb.append(fromAscii(toAscii));
        }

        return sb.toString();
    }

    private Character fromAscii(int ascii) {
        if (ascii >= 65 && ascii <= 90) {
            int toUpperAscii = ascii + 32;
            return (char) toUpperAscii;
        }

        return (char) ascii;
    }
}
