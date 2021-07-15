package leetTests;

/**
 * The Fibonacci series is a series where the next term is the sum of the previous two terms. The first two terms of the Fibonacci sequence are 0 followed by 1.
 *
 * The Fibonacci sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 */
public class AFabonacciQuestion {


    public static void main(String[] args) {
        AFabonacciQuestion fabonacciQuestion = new AFabonacciQuestion();

        // A fabonacci sum for the sequence of 10 numbers
        int n = 10;

        System.out.println("sum is: " + fabonacciQuestion.solution(n));
    }

    /**
     *
     * Recursion
     *
     * So, given a number n, our problem is to find the n-th element of Fibonacci Sequence. To implement a recursive solution, we need to figure out the Stop Condition and the Recursive Call
     *
     * Let's call f(n) the n-th value of the sequence. Then we'll have f(n) = f(n-1) + f(n-2) (the Recursive Call).
     *
     * Meanwhile, f(0) = 0 and f(1) = 1 ( Stop Condition).
     *
     * Then, it's really obvious for us to define a recursive method to solve the problem:
     * @param n
     * @return
     */
    private int solution(int n) {
        if (n <= 1) {
            return 1;
        }

        return solution(n - 1) + solution(n - 2);
    }

    /**
     * Using a loop
     * @param n
     * @return
     */
    private int solutionSln1(int n) {

        int t1 = 0, t2 = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = t1 + t2;

            t1 = t2;
            t2 = sum;

            System.out.print(sum + ",");
        }

        return sum;
    }
}
