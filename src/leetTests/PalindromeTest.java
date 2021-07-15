package leetTests;

public class PalindromeTest {

    public static void main(String[] args) {
        PalindromeTest pt = new PalindromeTest();

        String s = "A man, a plan, a canal: Panama";
        //String s = "A mike";

        boolean isPalindrome = pt.isPalindrome(s);

        System.out.println("isPalindrome: " + isPalindrome);
    }

    /**
     * BEST SLN
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        String sanitizedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int lengthStr = sanitizedString.length();
        int j = lengthStr-1;
        for (int i = 0; i < lengthStr/2; i++) {
            if (sanitizedString.charAt(i) != sanitizedString.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    public boolean isPalindromeSln3(String s) {
        String sanitiedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversedString = new StringBuffer(sanitiedString).reverse().toString();
        return sanitiedString.equals(reversedString);
    }

    public boolean isPalindromeSln1(String s) {
        String sanitiedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(sanitiedString);
        return sb.toString().equals(sb.reverse().toString());
    }

    public boolean isPalindromeSln2(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println("Only letters: " + s);

        char[] sToChar = s.toCharArray();
        char[] oppToChar = new char[sToChar.length];
        String palindrome = "";

        int sizeOfSToChar = sToChar.length;
        while (sizeOfSToChar > 0) {
            sizeOfSToChar--;

            oppToChar[sizeOfSToChar] = sToChar[sizeOfSToChar];

            palindrome = palindrome + oppToChar[sizeOfSToChar]+"";
        }

        System.out.println("Palindrome: " + palindrome);

        return s.equals(palindrome);
    }
}
