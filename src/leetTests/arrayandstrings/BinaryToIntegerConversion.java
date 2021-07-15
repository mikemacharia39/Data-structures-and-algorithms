package leetTests.arrayandstrings;

public class BinaryToIntegerConversion {

    public static void main(String[] args) {

        String binaryVal = "101";

        // METHOD 1

        int sum = 0;
        for (char c : binaryVal.toCharArray()) {
            sum = (2 * sum) + Integer.parseInt(String.valueOf(c));
        }

        System.out.println("----- Method 1 -----");
        System.out.println("Integer: " + sum);

        // METHOD 2

        // either
        int decimalVal = Integer.parseInt(binaryVal, 2);

        long val = Long.parseLong(binaryVal, 2);

        System.out.println("----- Method 2 -----");
        System.out.println("Integer: " + val);
    }
}
