package javasolutionsforalgorithms.leettests.graph;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/submissions/">...</a>
 *
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * Return the total number of provinces.
 *
 *
 *
 * Example 1:
 *                  1
 *               /
 *             2        3
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 *
 * Example 2:
 *                  1
 *
 *             2        3
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int v = isConnected.length;
        boolean[] isVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int[][] isConnected, boolean[] isVisited, int i) {
        isVisited[i] = true;

        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                dfs(isConnected, isVisited, j);
            }
        }
    }
}
