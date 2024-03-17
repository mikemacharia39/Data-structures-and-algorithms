package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.Comparator;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * Hackerland is a one-dimensional city with houses aligned at integral locations along a road.
 * The Mayor wants to install radio transmitters on the roofs of the city's houses.
 * Each transmitter has a fixed range meaning it can transmit a signal to all houses within that number of units distance away.
 *
 * Given a map of Hackerland and the transmission range, determine the minimum number of transmitters so that every house
 * is within range of at least one transmitter. Each transmitter must be installed on top of an existing house.
 *
 * Example 1:
 * arr = [1, 2, 3, 4, 5]
 * k = 1
 *
 * Answer = 2, because the range of the transmitter is 1, so the transmitter can be installed at 2 and 4
 *
 * Example 2:
 * arr = [7, 2, 4, 6, 5, 9, 12, 11]
 * k = 2
 *
 * Answer = 3, because the range of the transmitter is 2, so the transmitter can be installed at 4, 9 and 12
 *
 */
public class HackerLandRadioTransmitters {

    /**
     * Explanation:
     * Time complexity: O(nlogn)
     * @param x number of houses
     * @param k distance
     * @return
     */
    public static int hackerlandRadioTransmitters(List<Integer> x, int k) {
        x.sort(Integer::compareTo);
        int i = 0;
        int n = x.size();
        int result = 0;

        while (i < n) {
            int loc = x.get(i) + k; // loc is the location of the transmitter
            while (i < n && x.get(i) <= loc) { // find the next house that is within the range of the transmitter
                i++;
            }
            loc = x.get(i-1) + k;// loc is the location of the transmitter
            while (i < n && x.get(i) <= loc) {// find the next house that is within the range of the transmitter
                i++;
            }
            result++;
        }

        return result;
    }

    public static int hackerlandRadioTransmitters1(List<Integer> x, int k) {
        // x= 7 2 4 6 5 9 12 11 = 2,4,5,6,7,9,11,12
        // k= 2

        x.sort(Comparator.naturalOrder());
        int transmitters = 0;

        int i = 0;
        int noOfHouses = x.size();
        while (i < noOfHouses) {
            int transmitterLocation = 0;

            transmitterLocation = x.get(i); // the current position of a transmitter when we start

            while (i < noOfHouses && x.get(i) <= transmitterLocation + k) {
                i++;
            }

            transmitterLocation = x.get(i - 1);  // Position the transmitter at the rightmost house within range.

            // try position the transmitter at the next house outside the range
            while(i < noOfHouses && x.get(i) <= transmitterLocation + k) {
                i++;
            }


            transmitters++;
        }

        return transmitters;
    }
}
