package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * Lily likes to play games with integers. She has created a new game where she determines the difference between a number and its reverse.
 * For instance, given the number 12, its reverse is 21. The difference between 12 and 21 is 9.
 * She decides to apply her game to decision making. She will look at a numbered range of days and will only go to a movie on a beautiful day.
 *
 * Given a range of numbered days, i...j,  and a number k, determine the number of days in the range that are beautiful.
 * Beautiful numbers are defined as numbers where |i-reversed-i|  is evenly divisible by k.
 * If a day's value is a beautiful number, it is a beautiful day. Return the number of beautiful days in the range.
 */
public class BeautifulDaysAtTheMovies {

    public static int beautifulDays(int i, int j, int k) {
        int beautifulDays = 0;
        while (j >= i) {
            int currentNumber = i;
            int reversedNum = reverseNumber(currentNumber);
            int diff = Math.abs(currentNumber - reversedNum);

            if (diff % k == 0) {
                beautifulDays++;
            }
            i++;
        }
        return beautifulDays;
    }

    private static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            int modulus = num % 10;
            reversed = (reversed * 10) + modulus;
            num = num / 10;
        }
        return reversed;
    }
}
