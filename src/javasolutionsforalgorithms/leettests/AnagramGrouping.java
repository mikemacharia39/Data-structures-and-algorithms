package javasolutionsforalgorithms.leettests;

import java.util.*;

public class AnagramGrouping {

    public static void main(String[] args) {

        //String[] input = {""};
        // output [[""]]
        //String[] input = {"", ""};
        // output [["", ""]]
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat", "loot", "tool", "let", "tell", "", "a"};

        List<List<String>> myList = AnagramGrouping.groupAnagram(input);

        System.out.println(myList);
    }

    public static List<List<String>> groupAnagram(String[] strs) {
        if (strs.length == 0) {return new ArrayList<>();}
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            s = s.toLowerCase();
            char[] c = s.toCharArray();
            Arrays.sort(c);

            String theKey = String.valueOf(c);
            if (!map.containsKey(String.valueOf(c))) {
                map.put(theKey, new ArrayList<>());
            }
            map.get(theKey).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramSln1(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        HashMap<Integer, String> arrangementKeyEval = new HashMap<>();
        HashMap<String, Integer> arrangementValEval = new HashMap<>();
        // Get unique words from the array of strings
        for (String str : strs) {
            String singleStr = str.toLowerCase();
            // ASCII is a character encoding that uses numeric codes to representation
            int toAscii = 0;
            for (int i = 0; i < singleStr.length(); i++) {
                toAscii = toAscii + (int) singleStr.charAt(i);
            }
            arrangementKeyEval.put(toAscii, singleStr);
            arrangementValEval.put(singleStr, toAscii);
        }
        System.out.println(arrangementValEval.toString());
        // {323=nat, 311=bat, 314=ate}
        // {tan=323, nat=323, tea=314, ate=314, bat=311, eat=314}

        List<List<String>> groupedList = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : arrangementKeyEval.entrySet()) {
            // match unique values in arrangement with the array of strs
            List<String> gramList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry2 : arrangementValEval.entrySet()) {
                if (Integer.compare(entry.getKey(), entry2.getValue()) == 0) {
                    gramList.add(entry2.getKey());
                }
            }
            groupedList.add(gramList);
        }
        return groupedList;
    }

    private static List groupAnagramSln2(String input[]) {

        HashMap<String, Integer> stringStren = new HashMap<String, Integer>();

        for(int i = 0; i < input.length; i++) {
            String myStrings = input[i].toLowerCase();

            int asciiSum = 0;
            for(int j = 0; j < myStrings.length(); j++) {
                asciiSum = asciiSum + (int) myStrings.charAt(j);
            }
            stringStren.put(input[i], asciiSum);
        }
        System.out.println(stringStren.toString());

        Map<Integer, List<String>> MappingList = new HashMap<Integer, List<String>>();
        Iterator<Map.Entry<String, Integer>> i = stringStren.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, Integer> next = i.next();
            if (MappingList.get(next.getValue()) != null) {
                List<String> anagramString = MappingList.get(next.getValue());
                anagramString.add(next.getKey());
                MappingList.put(next.getValue(), anagramString);
            } else {
                List<String> anagramString = new ArrayList<String>();
                anagramString.add(next.getKey());
                MappingList.put(next.getValue(), anagramString);
            }
        }

        List<List<String>> myList = new ArrayList<List<String>>();
        Iterator<Map.Entry<Integer, List<String>>> listMap = MappingList.entrySet().iterator();
        while (listMap.hasNext()) {
            Map.Entry<Integer, List<String>> nextList = listMap.next();

            myList.add(nextList.getValue());
        }

        return myList;
    }

}
