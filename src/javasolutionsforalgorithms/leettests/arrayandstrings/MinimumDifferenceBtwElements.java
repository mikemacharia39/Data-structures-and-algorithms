package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.Arrays;

public class MinimumDifferenceBtwElements {
    public static void main(String[] args) {

        int[] a = {29, 20, 89, 33, 35};

        MinimumDifferenceBtwElements diff = new MinimumDifferenceBtwElements();

        System.out.println("Ans: " + Arrays.toString(diff.solution(a)));
    }

    /**
     * (Efficient: O(n Log n)
     * The idea is to use sorting. Below are steps.
     * 1) Sort array in ascending order. This step takes O(n Log n) time.
     * 2) Initialize difference as infinite. This step takes O(1) time.
     * 3) Compare all adjacent pairs in sorted array and keep track of minimum difference.
     * This step takes O(n) time.
     *
     * @param array array
     * @return array
     */
    private int[] solution(int[] array) {
        int l = array.length;

        int[] ans = new int[2];

        int minVal = Integer.MAX_VALUE;

        Arrays.sort(array);

        for (int i = 0; i < l - 1; i++) {
            if (Math.abs(array[i+1] - array[i]) < minVal) {
                minVal = Math.abs(array[i+1] - array[i]);
                ans[0] = array[i+1];
                ans[1] = array[i];
            }
        }

        return ans;
    }
}
