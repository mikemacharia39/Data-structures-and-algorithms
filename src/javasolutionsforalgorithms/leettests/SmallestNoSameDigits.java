package javasolutionsforalgorithms.leettests;

public class SmallestNoSameDigits {


    public static void main(String[] args) {
        SmallestNoSameDigits noSameDigits = new SmallestNoSameDigits();

        int N = 92938;

        System.out.println(noSameDigits.solution3(N));
    }

    private int solution(int N) {
        int lengthOfDigit = String.valueOf(N).length();

        if(lengthOfDigit <= 1) {
            return 0;
        }

        for (int i = N; i > 0; i--) {
            if (String.valueOf(i).length() == (lengthOfDigit-1)) {
                i++;
                return i;
            }
        }

        return 0;
    }

    //-------------------------------------

    private int solution3(int N) {
        int lengthOfDigit = String.valueOf(N).length();

        if(lengthOfDigit <= 1) {
            return 0;
        }

        if (lengthOfDigit > 1) {
            int smallestValueInDigitLength = (int) Math.pow(10, lengthOfDigit-1);

            return smallestValueInDigitLength;
        }

        return 0;
    }

}
