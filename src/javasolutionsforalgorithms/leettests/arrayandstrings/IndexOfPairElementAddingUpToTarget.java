package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of values and a target sum k. Return the index of pair elements adding up to the sum.
 *
 * Example:
 * nums = [1,4,5,3,7], target = 12
 *
 * Answer = [5,7]
 */
public class IndexOfPairElementAddingUpToTarget {

    public static void main(String[] args) {

        IndexOfPairElementAddingUpToTarget addingUpToTarget = new IndexOfPairElementAddingUpToTarget();

        int[] nums = {1,4,5,3,10,2};
        int target = 12;

        System.out.println(Arrays.toString(addingUpToTarget.solution(nums, target)));
    }

    /**
     * Aim to loop once 0(n)
     * @param nums numbers
     * @param target target
     * @return indices of the result
     */
    private int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    /**
     * This is an O(n^2) solution because we are looping through the array twice
     * @param nums numbers in array
     * @param target sum of two numbers in the array
     * @return indices of the 2 numbers whose sum is equal to the target
     */
    private int[] solution1(int[] nums, int target) {

        int[] pairs = new int[2];

        if (nums.length == 0) {
            return pairs;
        }

        // we want to have two indexes, a fast one and a slow one
        // where we check from left to right if the the target - slow val = fast val

        for (int i = 0; i < nums.length; i++) {
            int otherPair = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (otherPair == nums[j]) {
                    pairs[0] = i;
                    pairs[1] = j;
                }
            }
        }

        return pairs;
    }
}
