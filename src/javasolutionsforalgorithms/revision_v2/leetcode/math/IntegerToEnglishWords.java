package javasolutionsforalgorithms.revision_v2.leetcode.math;

/**
 * Convert a non-negative integer num to its English words representation.
 * Example 1:
 *
 * Input: num = 123
 * Output: "One Hundred Twenty Three"
 * Example 2:
 *
 * Input: num = 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * Example 3:
 *
 * Input: num = 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 *
 * Constraints:
 *
 * 0 <= num <= 2^31 - 1
 */
public class IntegerToEnglishWords {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(long num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(long num) {
        String result;
        if (num < 10) result = belowTen[(int) num];
        else if (num < 20) result = belowTwenty[(int) (num -10)];
        else if (num < 100) result = belowHundred[(int) (num/10)] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num/100) + " Hundred " +  helper(num % 100);
        else if (num < 1000000) result = helper(num/1000) + " Thousand " +  helper(num % 1000);
        else if (num < 1000000000) result = helper(num/1000000) + " Million " +  helper(num % 1000000);
        else result = helper(num/1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        Long[] numbers = new Long[]{9L, 12L, 123L, 12345L, 1234567L, 1234567891L, 911234007890L};

        for (Long number : numbers) {
            System.out.println("Number: " + number + " -> " + integerToEnglishWords.numberToWords(number));
        }
    }
}
