package leettests.arrayandstrings;

public class FabonacciPrinciples {

    public static void main(String[] args) {

        FabonacciPrinciples fabonacciPrinciples = new FabonacciPrinciples();

        int n = 10;

        System.out.println("Sum is: " + fabonacciPrinciples.solution(n));
    }

    private int solution(int n) {
        if (n <= 1) {
            return 1;
        }

        return solution(n - 1) + solution(n - 2);
    }

    /**
     * using iteration
     * @param n number of values
     * @return fabonacci seq
     */
    private int solution2(int n) {

        if (n <= 1) {
            return 1;
        }

        int sum = 0;
        int num1 = 0;
        int num2 = 1;

        for (int i = 1; i <= n; i++) {

            sum = num1 + num2;

            num1 = num2;

            num2 = sum;

            System.out.print(sum + " ");
        }

        return sum;
    }
}
