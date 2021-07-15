package leetTests.arrayandstrings;

import java.util.Arrays;

public class SortArrayInSingleLoop {

    public static void main(String[] args) {
        SortArrayInSingleLoop sortArrayInSingleLoop = new SortArrayInSingleLoop();

        int[] arr = {1,0,0,0,2,0,4,3,0};

        System.out.println("Cur: " + Arrays.toString(arr));

        int[] ans = sortArrayInSingleLoop.sort(arr);

        System.out.println("New: " + Arrays.toString(ans));
    }

    private int[] sort(int[] unordered) {

        int size = unordered.length;

        for (int i = 0; i < size-1; i++) {
            if (unordered[i] > unordered[i+1]) {
                int temp = unordered[i]; // hold the value temporarily

                unordered[i] = unordered[i+1]; // move the larger value to the next index

                unordered[i + 1] = temp; // move the lesser value to the previous index

                i = -1; // reset the index to begin new sort
            }
        }

        return unordered;
    }
}
