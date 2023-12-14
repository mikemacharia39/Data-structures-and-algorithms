package javasolutionsforalgorithms.revision_v2.leetcode.math;

public class IntegerToRoman {

    /**
     * Logic is to keep subtracting the largest possible value from the number and keep adding the corresponding symbol
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
        System.out.println(integerToRoman.intToRoman(55));
    }
}
