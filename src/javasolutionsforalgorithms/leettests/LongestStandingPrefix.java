package javasolutionsforalgorithms.leettests;

import java.util.Arrays;

public class LongestStandingPrefix {

    public static void main(String[] args) {
        LongestStandingPrefix ls = new LongestStandingPrefix();

        //String[] strs = {"flower","fl","flight"};
        String[] strs = {"Geese","Geeks","Geeksforgeeks"};

        System.out.println(ls.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {

        int strCount = strs.length;
        int startLength = 1;
        String prefix = "";

        Arrays.sort(strs);

        int shortStrLength = strs[0].length();
        for (int j = 0; j < shortStrLength; j++) {
            if (strs[0].substring(0, startLength).equals(strs[strCount - 1].substring(0, startLength))) {
                prefix = strs[0].substring(0, startLength);
            } else {
                break;
            }


            startLength++;
        }
        return prefix;
    }
}
