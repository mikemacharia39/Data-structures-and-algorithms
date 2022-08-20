package javasolutionsforalgorithms.leettests;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 * Example 2:
 *
 * Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
 * Output: 5
 * ----------------------------------------------------------------------
 * Approach #3: Dynamic Programming [Accepted]
 * Intuition and Algorithm
 *
 * Since a common subarray of A and B must start at some A[i] and B[j], let dp[i][j] be the
 * longest common prefix of A[i:] and B[j:]. Whenever A[i] == B[j], we know dp[i][j] = dp[i+1][j+1] + 1.
 * Also, the answer is max(dp[i][j]) over all i, j.
 *
 * We can perform bottom-up dynamic programming to find the answer based on this recurrence.
 * Our loop invariant is that the answer is already calculated correctly and stored in dp for any larger i, j.
 *
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();

        int[] nums1 = {1,2,3,2,1}, nums2 = {3,2,1,4,7};
        int maxLength = maximumLengthOfRepeatedSubarray.findLength(nums1, nums2);
    }

    public int findLength(int[] nums1, int[] nums2) {

        int dp[][] = new int[nums1.length+1][nums2.length+1];
        int ans = 0;

        for(int i = 1; i<=nums1.length; i++) {
            for(int j = 1; j<=nums2.length; j++) {
                if( nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];  // dp[2][0] = 1 +
                    ans = Math.max(ans, dp[i][j]);

                    System.out.println("");
                    System.out.print("Ans: " + ans + " | dp ij: " + dp[i][j] + " | ");
                    System.out.print("dp-ij: " + dp[i-1][j-1]);
                }
            }
        }

        return ans;

    }
}
