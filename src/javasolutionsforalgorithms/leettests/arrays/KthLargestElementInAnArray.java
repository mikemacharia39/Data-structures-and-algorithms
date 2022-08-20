package javasolutionsforalgorithms.leettests.arrays;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * You must solve it in O(n) time complexity.
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 *
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class KthLargestElementInAnArray {

    /**
     * It's interesting because it's kth largest not kth element
     * which means you should start checking the largest element from the right or from the last
     */
    public int findKthLargest(int[] nums, int k) {
        int[] freq = new int[20001];             // to cater for -10000 to 0 to 10000

        for(int num: nums) {
            int currFreq = freq[num + 10000];    // increment the val at the index
            freq[num + 10000] = currFreq+1;
        }

        int count = 0;
        for(int i = freq.length-1; i >= 0; i--) {
            if(freq[i] > 0) {
                count += freq[i];                // from the behind start counting
            }

            if(count >= k){
                return i - 10000;       // the position represents the value, since we initially did num + 10000,
                // we need to decrement 10000 to get original value
            }
        }
        return -1;
    }

    /**
     * It's interesting because it's kth largest not kth element
     * which means you should start checking the largest element from the right or from the last
     */
    public int findKthLargest1(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        int count = nums.length - k; // change here
        for (int x : map.keySet()) {
            if (map.get(x) >= 1) {
                count -= map.get(x);
            }

            if (count < 0) {
                return x;
            }
        }

        return -1;
    }

    /**
     * It's interesting because it's kth largest not kth element
     * which means you should start checking the largest element from the right or from the last
     */
    public int findKthLargest2(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        int count = 0;
        for (int x : map.keySet()) {
            if (map.get(x) >= 1) {
                count += map.get(x);
            }

            if (count >= k) {
                return x;
            }
        }

        return -1;
    }
}
