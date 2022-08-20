package javasolutionsforalgorithms.leettests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AtoiTest {

    public static void main(String[] args) {

        String atoi = "             -+12";// "+1331";//"-+12";//"words and 987";//"-42786857657465465 njfjfjjfjf    * % #                       ";

        AtoiTest atoiTest = new AtoiTest();

        System.out.println(atoiTest.myAtoi(atoi));
    }

    public int myAtoi(String str) {

        String regex = "([-+]?\\d+)([\\s+-.\\da-zA-Z]*)";

        if (str.equals("")) {
            return 0;
        }

        str = str.trim();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if (!matcher.matches()) {
            System.out.println("No Match!");
            return 0;
        } else {
            str = matcher.group(1);

            System.out.println("After sanitizing = " + str);

            double x = 0;
            try {
                x = Double.parseDouble(str);
                if (x < Integer.MIN_VALUE) {
                    x = Integer.MIN_VALUE;
                }

                if (x > Integer.MAX_VALUE) {
                    x = Integer.MAX_VALUE;
                }
            } catch (NumberFormatException nfe) {
                return 0;
            }

            return (int)x;
        }

    }
}
