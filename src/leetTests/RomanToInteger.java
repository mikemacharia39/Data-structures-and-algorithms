package leetTests;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {

        String s = "IX";
        //Output: 9;

        //String s = "LVIII";
        //Output: 58;

        //String s = "MCMXCIV";
        //Output: 1994;

        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt(s));
    }

    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int initValue = map.get(s.charAt(i));
            if (i + 1 < s.length()) {
                int nextVal = map.get(s.charAt(i+1));
                if (initValue >= nextVal) {
                    sum = sum + initValue;
                } else {
                    sum = sum + map.get(s.charAt(i+1)) - initValue;
                    i++;
                }
            } else {
                sum = sum + map.get(s.charAt(i));
            }

        }

        return sum;
    }

}
