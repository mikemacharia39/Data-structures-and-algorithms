package general;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a string s1 and a string s2, write a snippet to say whether s2 is a rotation of s1?
 * (eg given s1 = ABCD and s2 = CDAB, return true, given s1 = ABCD, and s2 = ACBD , return false)
 */
public class ShiftStrings {

    /**
     * Clever solution
     * @param s1 original
     * @param s2 shifted
     * @return true|false
     */
    public boolean isShifted(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        Queue<Character> q1 = new LinkedList<>();
        for (char c : s1.toCharArray()) {
            q1.add(c);
        }

        Queue<Character> q2 = new LinkedList<>();
        for (char c : s2.toCharArray()) {
            q2.add(c);
        }

        int k = s2.length();
        while (k > 0) {
            k--;

            // here we are shifting the elements in q2 while comparing if the shifted q2 is equal to original q1
            char x = q2.peek();
            q2.remove();
            q2.add(x);

            if (q2.equals(q1)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Clever solution
     * @param s1 original
     * @param s2 shifted
     * @return true|false
     */
    public boolean isShiftedSol1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        if ((s1 + s1).contains(s2)) {
            return true;
        }
        return false;
    }


    /**
     * Brute force
     * @param s1 original
     * @param s2 shifted
     * @return true|false
     */
    public boolean isShiftedSln2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            s1 = shiftRight(s1);
            if (s1.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    public String shiftRight(String str) {
        return str.substring(1) + str.charAt(0);
    }

    public static void main(String[] args) {
        String s1 = "ABCD", s2 = "CDAB";

        ShiftStrings shiftStrings = new ShiftStrings();
        boolean isShifted = shiftStrings.isShifted(s1, s2);

        System.out.printf("Is shifted: %s", isShifted);

        System.out.println();

        String s3 = "ABCD", s4 = "ABDC";
        boolean isShifted2 = shiftStrings.isShifted(s3, s4);

        System.out.printf("Is shifted: %s", isShifted2);
    }
}
