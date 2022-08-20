package javasolutionsforalgorithms.leettests.stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 *
 * Example 1:
 *
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 *
 * Example 2:
 *
 * Input: temperatures = [30,40,50,60]
 * Output: [1,1,1,0]
 *
 * Example 3:
 *
 * Input: temperatures = [30,60,90]
 * Output: [1,1,0]
 */
public class DailyTemperatures {

    /**
     * This solution uses a stack with array
     *
     * Monotonic Stack
     * ---------------
     * Whenever a problem requires enumerating values for indices on the basis of other values in an array,
     * one should think of including a stack in the solution!
     * And that too, a monotonic stack.
     * It is simply a stack which contains values in a monotonic order; i.e. either increasing or decreasing.
     * Imagine there is a data structure which contains the indices whose temperatures are in an increasing order.
     * Then, enumerating the next index which has a greater temperature will be easy: we simply pop the elements till
     * the top element has a greater temperature than the current index! Refer to the following picture for better understanding.
     *
     * <a href="https://leetcode.com/problems/daily-temperatures/discuss/1574775/A-Classic-Stack-Problem-or-Detailed-Explanation-%2B-Picture-or-C%2B%2B-or-Java-or-Python-or-NovemberChallenge">...</a>
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>(); // the stack will contain arr. arr with temp and it's index
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < currentTemp) {
                int[] prevDay = stack.pop();
                int prevIndex = prevDay[1]; // prev day index
                result[prevIndex] = i - prevIndex;
            }

            stack.push(new int[] {currentTemp, i});
        }

        return result;
    }

    /**
     * Better solution
     */
    public int[] dailyTemperatures1(int[] temperatures) {
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
    public int[] dailyTemperatures2(int[] temperatures) {

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
