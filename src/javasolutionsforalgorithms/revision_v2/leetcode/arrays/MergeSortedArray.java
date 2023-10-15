package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/">...</a>
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
 * should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 *
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 */
public class MergeSortedArray {

    /**
     * Time complexity: O(m + n)
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

    /**
     * Time complexity: O(m+ n)
     * Space complexity: O(1)
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int lastIndex = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[lastIndex--] = nums1[p1--];
            } else {
                nums1[lastIndex--] = nums2[p2--];
            }
        }

        // Copy any remaining elements from nums2 to nums1
        while (p2 >= 0) {
            nums1[lastIndex--] = nums2[p2--];
        }

        // No need to handle remaining elements in nums1
        // They are already in their correct positions
    }
}
