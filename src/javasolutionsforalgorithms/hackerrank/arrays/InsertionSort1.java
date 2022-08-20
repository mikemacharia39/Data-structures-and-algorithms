package javasolutionsforalgorithms.hackerrank.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.
 * The array is virtually split into a sorted and an unsorted part.
 * Values from the unsorted part are picked and placed at the correct position in the sorted part.
 * Algorithm
 * To sort an array of size n in ascending order:
 * 1: Iterate from arr[1] to arr[n] over the array.
 * 2: Compare the current element (key) to its predecessor.
 * 3: If the key element is smaller than its predecessor, compare it to the elements before.
 * Move the greater elements one position up to make space for the swapped element.
 */
public class InsertionSort1 {

    public static void insertionSort1(int n, List<Integer> arr) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                if (arr.get(i) > arr.get(j)) {
                    int temp = arr.get(i);

                    arr.set(i, arr.get(j));

                    arr.set(j, temp);

                    Logger.getLogger("").log(Level.INFO,"{0}", arr);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(6,2,8,4,5);
        int n = nums.size();

        InsertionSort1.insertionSort1(n, nums);
    }
}
