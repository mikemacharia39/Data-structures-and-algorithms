package javasolutionsforalgorithms.revision_v2.hackerrank.math;

public class UnsignedIntToBinaryAndViceVersa {

    private static String unsignedIntToBinary(long n) {
        if (n <= 1) {
            return Long.toString(n);
        }
        return unsignedIntToBinary(n / 2) + n % 2;
    }

    public static long binaryToUnsignedInt(String binary) {
        long sum = 0;
        for (char c : binary.toCharArray()) {
            sum = (2 * sum) + (c - '0');
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(unsignedIntToBinary(2)); // 10
        System.out.println("============================");
        System.out.println(binaryToUnsignedInt("1010")); // 10
    }
}
