package javasolutionsforalgorithms.hackerrank.string;

/**
 * Julius Caesar protected his confidential information by encrypting it using a cipher.
 * Caesar's cipher shifts each letter by a number of letters.
 * If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
 * In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 *
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3:    defghijklmnopqrstuvwxyzabc
 *
 * Sample Input
 *
 * input = middle-Outz
 * shift = 2
 *
 * Output = okffng-Qwvb
 *
 * Explanation
 *
 * Original alphabet:      abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +2:    cdefghijklmnopqrstuvwxyzab
 *
 * m -> o
 * i -> k
 * d -> f
 * d -> f
 * l -> n
 * e -> g
 * -    -
 * O -> Q
 * u -> w
 * t -> v
 * z -> b
 *
 */
public class CeasarCipher {

    public static String caesarCipher(String s, int k) {
        // input = middle-Outz
        // shift = 2
        // okffng-Qwvb

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                int base = Character.isLowerCase(c) ? 'a' : 'A';

                // (encode character + k - base)%26 + base
                // e.g. Z -> (90 + 2 - 65) = 27%26 = 1 + 65 = 66 = b
                int encodeChar = (char)((c + k - base) % 26 + base);

                sb.append((char) encodeChar);
            }
        }
        return sb.toString();
    }
}
