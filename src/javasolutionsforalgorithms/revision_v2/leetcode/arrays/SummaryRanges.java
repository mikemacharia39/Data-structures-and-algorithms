package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a sorted unique integer array nums.
 *
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int startRange = 0;
        for (int i = 1; i <= nums.length; i++) {
            // check if it's the last element of if the sum of the previous + 1 equals the current
            if (i == nums.length || nums[i-1] + 1 != nums[i]) {
                if (nums[startRange] == nums[i-1]) {
                    result.add(Integer.toString(nums[startRange]));
                } else {
                    result.add(nums[startRange] + "->" + nums[i-1]);
                }
                startRange = i;
            }

        }
        return result;
    }
}
