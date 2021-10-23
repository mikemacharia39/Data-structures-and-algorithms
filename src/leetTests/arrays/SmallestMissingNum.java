package leetTests.arrays;

import java.util.Arrays;

/**
 * Given an array of integers, find the smallest positive missing in the array
 *
 * [1,3,4,2,6,1] = ans = 5
 *
 * [1,2,3] = 4
 *
 * [-1,-3] = 1
 *
 * [-1, 3] = 1
 */

public class SmallestMissingNum {


    public int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int expectedStart = 0;

        for (int j : nums) {
            if (j == 1) {
                expectedStart = 1;
                break;
            }
        }

        if (expectedStart == 0) {
            return 1;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                int diff = nums[i + 1] - nums[i];
                if (diff > 1) {
                    return nums[i] + 1;
                }
            }
        }

        return nums[nums.length-1] + 1;
    }

    public static void main(String[] args) {
        SmallestMissingNum missingNum = new SmallestMissingNum();

        int[] nums = {1,3,4,2,6,1};
        System.out.println("input: " + Arrays.toString(nums));

        System.out.println("output: " + missingNum.solution(nums));

        int[] nums2 = {1,2,3};
        System.out.println("input: " + Arrays.toString(nums2));

        System.out.println("output: " + missingNum.solution(nums2));

        int[] nums3 = {-1,2,3};
        System.out.println("input: " + Arrays.toString(nums3));

        System.out.println("output: " + missingNum.solution(nums3));

        int[] nums4 = {-1,-2, 1, 34};
        System.out.println("input: " + Arrays.toString(nums4));

        System.out.println("output: " + missingNum.solution(nums4));
    }
}
