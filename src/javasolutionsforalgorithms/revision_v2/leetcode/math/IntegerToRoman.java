package javasolutionsforalgorithms.revision_v2.leetcode.math;

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
