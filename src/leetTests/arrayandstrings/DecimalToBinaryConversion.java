package leetTests.arrayandstrings;

public class DecimalToBinaryConversion {

    public static void main(String[] args) {

        int number = 101;

        // METHOD 1

        System.out.println("----- Method 1 -----");
        System.out.println("Binary String: " + Integer.toBinaryString(number));

        // METHOD 2

        DecimalToBinaryConversion toBinaryConversion = new DecimalToBinaryConversion();

        System.out.println("----- Method 2 -----");
        System.out.println("Binary String: " + toBinaryConversion.toBinary(number));
    }

    public String toBinary(int num) {
        if (num <= 1) {
            return String.valueOf(num);
        }
        return toBinary(num/2) + num%2;
    }
}
