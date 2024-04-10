package javasolutionsforalgorithms.revision_v2.hackerrank.manipulation;

import java.util.List;

/**
 * Given 2 numbers a and b, swap them without using a temporary variable or arithmetic operators
 */
public class SwapTwoNumbersWithoutUsingOperator {

    /**
     * The logic is to use the XOR operator
     * Explanation: The XOR operator is ^ in Java. It is used to compare two binary numbers. If the bits are different, it returns 1, else 0.
     * The XOR operator has the following properties:
     * 1. a ^ a = 0
     * 2. a ^ 0 = a
     * 3. a ^ b = b ^ a
     * 4. a ^ b ^ a = b
     * Time complexity = O(1)
     * @param a
     * @param b
     * @return
     */
    public static List<Integer> swap(int a, int b) {
        a = a ^ b;// a = 2 ^ 3 = 1 because 001 ^ 011 = 010

        System.out.println(a + " = " + a);

        b = a ^ b; // b = 1 ^ 3 = 2 because 010 ^ 011 = 001

        System.out.println(b + " = " + b);

        a = a ^ b; // a = 1 ^ 2 = 3 because 001 ^ 010 = 011

        System.out.println(a + " = " + a);
        return List.of(a, b);
    }

    public static void main(String[] args) {
        System.out.println(swap(2, 3));
    }
}
