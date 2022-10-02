package javasolutionsforalgorithms.hackerrank.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * There is a collection of input strings and a collection of query strings.
 * For each query string, determine how many times it occurs in the list of input strings.
 * Return an array of the results.
 *
 * Example
 *
 * StringList = {"ab", "ab", "abc"}
 * queries = {"ab", "abc", "bc"}
 * There are two instances of ab, there is 1 instance of abc, there is 0 of bc, thereby the result is [2,1,0]
 *
 * Function Description
 *
 * Complete the function matchingStrings in the editor below.
 * The function must return an array of integers representing the frequency of occurrence of each query string in stringList.
 *
 * matchingStrings has the following parameters:
 *
 * string stringList[n] - an array of strings to search
 * string queries[q] - an array of query strings
 */
public class SparseArrays {


    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {

        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> stringListFreq = new HashMap<>();

        for (String str : stringList) {
            stringListFreq.put(str, stringListFreq.getOrDefault(str, 0)+1);
        }

        for (String query : queries) {
            result.add(stringListFreq.getOrDefault(query, 0));
        }

        return result;
    }

    /**
     * use two loops, the top loop traverses through each query while checking its existence in the string list
     * time complexity: O(m * n)
     * space complexity: O(1) the list space is expected
     * @param stringList string list
     * @param queries queries
     * @return list
     */
    public static List<Integer> matchingStrings2(List<String> stringList, List<String> queries) {

        List<Integer> result = new ArrayList<>();
        Iterator<String> iterator = queries.iterator();

        while(iterator.hasNext()) {
            String query = iterator.next();
            int count = 0;
            for (int i = 0; i < stringList.size(); i++) {
                if (query.equals(stringList.get(i))) {
                    count++;
                }
            }
            result.add(count);
            count = 0;
        }

        return result;
    }
}
