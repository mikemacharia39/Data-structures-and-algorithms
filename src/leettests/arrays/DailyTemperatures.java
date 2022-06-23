package leettests.arrays;

import java.util.Arrays;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer
 * temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 *
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemperatures {
    /**
     * Better solution
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0 && temperatures[j] < temperatures[i]; j--) {
                result[j] = i - j;
            }
        }
        return result;
    }

    /**
     * Exceeded time limit
     */
    public int[] dailyTemperatures1(int[] temperatures) {

        int len = temperatures.length;
        int[] answer = new int[len];
        Arrays.fill(answer, 0);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (temperatures[i] < temperatures[j]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }
}
