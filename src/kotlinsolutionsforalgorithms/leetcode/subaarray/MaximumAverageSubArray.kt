package kotlinsolutionsforalgorithms.leetcode.subaarray

/**
 * <a href="https://leetcode.com/problems/maximum-average-subarray-i/">...</a>
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 *
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
 * Any answer with a calculation error less than 10^5 will be accepted.
 *
 * Example 1:
 *
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
class MaximumAverageSubArray {

    fun findMaxAverage(nums: IntArray, k: Int) : Double {
        var sum = 0
        var left = 0
        var average = -10000.0

        for (right in nums.indices) {
            sum += nums[right]

            if (right >= k - 1) {
                average = Math.max(average, sum.toDouble() / k)
                sum -= nums[left]
                left++
            }

        }
        return average
    }
}

fun main() {
    val maximumAverageSubArray = MaximumAverageSubArray()
    println(maximumAverageSubArray.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
    println(maximumAverageSubArray.findMaxAverage(intArrayOf(-1), 1))
}
