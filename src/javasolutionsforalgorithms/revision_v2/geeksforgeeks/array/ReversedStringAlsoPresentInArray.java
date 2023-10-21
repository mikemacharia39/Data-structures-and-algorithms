package javasolutionsforalgorithms.revision_v2.geeksforgeeks.array;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Given a string array str[], the task is to find the first string from the given array whose reverse is
 * also present in the same array. If there is no such string then print -1.
 *
 * Examples:
 * Input: str[] = {“geeks”, “for”, “skeeg”}
 * Output: geeks
 * “geeks” is the first string from the array whose reverse is also present in the array i.e. “skeeg”.
 *
 * Input: str[] = {“there”, “you”, “are”}
 * Output: -1
 */
public class ReversedStringAlsoPresentInArray {

    /**
     * Time complexity: O(n)
     * @param arr
     * @return
     */
    public static String isPresent(String[] arr) {
        String result = "-1";
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String string : arr) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }

        for (String string : arr) {
            String reversed = reversedString(string);
            if (map.containsKey(reversed)) {
                result = string;
                break;
            }
        }
        return result;
    }


    /**
     * Time complexity: O(n^3)
     * @param arr
     * @return
     */
    public static String isPresent1(String[] arr) {
        String result = "-1";
        for (String string : arr) {
            String reversed = reversedString(string);
            for (String s : arr) {
                if (s.length() == reversed.length() && s.equals(reversed)) {
                    result = string;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Time complexity: O(n)
     * @param string
     * @return
     */
    private static String reversedString(String string) {
        int start = 0;
        int end = string.length() - 1;
        char[] arr = string.toCharArray();
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String[] arr = {"geeks", "for", "skeeg"};
        System.out.println(isPresent(arr));
    }
}
