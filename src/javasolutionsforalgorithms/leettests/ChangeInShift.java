package javasolutionsforalgorithms.leettests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ChangeInShift {

    public static void main(String[] args) {

//        String s = "abc";
//        List<List<Integer>> shifts = asList(
//                asList(0, 1),
//                asList(0, 1),
//                asList(1, 2));

        String s = "abcdefg";
        List<List<Integer>> shifts = asList(
                asList(1, 1),
                asList(1, 1),
                asList(0, 2), asList(1, 3));

        System.out.println(shifts.toString());

        ChangeInShift changeInShift = new ChangeInShift();

        String newS = changeInShift.changeInShifts(s, shifts);

        System.out.println("my new s: " + newS);
    }

    private String changeInShifts(String s, List<List<Integer>> shifts) {

        if(s.length() <1 || s.length() > 100) {
            return s;
        }

        Map<Integer, Integer> mapShifts = new HashMap<Integer, Integer>();

        if(shifts.size() < 1 || shifts.size() > 100){
            return s;
        }

        for(List aShift:shifts) {
            if ((Integer) aShift.get(0) == 0) {
                mapShifts.put(0, mapShifts.getOrDefault(aShift.get(0), 0)+(Integer) aShift.get(1));
            } else if ((Integer) aShift.get(0) == 1) {
                mapShifts.put(1, mapShifts.getOrDefault(aShift.get(0), 0)+(Integer) aShift.get(1));
            }
        }

        int shiftValue = mapShifts.get(0) - mapShifts.get(1);



        int shiftDirection = 1;

        if(shiftValue != 0) {
            shiftDirection = shiftValue / Math.abs(shiftValue);
        }

        for (int i = 0; i < Math.abs(shiftValue); i++) {
            if(shiftDirection == 1) {
                s = s.substring(1, s.length()) + s.charAt(0);
            }

            if(shiftDirection == -1) {
                s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
            }
        }

        return s;
    }
}
