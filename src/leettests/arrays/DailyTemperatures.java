package leettests.arrays;

import java.util.Arrays;

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
