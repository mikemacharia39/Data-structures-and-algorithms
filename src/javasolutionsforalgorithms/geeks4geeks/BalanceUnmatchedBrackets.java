package javasolutionsforalgorithms.geeks4geeks;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BalanceUnmatchedBrackets {

    public static String balancedBrackets(String str) {
        int missing = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                missing++;
            } else {
                missing--;
            }
        }

        if (missing < 0) {
            for (int i = 0; i < Math.abs(missing); i++) {
                str = '(' + str;
            }
        }

        missing = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                missing++;
            } else {
                missing--;
            }
        }

        if (missing != 0) {
            for (int i = 0; i < Math.abs(missing); i++) {
                str = str + ')';
            }
        }

        return str;
    }

    // Function to return balancedBrackets string
    public static String balancedBrackets1(String str) {
        // Initializing dep to 0
        int dep = 0;

        // Stores maximum negative depth
        int minDep = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                dep++;
            } else {
                dep--;
            }

            // if dep is less than minDep
            if (minDep > dep) {
                minDep = dep;
            }
        }

        // if minDep is less than 0 then there
        // is need to add '(' at the front
        if (minDep < 0) {
            for (int i = 0; i < Math.abs(minDep); i++) {
                str = '(' + str;
            }
        }

        // Reinitializing to check the updated string
        dep = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                dep++;
            } else {
                dep--;
            }
        }

        // if dep is not 0 then there
        // is need to add ')' at the back
        if (dep != 0) {
            for (int i = 0; i < dep; i++) {
                str = str + ')';
            }
        }
        return str;
    }

    public static void main(String[] args) {

        String str = ")))()";
        // -3
        // ((()))()
        // 0

        Logger.getLogger(BalanceUnmatchedBrackets.class.getName())
                .log(Level.INFO, "Balance Bracket is {0}", BalanceUnmatchedBrackets.balancedBrackets(str));
    }
}
