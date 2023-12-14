package javasolutionsforalgorithms.revision_v2.leetcode.math;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 */
public class IntegerToRoman {

    /**
     * Time complexity = O(1) because we have a fixed number of symbols
     * Space complexity = O(1)
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        final String[] M = {"", "M", "MM", "MMM"}; // 1000, 2000, 3000
        final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 100, 200, 300, 400, 500, 600, 700, 800, 900
        final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 10, 20, 30, 40, 50, 60, 70, 80, 90
        final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String result = M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        // Example 2734
        // 2734/1000 = 2 -> M[2] = MM
        // (2734%1000)/100 = 7 -> C[7] = DCC
        // (2734%100)/10 = 3 -> X[3] = XXX
        // 2734%10 = 4 -> I[4] = IV
        return result;
    }

    /**
     * Logic is to keep subtracting the largest possible value from the number and keep adding the corresponding symbol
     * Does not work for 4, 9, 40, 90, 400, 900
     * Time complexity = O(1) because we have a fixed number of symbols
     * Space complexity = O(1)
     * @param num input number
     * @return roman representation of the number
     */
    public String intToRoman1(int num) {
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1000, 500, 100, 50, 10, 5, 1};
        String[] symbols = new String[]{"M", "D", "C", "L", "X", "V", "I"};

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];

            while (num >= value) {
                sb.append(symbol);
                num -= value;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(999));
    }
}
