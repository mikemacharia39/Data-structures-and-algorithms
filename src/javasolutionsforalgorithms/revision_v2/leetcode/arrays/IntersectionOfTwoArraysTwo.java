package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 */
public class IntersectionOfTwoArraysTwo {
    public int[] intersect1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int minLen = Math.min(n,m);
        int[] temp = new int[minLen];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums1[i] == nums2[j]){
                    temp[index++] = nums1[i]; // to temporarily save our values
                    nums2[j] = Integer.MIN_VALUE; // mark the matched element in nums2 to avoid reusing
                    break;
                }
            }
        }
        int[] result = new int[index];
        for(int i = 0; i < index; i++){
            result[i] = temp[i];
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> n1Map = new HashMap<>();

        for (int num : nums1) {
            n1Map.put(num, n1Map.getOrDefault(num, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (n1Map.getOrDefault(num, 0) > 0) {
                resultList.add(num);
                n1Map.put(num, n1Map.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
