package hackerrank.arrays;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BigSortingProblem {
    public static List<String> bigSorting(List<String> unsorted) {

        // sort by value

        TreeMap<String, Integer> mTreeMap = new TreeMap<>();
        unsorted.forEach(str -> {
            if (mTreeMap.containsKey(str)) {
                mTreeMap.put(str, mTreeMap.get(str)+1);
            } else {
                mTreeMap.put(str, 1);
            }
        });

        List<String> sorted = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : mTreeMap.entrySet()) {
            int currRepeat = entry.getValue();
            String currVal = entry.getKey();

            for (int i = 0; i < currRepeat; i++) {
                sorted.add(currVal);
            }
        }

        // then sort by length of value
        Collections.sort(sorted, (a, b)->Integer.compare(a.length(), b.length()));

        return sorted;
    }
}
