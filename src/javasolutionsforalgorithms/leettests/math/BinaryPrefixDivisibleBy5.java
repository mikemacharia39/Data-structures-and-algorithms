package javasolutionsforalgorithms.leettests.math;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> booleans = new ArrayList<>();
        long sum = 0L;
        for (int num : nums) {
            sum = (sum * 2) + num;
            boolean b = sum % 5 == 0;
            booleans.add(b);

            //This is to prevent it from overflow
            sum = sum%5;
        }
        return booleans;
    }

    private static long binaryStringToNumberConversion(String binary) {
        long num = 0L;
        for (int i = 0; i < binary.length(); i++) {
            num = (num * 2) + binary.charAt(i) - '0';
        }
        return num;
    }

    private static String numberToBinaryConversion(int number) {
        if (number <= 1) {
            return Integer.toString(number);
        }
        return numberToBinaryConversion(number/2) + numberToBinaryConversion(number % 2);
    }

    public static void main(String[] args) {
        String binaryString = numberToBinaryConversion(520);

        System.out.println("Binary Conversion: " + binaryString);

        System.out.println("Number Conversion: " + binaryStringToNumberConversion(binaryString));

        int[] nums = {1,1,1};
        System.out.println("Ans: " + prefixesDivBy5(nums));
    }
}
