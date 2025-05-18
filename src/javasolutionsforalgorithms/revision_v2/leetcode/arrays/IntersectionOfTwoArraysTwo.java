package javasolutionsforalgorithms.revision_v2.leetcode.arrays;

public class IntersectionOfTwoArraysTwo {
    public int[] intersect1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int minLen = Math.min(n,m);
        int[] temp = new int[minLen];
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(nums1[i] == nums2[j]){
                    temp[index++] = nums1[i]; // to temporarily save our values
                    nums2[j] = Integer.MIN_VALUE; // mark the matched element in nums2 to avoid reusing
                    break;
                }
            }
        }
        int[] result = new int[index];
        for(int i = 0; i < index; i++){
            result[i] = temp[i];
        }
        return result;
    }
}
