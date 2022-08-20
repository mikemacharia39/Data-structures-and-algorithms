package javasolutionsforalgorithms.leettests.string_manipulation;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 *
 * A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
 *
 * Letters in some of the SOS messages are altered by cosmic radiation during transmission.
 * Given the signal received by Earth as a string, SOSTOT,
 * determine how many letters of the SOS message have been changed by radiation.
 *
 * Example
 *
 * SOSTOT
 *
 * The original message was SOSSOS. Two of the message's characters were changed in transit.
 *
 * Function Description
 *
 * Complete the marsExploration function in the editor below.
 *
 * marsExploration has the following parameter(s):
 *
 * string s: the string as received on Earth
 *
 * -------------------------------------------------
 *
 * Example 1
 *
 * SOSSPSSQSSOR
 * Sample Output 0
 *
 * 3
 * Explanation 0
 *
 * SOSSPSSQSSOR, and signal length . They sent  SOS messages (i.e.: ).
 *
 * Expected signal: SOSSOSSOSSOS
 * Recieved signal: SOSSPSSQSSOR
 * Difference:          X  X   X
 *
 *
 */
class MarsExploration {
    public int marsExploration(String s) {

        // Use a regex to limit only the matching pattern and characters S O S
        // then find the difference between the remaining characters and initial
        // this doesn't work because you may have allowed characters causing the mismatch
        /**
         String sanitizeSOS = s.replaceAll("[^SOS]", "");
         return s.length() - sanitizeSOS.length();
         */

        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i%3)) { // because of the length of SOS
                count++;
            }
        }

        return count;
    }

}
