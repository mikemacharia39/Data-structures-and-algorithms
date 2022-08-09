package hackerrank.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Given two arrays of integers, find which elements in the second array are missing from the first array.
 *
 * brr = [203 204 205 206 207 208 203 204 205 206]
 * arr = [203 204 204 205 206 207 205 208 203 206 205 206 204]
 *     = [204 205 206]
 *
 * The brr array is the orginal list. The numbers missing are .
 *
 * Notes:
 * If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same.
 * If that is not the case, then it is also a missing number.
 * Return the missing numbers sorted ascending.
 * Only include a missing number once, even if it is missing multiple times.
 */
public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        TreeMap<Integer, Integer> arrMap = new TreeMap<>();
        TreeMap<Integer, Integer> brrMap = new TreeMap<>();

        arr.forEach(n -> {
            if (arrMap.containsKey(n)) {
                arrMap.put(n, arrMap.get(n) + 1);
            } else {
                arrMap.put(n, 1);
            }
        });

        brr.forEach(a -> {
            if (brrMap.containsKey(a)) {
                brrMap.put(a, brrMap.get(a) + 1);
            } else {
                brrMap.put(a, 1);
            }
        });

        /**
         * To get distinct nums in List
         * List<Integer> missingNums = new ArrayList<>();
         * List<Integer> distictNums = missingNums.stream().distinct().collect(Collectors.toList());
         */

        TreeSet<Integer> missingNums = new TreeSet<>();
        for (Map.Entry<Integer, Integer> entrybrr : brrMap.entrySet()) {
            if (arrMap.containsKey(entrybrr.getKey())) {
                if (!Objects.equals(entrybrr.getValue(), arrMap.get(entrybrr.getKey()))) {
                    missingNums.add(entrybrr.getKey());
                }
            } else {
                missingNums.add(entrybrr.getKey());
            }
        }

        return new ArrayList<>(missingNums);
    }

    public static void main(String[] args) {

        List<Integer> list = List.of(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> list2 = List.of(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);

        System.out.println(MissingNumbers.missingNumbers(list, list2));
    }
}
