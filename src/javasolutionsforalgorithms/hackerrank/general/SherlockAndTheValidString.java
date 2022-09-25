package javasolutionsforalgorithms.hackerrank.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character at 1 index in the string,
 * and the remaining characters will occur the same number of times. Given a string ,
 * determine if it is valid. If so, return YES, otherwise return NO.
 */
public class SherlockAndTheValidString {

    public static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.values());

        Collections.sort(list);

        if (list.size() <= 1) {
            return "YES";
        } else if (list.size() == 2) {
            if (Math.abs(list.get(0) - list.get(1)) > 1) {
                return "NO";
            } else {
                return "YES";
            }
        } else if (list.size() > 2) {
            if (list.get(0) == 1) {
                list.remove(0);
                if (list.size() == 2) {
                    if (Math.abs(list.get(0) - list.get(1)) >= 1) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                } else {
                    int diff3 = Math.abs(list.get(0) - list.get(list.size()-1));
                    int diff4 = Math.abs(list.get(0) - list.get(list.size()-2));
                    if ((diff3 >= 1) || ((diff3 + diff4) >= 1)) {
                        return "NO";
                    } else {
                        return "YES";
                    }
                }
            } else {
                int diff1 = Math.abs(list.get(0) - list.get(list.size()-1));
                int diff2 = Math.abs(list.get(0) - list.get(list.size()-2));
                if ((diff1 > 1) || ((diff1 + diff2) > 1)) {
                    return "NO";
                } else {
                    System.out.println("HERE 1");
                    return "YES";
                }
            }
        } else {
            System.out.println("HERE 2");
            return "YES";
        }
    }
}
