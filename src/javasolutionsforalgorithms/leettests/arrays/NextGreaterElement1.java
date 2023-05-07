package javasolutionsforalgorithms.leettests.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-i/">...</a>
 *
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
public class NextGreaterElement1 {

    /**
     * A more optimal solution
     * @param nums1 - subset of nums2
     * @param nums2 - array
     * @return - array of next greater elements
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        int len2 = nums2.length;
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                int j = map.get(nums1[i]) + 1;
                while (len2 > j) {
                    if (nums2[j] > nums1[i]) {
                        ans[i] = nums2[j];
                        break;
                    }

                    j++;
                }
            }
        }

        return ans;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            ans[i] = checkIfNextValue(nums1[i], nums2);
        }

        return ans;
    }

    private static int checkIfNextValue(int val, int[] nums2) {
        int count = 1;
        for(int i = 0; i < nums2.length; i++) {
            if (val == nums2[i]) {
                while (nums2.length > i+count) {
                    if (nums2[i+count] > val) {
                        return nums2[i+count];
                    }
                    count++;
                }
            }
        }
        return -1;
    }
}
