package javasolutionsforalgorithms.revision_v2.leetcode.google.arrays;

/**
 * <a href="https://leetcode.com/problems/majority-element/">...</a>
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class BoyerMooreMajorityVotingAlgorithm {

    /**
     * The Boyer-Moore algorithm is a two-step process.
     * We will first try to find a candidate for the majority element in the array.
     * If a majority element exists, this candidate will be the majority element.
     * Otherwise, there will be no majority element in the array.
     *
     *
     * https://leetcode.com/problems/majority-element/description/
     * https://www.youtube.com/watch?v=gY-I8uQrCkk
     * https://leetcode.com/problems/majority-element/editorial/
     * https://www.geeksforgeeks.org/boyer-moore-majority-voting-algorithm/
     *
     *
     */
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;

        for (int num : nums) {

            if (count == 0) {
                element = num;
                count = 1;
            } else {
                if (element == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return element;
    }
}
