package javasolutionsforalgorithms.revision_v2.leetcode.leetcode.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    /**
     * Time complexity: O(m) since it is the longest length of the two arrays
     * Space complexity: O(n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // you can replace the above code with this:
        // nums1Copy = Arrays.copyOf(nums1, m);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {

            if (nums1Copy[i] < nums2[j]) {
                nums1[k] = nums1Copy[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }

            k++;
        }

        while (i < m) {
            nums1[k] = nums1Copy[i];
            i++;
            k++;
        }

        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}
