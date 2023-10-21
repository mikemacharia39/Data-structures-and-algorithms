package javasolutionsforalgorithms.revision_v2.geeksforgeeks;

import java.util.Arrays;

public class ReverseIntArray {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param numbers
     * @return
     */
    public static int[] reverseIntegerArray1(int[] numbers) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
            start++;
            end--;
        }

        return numbers;
    }

    /**
     * This solution uses recursion
     * @param numbers
     * @return
     */
    public static int[] reverseIntegerArray(int[] numbers) {
        return reverseArray(numbers, 0, numbers.length - 1);
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param numbers
     * @param start
     * @param end
     * @return
     */
    private static int[] reverseArray(int[] numbers, int start, int end) {
        if (start >= end) {
            return numbers;
        }

        int temp = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = temp;
        reverseArray(numbers, start + 1, end - 1);
        return numbers;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] reversedNumbers = reverseIntegerArray(numbers);
        System.out.println(Arrays.toString(reversedNumbers));
    }
}
