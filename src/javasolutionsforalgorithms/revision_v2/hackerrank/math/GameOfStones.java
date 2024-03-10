package javasolutionsforalgorithms.revision_v2.hackerrank.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Two players called p1 and p2 are playing a game with a starting number of stones.
 * Player p1 always plays first, and the two players move in alternating turns. The game's rules are as follows:
 *
 * In a single move, a player can remove either 2, 3, or 5 stones from the game board.
 * If a player is unable to make a move, that player loses the game.
 * Given the starting number of stones, find and print the name of the winner. p1 is named First and p2 is named Second.
 * Each player plays optimally, meaning they will not make a move that causes them to lose the game if a winning move exists.
 *
 * For example, if n=4, p1 can make the following moves:
 *
 * p1 removes 2 stones leaving 2. P2 will then remove 2 stones and win.
 * p1 removes 3 stones leaving 1. p2 cannot move and loses.
 * p1 would make the second play and win the game.
 *
 * Function Description
 *
 * Complete the gameOfStones function in the editor below. It should return a string, either First or Second.
 *
 * gameOfStones has the following parameter(s):
 *
 * n: an integer that represents the starting number of stones
 *
 * ===========================================
 *
 * Sample Input
 *
 * 1
 * 2
 * 3
 * 4
 * 5
 * 6
 * 7
 * 10
 *
 *
 * Sample Output
 *
 * Second
 * First
 * First
 * First
 * First
 * First
 * Second
 * First
 */
public class GameOfStones {

    /**
     * The logic is to find the remainder of n divided by 7 and if it is 0 or 1
     * then the second player wins otherwise the first player wins
     * @param n number of stones
     * @return
     */
    public static String gameOfStones(int n) {
        return n % 7 <= 1 ? "Second" : "First";
    }

    /**
     * Attempted some other solution, but it is not working
     * @param n
     * @return
     */
    public static String gameOfStones1(int n) {
        if (n <= 1) {
            return "Second";
        }
        List<Integer> ans = new ArrayList<>();
        int player = 0;
        turn(n, player, ans);
        int ansSize = ans.size();
        return ans.get(ansSize - 1) == 0 ? "Second" : "First";
    }
    /**
     * Another solution
     * @param n
     * @return
     */
    private static void turn(int n, int player, List<Integer> ans) {
        int[] maxRemovals = {2,3,5};
        if (n <= 1) {
            return;
        }

        for (int maxRemoval : maxRemovals) {
            if (n - maxRemoval >= 0) {
                int nextPlayer = (1 + player) % 2;
                ans.add(nextPlayer);
                turn(n - maxRemoval, nextPlayer, ans);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "Result: " +GameOfStones.gameOfStones(i));
        }
    }
}
