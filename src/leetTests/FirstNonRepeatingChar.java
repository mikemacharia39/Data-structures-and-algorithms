package leetTests;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The purpose of this code is to find the index of the first non repeating character in a string
 * for example Hello = 0, because H is the first non repeating character
 * for example google = 4, because l is the first non-repeating character
 */
public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter String: ");
        String myString = input.nextLine();

        int index = FirstNonRepeatingChar.firstNonRepeatingCharIndex(myString);

        System.out.println("Answer: " + index);
    }

    private static int firstNonRepeatingCharIndex(String theWord) {
        for (int i = 0; i < theWord.length(); i++) {
            if (theWord.indexOf(theWord.charAt(i)) == theWord.lastIndexOf(theWord.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    private static int firstNonRepeatingCharIndexSln1(String theWord) {

        if(theWord.length() == 0) {
            return -1;
        }

        theWord = theWord.toLowerCase();

        HashMap<Object, Integer> charMap = new HashMap<Object, Integer>();

        for(int i = 0; i < theWord.length(); i++) {
            charMap.put(theWord.charAt(i), charMap.getOrDefault(theWord.charAt(i),0)+1);
        }

        System.out.println("The characters in map: " + charMap.toString());

        for(int i = 0; i < theWord.length(); i++) {
            if(charMap.containsKey(theWord.charAt(i))) {
                if(charMap.get(theWord.charAt(i)) == 1) {
                    return i;
                }
            }
        }


        return -1;
    }
}
