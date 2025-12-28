package javasolutionsforalgorithms.leettests.arrayandstrings;

import java.util.HashSet;

/**
 * Given a string containing numbers and operators (+, -)
 * find the sum of elements in the string
 */
public class AddingElementsInString {

    public static void main(String[] args) {

        String string = "+3 ++5 -9 +6 +2";

        AddingElementsInString addingElementsInString = new AddingElementsInString();

        System.out.println("Sum of strings: " + addingElementsInString.solution(string));
    }

    private int solution(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        str = str.replaceAll("\\s*", ""); // Sanitize string
        System.out.println("Sanitized: " + str);

        int sum = 0;
        char currentSign = '+';
        StringBuilder number = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '+' || c == '-') {
                if (!number.isEmpty()) {
                    sum += currentSign == '+' ? Integer.parseInt(number.toString()) : -Integer.parseInt(number.toString());
                    number.setLength(0); // Clear the number buffer
                }
                currentSign = c;
            } else {
                number.append(c);
            }
        }

        // Add the last number
        if (!number.isEmpty()) {
            sum += currentSign == '+' ? Integer.parseInt(number.toString()) : -Integer.parseInt(number.toString());
        }

        return sum;
    }

    private int solution1(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        //Sanitize string
        str = str.replaceAll("\\s*", "");

        System.out.println("Sanitized: " + str);

        int sum = 0;
        char currentSign = '+';
        HashSet<Character> operator = new HashSet<>();
        operator.add('+');
        operator.add('-');

        for (char c : str.toCharArray()) {
            if (operator.contains(c)) {
                currentSign = c;
            } else if (!operator.contains(c)) {
                switch (currentSign) {
                    case '+':
                        sum = sum + Integer.parseInt(String.valueOf(c));
                        break;
                    case '-':
                        sum = sum - Integer.parseInt(String.valueOf(c));
                        break;
                    default:
                        break;
                }
            }
        }

        return sum;
    }
}
