package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/self-dividing-numbers/
 *
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * A self-dividing number is not allowed to contain the digit zero.
 *
 * Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right]
 *
 * Example 1:
 * Input: left = 1, right = 22
 * Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
 *
 * Example 2:
 * Input: left = 47, right = 85
 * Output: [48,55,66,77]
 */
public class SelfDividingNumbers {

    /**
     * Time complexity O(n^2)
     * Space complexity O(1) since the memory list is expected
     * @param left int
     * @param right int
     * @return list
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            String num = Integer.toString(i);
            if (!num.contains("0")) {
                int len = num.length();
                int countLoop = 0;
                for (int j = 0; j < len; j++) {
                    if (i % Integer.parseInt(String.valueOf(num.charAt(j))) == 0) {
                        countLoop++;
                        if (countLoop == len) {
                            list.add(i);
                        }
                    }
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        SelfDividingNumbers dividingNumbers = new SelfDividingNumbers();

        int left = 999;
        int right = 1234;

        System.out.println("Numbers: " + dividingNumbers.selfDividingNumbers(left, right));
    }
}
