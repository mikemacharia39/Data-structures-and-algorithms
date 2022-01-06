package leettests.arrayandstrings;

import java.util.Arrays;

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

    private int[] solution(int[] nums, int target) {

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
