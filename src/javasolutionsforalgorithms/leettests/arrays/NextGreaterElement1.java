package javasolutionsforalgorithms.leettests.arrays;

public class NextGreaterElement1 {


    private static int checkIfNextValue(int val, int[] nums2) {
        int count = 1;
        for(int i = 0; i < nums2.length; i++) {
            if (val == nums2[i]) {
                while (nums2.length > i+count) {
                    if (nums2[i+count] > val) {
                        return nums2[i+count];
                    }
                    count++;
                }
            }
        }
        return -1;
    }
}
