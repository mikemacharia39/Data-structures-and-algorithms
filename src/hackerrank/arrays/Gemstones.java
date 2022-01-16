package hackerrank.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * https://www.hackerrank.com/challenges/gem-stones/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 *
 * There is a collection of rocks where each rock has various minerals embedded in it.
 * Each type of mineral is designated by a lowercase letter in the range ascii[a-z].
 * There may be multiple occurrences of a mineral in a rock.
 * A mineral is called a gemstone if it occurs at least once in each of the rocks in the collection.
 *
 * Given a list of minerals embedded in each of the rocks, display the number of types of gemstones in the collection.
 *
 * Example
 * arr = ['abc', 'cbc', 'abc']
 *
 * The minerals b and c appear in each rock, so there are 2  gemstones.
 *
 * Function Description
 *
 * Complete the gemstones function in the editor below.
 *
 * string arr[n]: an array of strings
 * Returns
 *
 * int: the number of gemstones found
 */
public class Gemstones {

    public static int gemstones(List<String> arr) {
        int size = arr.size();
        HashMap<Character, Integer> map = new HashMap<>();
        Iterator<String> it = arr.iterator();
        while (it.hasNext()) {
            HashSet<Character> set = new HashSet<>();
            String str = it.next();
            for (char c : str.toCharArray()) {
                if (!set.contains(c)) {
                    set.add(c);
                    map.put(c, map.getOrDefault(c, 0)+1);
                }
            }
            set.clear();
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == size) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("abc", "cbc", "abc");
        Logger.getLogger(Gemstones.class.getName())
                .log(Level.INFO, "Number of Gemstones {0}", Gemstones.gemstones(stringList));
    }
}
