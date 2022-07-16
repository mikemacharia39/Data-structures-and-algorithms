package leettests.string_manipulation;

/**
 * <a href="https://leetcode.com/problems/add-binary/">...</a>
 *
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        int carry = 0;
        int alen = a.length()-1;
        int blen = b.length()-1;

        StringBuilder sb = new StringBuilder();
        while (alen >= 0 || blen >= 0) {

            if (alen >= 0) {
                carry += a.charAt(alen) - '0';
                alen--;
            }

            if (blen >= 0) {
                carry += b.charAt(blen) - '0';
                blen--;
            }

            sb.insert(0, (carry%2));

            carry = carry/2;
        }

        if (carry == 1) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
