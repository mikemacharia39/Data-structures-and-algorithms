package codility;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string e.g. WXYZ, find all possible combinations
 * [W, WX, WXY, WXYZ, WXZ, WY, WYZ, WZ, X, XY, XYZ, XZ, Y, YZ, Z]
 *
 */
public class AllPossibleCombinationsOfString {
    List<String> stringList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> combinations(String s) {
        return combinations(s, 0);
    }

    public List<String> combinations(String s, int start) {
        int len = s.length();
        for (int i = start; i < len; i++) {
            sb.append(s.charAt(i));
            stringList.add(sb.toString());
            combinations(s, i+1);
            // In the first run length = 1, when you minus 1, you get 0, meaning we shall not append any character
            // in the second run length = 2, when you minus 1, you get 1, append the next character
            sb.setLength(sb.length() - 1);
        }

        return stringList;
    }

    public static void main(String[] args) {
        String s = "WXYZ";

        AllPossibleCombinationsOfString possibleCombinationsOfString = new AllPossibleCombinationsOfString();

        System.out.println(possibleCombinationsOfString.combinations(s));
    }
}
