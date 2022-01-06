package leettests;

import java.util.Arrays;

public class MergeTwoArraysAndSort {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        MergeTwoArraysAndSort arraysAndSort = new MergeTwoArraysAndSort();
        int sorted[] = arraysAndSort.merge(nums1, m, nums2, n);

        for (int k = 0; k < sorted.length; k++) {
            System.out.print(nums1[k] + ",");
        }
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

//        int sizeOfArr = m+n;
//        int[] newArray = new int[sizeOfArr];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] >= nums2[j]) {
                    temp = nums1[i];
                    nums1[i] = nums2[j];
                    nums1[i+count] = temp;

                    count++;
                }
            }
        }

        return nums1;
    }

    public int[] merge2(int[] nums1, int m, int[] nums2, int n) {

        int count = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[m + count] = nums2[i - m];
            count++;
        }

        Arrays.sort(nums1);

        return nums1;
    }

    public int[] merge3(int[] nums1, int m, int[] nums2, int n) {

        int count = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[m + count] = nums2[i - m];
            count++;
        }

        for (int i = 0; i < nums1.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums1.length; j++) {
                if (nums1[i] >= nums1[j]) {
                    temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }

        return nums1;
    }
}
