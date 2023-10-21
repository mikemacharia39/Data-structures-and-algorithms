package javasolutionsforalgorithms.revision_v2.geeksforgeeks;

import java.util.Arrays;

public class ReverseIntArray {

    public static int[] reverseIntegerArray(int[] numbers) {
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

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int[] reversedNumbers = reverseIntegerArray(numbers);
        System.out.println(Arrays.toString(reversedNumbers));
    }
}
