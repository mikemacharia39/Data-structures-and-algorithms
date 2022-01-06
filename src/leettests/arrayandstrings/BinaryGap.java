package leettests.arrayandstrings;

/**
 * Find the max number of zeros between two ones
 */
public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();

        int n = 1073741825;

        System.out.println("Gap: " + binaryGap.solution(n));
    }

    public int solution(int N) {
        // write your code in Java SE 8

        if (N == 0) {
            return 0;
        }

        String binaryStr = Integer.toBinaryString(N);

        int len = binaryStr.length();

        System.out.println("Binary String: " + binaryStr);

        int max = 0;

        int j = 0;

        for (int i = 0; i < len; i++) {
            if (binaryStr.charAt(i) == '0') {
                j++;
            }
            System.out.println("J: " + j);
            if (binaryStr.charAt(i) == '1') {
                max = Math.max(max, j);
                System.out.println("Max: " + max);
                j = 0;
            }

        }
        return max;
    }
}
