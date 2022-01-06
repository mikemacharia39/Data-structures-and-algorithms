package leettests.arrayandstrings;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSumAdvanced {

    /*
        Approach: Sort the array. Have a set of list of integers (threeSumSet), to store three sum cobos.
                  Go through each item (i).
                  For each item, have two pointers: one pointing to the next item (j), and another
                  one pointing to the end of the array (k). Now, do a 2-way-sweep. While j and k doesn't meet, at each step
                  calculate sum = (nums[i]+nums[j]+nums[k]).
                  [Starting sweep from next item to prevent duplicate combos because of indexes like ( [i,j,k], [j,i,k]).]
                  If sum == 0, we found a three-sum combo! Add it to the threeSumSet. If there is any
                  duplicate combo because of different indexes but same items like
                  ([i1, j1, k1], [i2, j2, k2], but i1==i2, j1==j2, k1==k2). This will automatically be taken care of by the
                  set, as it analyzes the added Lists and makes sure there is no duplicate.
                  If sum > 0, we should try decreasing the sum value. So we'll decrement k, as this should potentially
                  result nums[k] being smaller than previous value, as the array is sorted.
                  If sum < 0, because of the same reason, we'll increment j.
                  Finally, we'll convert the threeSumSet to ArrayList and return.

        Complexity analysis: Time: O(n^2), Space: O(n)
        */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> threeSumSet  = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length-2;i++) { //Doing length-2, because we want two elems j and k after i.
            int j =i+1;

            int k = nums.length-1;

            while(j<k){

                int sum = nums[i]+nums[j]+nums[k];

                if(sum==0){
                    threeSumSet.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;
                } else if (sum > 0){
                    k--;
                } else if (sum < 0){
                    j++;
                }
            }

        }

        return new ArrayList<>(threeSumSet);
    }

    public static void main(String[] args) {
        ThreeSumAdvanced sumAdvanced = new ThreeSumAdvanced();

        int[] nums = {-1,0,1,2,-1,-4};
        //Output: [[-1,-1,2],[-1,0,1]]

        System.out.println(sumAdvanced.threeSum(nums));
    }
}
