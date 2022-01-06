package leettests.arrayandstrings;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * Example:
 * Code = false, no permutation can create a palindrome
 * aab = true, since aba is palindrome
 * carerca = true, since craearc is palindrome
 */
public class IfPermutationCanFormPalindrome {


    public static void main(String[] args) {
        IfPermutationCanFormPalindrome isPalindrome = new IfPermutationCanFormPalindrome();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string: ");
        String s = scanner.nextLine();
        System.out.println("Is string palindrome: " + isPalindrome.solution(s));

        while (!s.equals("stop")) {
            System.out.println("Enter another string: ");
            s = scanner.nextLine();
            System.out.println("Is string palindrome: " + isPalindrome.solution(s));
        }
    }

    /**
     * attributes of palindrome:
     * - values exist in pairs.
     * - If string value is of odd length, only one value has no pair
     *
     * @return true|false
     */
    private boolean solution(String str) {

        if (str == null || str.length() == 0) {
            return false;
        }

        HashSet<Character> set = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        return set.size() == 0 || set.size() == 1;
    }
}
