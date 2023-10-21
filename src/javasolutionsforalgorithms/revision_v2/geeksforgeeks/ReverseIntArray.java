package javasolutionsforalgorithms.revision_v2.geeksforgeeks;

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
}
