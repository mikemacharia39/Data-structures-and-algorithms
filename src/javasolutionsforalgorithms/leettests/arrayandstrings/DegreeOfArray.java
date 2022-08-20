package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/degree-of-an-array/
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum
 * frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) sub array of nums,
 * that has the same degree as nums.
 *
 * Example 1:
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 *
 * Example 2:
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 */
public class DegreeOfArray {

    public int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> numDegree = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numDegree.containsKey(nums[i])) {
                numDegree.put(nums[i], numDegree.get(nums[i])+1);
            } else {
                numDegree.put(nums[i], 1);
            }
        }

        // Loop through hashmap, while comparing the degree of and
        // comparing the maximum subarray

        int maxDegree = 0;
        int minSubArray = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entries : numDegree.entrySet()) {
            int valueDegree = entries.getValue();
            if (valueDegree > maxDegree) {
                maxDegree = valueDegree;

                int valDistance = valDistance(nums, entries.getKey());
                minSubArray = valDistance;
            }
            if (valueDegree == maxDegree) {
                int valDistance = valDistance(nums, entries.getKey());
                minSubArray = Math.min(minSubArray, valDistance);
            }
        }

        return minSubArray;
    }

    /**
     * Finds distance between first and last element
     */
    private int valDistance(int[] nums, int val) {
        int firstIndex = Integer.MAX_VALUE;
        int lastIndex = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && firstIndex == Integer.MAX_VALUE) {
                firstIndex = i;
            }

            if (nums[i] == val && lastIndex <= i) {
                lastIndex = i;
            }
        }

        if (lastIndex == Integer.MIN_VALUE) {
            lastIndex = 0;
        }

        return (lastIndex - firstIndex) + 1;
    }

    public static void main(String[] args) {
        DegreeOfArray degreeOfArray = new DegreeOfArray();
        int[] nums = {1,2,2,3,1,4,2};
        //Output: 6
        System.out.println("Ans: " + degreeOfArray.findShortestSubArray(nums));
    }

}
