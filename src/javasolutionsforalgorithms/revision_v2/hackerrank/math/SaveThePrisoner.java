package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * A jail has a number of prisoners and a number of treats to pass out to them. Their jailer decides the
 * fairest way to divide the treats is to seat the prisoners around a circular table in sequentially numbered chairs. A chair number will be drawn from a hat. Beginning with the prisoner in that chair, one candy will be handed to each prisoner sequentially around the table until all have been distributed.
 *
 * The jailer is playing a little joke, though. The last piece of candy looks like all the others, but it tastes awful.
 * Determine the chair number occupied by the prisoner who will receive that candy.
 * Example:
 * n = 4
 * m = 6
 * s = 2
 *
 * There are 4 prisoners, 6 pieces of candy and distribution starts at chair 2.
 * The prisoners arrange themselves in seats numbered 1 to 4. Prisoners receive candy at positions 2,3,4,1,2,3.
 * The prisoner to be warned sits in chair number 3.
 */
public class SaveThePrisoner {
    /**
     * s + m - 1: Represents the number of steps taken from the starting position s to reach the last candy.
     * We subtract 1 because the first candy is given to prisoner s itself.
     *
     * % n: Wraps around the circle if we go past the last prisoner.
     *
     * If (s + m - 1) % n == 0, it means it landed exactly on the last prisoner (prisoner number n), otherwise return the result.
     *
     * @param n number of prisoners
     * @param m count of sweets
     * @param s starting position
     * @return affected prisoner
     */
    public static int saveThePrisoner(int n, int m, int s) {
        // Calculate the position of the last candy
        int lastCandyPosition = (s + m - 1) % n;

        // If the last candy position is 0, it means the last candy goes to the last prisoner
        return lastCandyPosition == 0 ? n : lastCandyPosition;
    }

    /**
     * Shifts s to 0-based index by doing s - 1
     *
     * Adds m - 1 steps
     *
     * Modulo n to wrap around
     *
     * Adds 1 to convert back to 1-based indexing
     *
     * @param n number of prisoners
     * @param m count of sweets
     * @param s starting position
     * @return affected prisoner
     */
    public static int saveThePrisoner2(int n, int m, int s) {
        return ((s - 1 + m - 1) % n) + 1;
    }
}
