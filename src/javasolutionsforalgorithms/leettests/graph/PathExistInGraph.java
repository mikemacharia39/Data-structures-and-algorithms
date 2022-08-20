package javasolutionsforalgorithms.leettests.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive).
 * The edges in the graph are represented as a 2D integer array edges,
 * where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi.
 * Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 *
 * Given edges and the integers n, start, and end, return true if there is a valid path from start to end,
 * or false otherwise.
 *
 *
 * Example 1:
 *     0 ------ 1
 *      \      /
 *       \    /
 *        \  /
 *         2
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 *
 *
 * Example 2:
 *
 *       0 ------ 1      3 ------ 4
 *        \               \      /
 *         \               \    /
 *          \               \  /
 *           2               5
 *
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 *
 */
public class PathExistInGraph {

    /**
     * This is a BFS solution - This is a search algorithm used in trees and graphs.
     * It starts the root node and explores all nodes at the current depth before proceeding the next depth level
     * @param n number of vertices
     * @param edges 2D representation of edges
     * @param start start
     * @param end end
     * @return true|false
     */
    public boolean validPath(int n, int[][] edges, int start, int end) {

        // That mean you only have a single vertex with no edges
        if (start == end) {
            return true;
        }

        // initialize the arraylist by creating space of size n for the pair of edges
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // add the pair of edges into the array list
        // edges[0][0] = 0
        // edges[0][1] = 1
        // edges[1][0] = 0
        // edges[1][1] = 2
        // edges[2][0] = 2
        // edges[2][1] = 0
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        System.out.println("Graph: " + graph);

        // to not repeat visited vertex
        HashSet<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            visited.add(curr);

            System.out.println("neighbour: " + curr + " | end: " + end);

            if (curr == end) {
                return true;
            }

            // curr represents the vertex we are in currently
            // curr is a vertex containing 2 edges
            // the vertex are/might be connected to other vertices
            // essentially getting a vertex in a bi-directional connected graph results in two adjacent vertices
            // i.e. graph.get(curr).get(0) returns both vertex 1 and vertex 2
            // then we loop through the 2 vertices getting their adjacent vertices
            // and adding them to the queue.
            // if vertex = end then the graph is connected
            for (int i = 0; i < graph.get(curr).size(); i++) {
                int neighbor = graph.get(curr).get(i);
                System.out.println("n: " + neighbor + " | graph.get(curr): " + graph.get(curr));
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }

        }
        System.out.println("Visited HashSet: " + visited);
        return false;
    }

    public static void main(String[] args) {
        PathExistInGraph pathExistInGraph = new PathExistInGraph();

        int numberOfEdges = 3;
        int[][] edges = {{0,1},{1,2},{2,0}};
        int start = 0;
        int end = 2;

        boolean isPathExist = pathExistInGraph.validPath(numberOfEdges, edges, start, end);

        System.out.println("Is Path Exist: " + isPathExist);
    }
}
