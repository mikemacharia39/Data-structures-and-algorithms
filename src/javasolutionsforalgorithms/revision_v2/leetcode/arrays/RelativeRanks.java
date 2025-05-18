package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/relative-ranks/description/?envType=problem-list-v2&envId=array">...</a>
 *
 * You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.
 *
 * The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
 *
 * The 1st place athlete's rank is "Gold Medal".
 * The 2nd place athlete's rank is "Silver Medal".
 * The 3rd place athlete's rank is "Bronze Medal".
 * For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
 * Return an array answer of size n where answer[i] is the rank of the ith athlete.
 *
 * Example 1:
 * Input: score = [5,4,3,2,1]
 * Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
 *
 *
 * Example 2:
 * Input: score = [10,3,8,9,4]
 * Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        Map<Integer, Integer> map = new TreeMap<>((a, b) -> {
            return Integer.compare(b, a); // REVERSE ORDER
        });

        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }

        int count = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count == 1) {
                result[entry.getValue()] = "Gold Medal";
            } else if (count == 2) {
                result[entry.getValue()] = "Silver Medal";
            } else if (count == 3) {
                result[entry.getValue()] = "Bronze Medal";
            } else {
                result[entry.getValue()] = Integer.toString(count);
            }
            count++;
        }
        return result;
    }

    /**
     * This is a more efficient solution that uses sorting.
     * @param score
     * @return
     */
    public String[] findRelativeRanks1(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Step 1: Create array of [score, index] pairs
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i];
            scoreWithIndex[i][1] = i;
        }

        // Step 2: Sort in descending order by score
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        // Step 3: Assign ranks
        for (int i = 0; i < n; i++) {
            int idx = scoreWithIndex[i][1];
            if (i == 0) {
                result[idx] = "Gold Medal";
            } else if (i == 1) {
                result[idx] = "Silver Medal";
            } else if (i == 2) {
                result[idx] = "Bronze Medal";
            } else {
                result[idx] = String.valueOf(i + 1);
            }
        }

        return result;
    }
}
