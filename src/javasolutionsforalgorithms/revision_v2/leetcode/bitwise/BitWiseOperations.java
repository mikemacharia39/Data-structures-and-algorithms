package javasolutionsforalgorithms.revision_v2.leetcode.bitwise;

public class BitWiseOperations {
    // Example method to demonstrate bitwise AND operation
    public int bitwiseAnd(int a, int b) {
        return a & b;
    }

    // Example method to demonstrate bitwise OR operation
    public int bitwiseOr(int a, int b) {
        return a | b;
    }

    // Example method to demonstrate bitwise XOR operation
    public int bitwiseXor(int a, int b) {
        return a ^ b;
    }

    // Example method to demonstrate bitwise NOT operation
    public int bitwiseNot(int a) {
        return ~a;
    }

    /**
     * Example method to demonstrate left shift operation
     * Assuming [a] is 5 and [positions] is 2,
     * the result will be 20 (5 << 2 = 5 * 2^2 = 5 * 4 = 20).
     * @param a the integer to be shifted
     * @param positions the number of positions to shift
     */
    public int leftShift(int a, int positions) {
        return a << positions;
    }

    /**
     * Example method to demonstrate right shift operation
     * Assuming [a] is 20 and [positions] is 2,
     * the result will be 5 (20 >> 2 = 20 / 2^2 = 20 / 4 = 5).
     * @param a the integer to be shifted
     * @param positions the number of positions to shift
     */
    public int rightShift(int a, int positions) {
        return a >> positions;
    }

    public static void main(String[] args) {
        BitWiseOperations bitWiseOperations = new BitWiseOperations();

        // Example usage
        int a = 5; // 0101 in binary
        int b = 3; // 0011 in binary
        int c = 20; // 10100 in binary

        System.out.println("Bitwise AND: " + bitWiseOperations.bitwiseAnd(a, b)); // Output: 1 (0001 in binary)
        System.out.println("Bitwise OR: " + bitWiseOperations.bitwiseOr(a, b));   // Output: 7 (0111 in binary)
        System.out.println("Bitwise XOR: " + bitWiseOperations.bitwiseXor(a, b)); // Output: 6 (0110 in binary)
        System.out.println("Bitwise NOT of a: " + bitWiseOperations.bitwiseNot(a)); // Output: -6 (inverts all bits of 5) // 1010 in binary
        System.out.println("Left Shift a by 2: " + bitWiseOperations.leftShift(a, 2)); // Output: 20 (10100 in binary)
        System.out.println("Right Shift a by 2: " + bitWiseOperations.rightShift(c, 2)); // Output: 5 (0101 in binary)
    }
}
