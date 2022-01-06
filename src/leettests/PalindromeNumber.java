package leettests;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        int x = +121;

        System.out.println(palindromeNumber.solution(x));
    }

    private boolean solution(int x) {
        int sum = 0;
        int value = x;

        while (x > 0) {
            int modulus = x % 10;
            x /=10;
            sum = (sum * 10) + modulus;
        }

        return value == sum;
    }

    private boolean solution2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        System.out.println(sb);
        return sb.toString().equals(Integer.toString(x));
    }

    private boolean solution3(int x) {

        String numToString = Integer.toString(x);
        char[] chars = numToString.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }

        return sb.toString().equals(Integer.toString(x));
    }
}
