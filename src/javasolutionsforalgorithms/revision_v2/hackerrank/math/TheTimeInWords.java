package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * Given the time in numerals we may convert it into words, as shown below:
 * 5:00 -> five o' clock
 * 5:01 -> one minute past five
 * 5:10 -> ten minutes past five
 * 5:15 -> quarter past five
 * 5:21 -> twenty one minutes past five
 * 5:28 -> twenty eight minutes past five
 * 5:30 -> half past five
 * 5:40 -> twenty minutes to six
 * 5:45 -> quarter to six
 * 5:59 -> one minute to six
 */
public class TheTimeInWords {
    public static String timeInWords(int h, int m) {

        String[] toWords = {"one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};

        StringBuilder sb = new StringBuilder();
        if (m == 0) {
            return sb.append(toWords[h - 1]).append(" o' clock").toString();
        }

        if (m == 15) {
            sb.append(toWords[m - 1]).append(" past ").append(toWords[h - 1]);
        } else if (m < 30) {
            if (m > 20) {
                sb.append(toWords[20 - 1]);
                int remainder = m % 20;
                sb.append(" ");
                sb.append(toWords[remainder - 1]);
            } else {
                sb.append(toWords[m - 1]);
            }
            sb.append(" ");

            if (m == 1) {
                sb.append("minute");
            } else {
                sb.append("minutes");
            }
            sb.append(" past ");
            sb.append(toWords[h - 1]);
        } else if (m == 30) {
            sb.append("half past ").append(toWords[h - 1]);
        } else if (m == 45) {
            int remainingTime = 60 - m;
            sb.append(toWords[remainingTime - 1]).append(" to ").append(toWords[h]);
        } else {
            int remainingTime = 60 - m;

            if (remainingTime > 20) {
                sb.append(toWords[20 - 1]);
                int remainder = remainingTime % 20;
                sb.append(" ");
                sb.append(toWords[remainder - 1]);
            } else {
                sb.append(toWords[remainingTime - 1]);
            }
            sb.append(" ");
            if (remainingTime == 1) {
                sb.append("minute");
            } else {
                sb.append("minutes");
            }
            sb.append(" to ");
            sb.append(toWords[h]);
        }

        return sb.toString();
    }
}
