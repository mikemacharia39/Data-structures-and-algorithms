package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 3 sum problem
 *
 * Given an integer array nums, return all the triplets such that i != j, i != k and j != k and
 * nums[i] + nums[j] + nums[k] == 0
 *
 * The solution set must not contain duplicate triplets
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4}; //output = [[-1,-1,2], [-1,0,1]]

        System.out.println(new ThreeSum().threeSums(nums).toString());
    }

    public List<List<Integer>> threeSums(int[] nums) {
        int n = nums.length;

        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int firstNum = nums[i];

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = firstNum + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(List.of(firstNum, nums[left], nums[right]));
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }

        }

        return new ArrayList<>(result);
    }
}
