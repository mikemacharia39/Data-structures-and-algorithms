package javasolutionsforalgorithms.leettests.interestingquestions;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water/">...</a>
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {

    /**
     * Best Explanation
     * <a href="https://leetcode.com/problems/container-with-most-water/discuss/1915172/JavaC%2B%2B-Easiest-Explanations">...</a>
     * Time complexity O(n)
     * Start from the extreme right and left of the x axis and narrow down to the most
     * volume -> <-
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while (left < right) {
            int containerLen = right - left;
            int waterHeight = Math.min(height[left], height[right]);
            int area = containerLen * waterHeight;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxWater;
    }

    /**
     * Brute force
     * Time complexity 0(n^2)
     * Space complexity O(1)
     * Find the length from a certain position x to position x + distance
     * The maximum height of water at any position is determined by the height of the
     * lesser height level
     * Loop through this until you get the max height
     *
     */
    public int maxArea_BruteForce(int[] height) {

        int containerLength = height.length;
        int maxArea = 0;
        for (int i = 0; i < containerLength; i++) {
            for (int j = i + 1; j < containerLength; j++) {

                int length = j - i;
                int waterHeight = Math.min(height[i], height[j]);
                int area = length * waterHeight;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
