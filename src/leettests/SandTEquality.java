package leettests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SandTEquality {


    public static void main(String[] args) {
        SandTEquality backspaceCompare = new SandTEquality();

        //String S = "a##c", T = "#a#c";
        //String S = "ab##", T = "c#d#";
        String S = "ab#####c###", T = "#######ad#c######";
        //String S = "a#c", T = "b";

        boolean status = backspaceCompare.backspaceCompare(S, T);

        System.out.println("status: " + status);
    }

    public boolean backspaceCompare(String S, String T) {

        if(S.length() < 1 || S.length() > 200) {
            System.out.println("String S is not of valid length");
            return false;
        }

        if(T.length() < 1 || T.length() > 200) {
            System.out.println("String T is not of valid length");
            return false;
        }

        String charRegex = "^(([a-z]{1,})|([a-z#]{1,}))$";
        Pattern stringPattern = Pattern.compile(charRegex);
        Matcher stringSPatternMatcher = stringPattern.matcher(S);
        Matcher stringTPatternMatcher = stringPattern.matcher(T);

        if(!stringSPatternMatcher.matches() || !stringTPatternMatcher.matches()) {
            System.out.println("String S or T is invalid");
            return false;
        }

        System.out.println("S initial String: " + S + " |  T initial String: " + T);

        CharSequence hashValue = String.valueOf('#');

        if(S.charAt(0) == '#') {
            S = S.substring(1);
        }

        if(T.charAt(0) == '#') {
            T = T.substring(1, T.length());
        }

        if(S.contains(hashValue)) {
            int posOfHashInS;
            boolean isCompletedSSearch = false;
            while (!isCompletedSSearch) {
                posOfHashInS = S.indexOf("#");
                CharSequence charEmptyValue = String.valueOf(Character.MIN_VALUE);

                char[] charArray = S.toCharArray();
                charArray[posOfHashInS] = Character.MIN_VALUE;

                if(S.charAt(0) != '#') {
                    charArray[posOfHashInS - 1] = Character.MIN_VALUE;
                }

                S = new String(charArray);
                S = S.replace(charEmptyValue, "");

                if (S.length() > 0 && S.charAt(0) == '#') {
                    S = S.substring(1);
                }

                if (!S.contains(hashValue)) {
                    isCompletedSSearch = true;
                }
            }
        }

        if(T.contains(hashValue)) {
            int posOfHashInT;
            boolean isCompletedTSearch = false;
            while (!isCompletedTSearch) {
                posOfHashInT = T.indexOf("#");
                CharSequence charEmptyValue = String.valueOf(Character.MIN_VALUE);

                char[] charArray = T.toCharArray();
                charArray[posOfHashInT] = Character.MIN_VALUE;

                if(T.charAt(0) != '#') {
                    charArray[posOfHashInT - 1] = Character.MIN_VALUE;
                }

                T = new String(charArray);
                T = T.replace(charEmptyValue, "");

                if (T.length() > 0 && T.charAt(0) == '#') {
                    T = T.substring(1);
                }

                if (!T.contains(hashValue)) {
                    isCompletedTSearch = true;
                }
            }
        }

        System.out.println("S final String: " + S + " |  T initial String: " + T);

        if(S.equals(T)) {
            return true;
        }

        return false;
    }
}
