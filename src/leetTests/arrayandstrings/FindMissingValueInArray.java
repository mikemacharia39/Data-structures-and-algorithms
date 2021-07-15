package leetTests.arrayandstrings;

import java.util.Arrays;

/**
 * Give an array like this [1,2,6,5,3] find the missing element i.e in this case it will be 4.
 * Don't use extra space. Do it in one loop
 */
public class FindMissingValueInArray {

    public static void main(String[] args) {

        FindMissingValueInArray findMissingValueInArray = new FindMissingValueInArray();

        int[] nums = {1,2,3,6,5};

        System.out.println("missing: " + findMissingValueInArray.missingValue(nums));
    }

    /**
     * The solution is based on the fact that there will always be 1 missing element
     * @param arr array of integers
     * @return missing value
     */
    private int missingValue(int[] arr) {

        // usually to find the sum of numbers in a sequence you can do
        // n(n+1)/2

        int size = arr.length + 1; // for the extra missing element
        int sum = (size * (size + 1))/2;

        int existingSum = 0;
        for (int j : arr) {
            existingSum += j;
        }

        return sum - existingSum;
    }


    private int missingValueBad(int[] arr) {

        int size = arr.length;

        Arrays.sort(arr);

        for (int i = 0; i < size; i++) {
            int nextVal = arr[i] + 1;
            if (nextVal != arr[i+1]) {
                return nextVal;
            }
        }

        return -1;
    }
}
