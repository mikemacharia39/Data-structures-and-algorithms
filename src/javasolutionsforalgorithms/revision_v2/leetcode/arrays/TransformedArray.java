package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

public class TransformedArray {

    /**
     * <a href="https://youtu.be/LFu7jcf0pKs">...</a>
     */
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[((i + nums[i] % n) + n) % n];
        }
        return result;
    }
}
