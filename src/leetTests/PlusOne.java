package leetTests;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {

        PlusOne plusOne = new PlusOne();
        /**
         * {1,2,3,8,9,9,9,9,9,9,9,9,9,9,9}
         * {1,2,9}
         * {9,9,9}
         * {9,9,9,9,9,9,9,9,9,9,9}
         */
        int[] digits = {3,9,9,2};

        System.out.println(Arrays.toString(plusOne.solution(digits)));
    }

    public int[] solution(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigit = new int[digits.length + 1];
        newDigit[0] = 1;

        return newDigit;

    }
}
