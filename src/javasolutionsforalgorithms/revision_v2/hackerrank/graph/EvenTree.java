package javasolutionsforalgorithms.revision_v2.hackerrank.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a tree (a simple connected graph with no cycles).
 *
 * Find the maximum number of edges you can remove from the tree to get a forest such that each connected component of the forest contains an even number of nodes.
 *
 * As an example, the following tree with 4 nodes can be cut at most 1 time to create an even forest.
 *
 *           1
 *         / \
 *        3   2
 *       /
 *      4
 *
 * This tree can be cut at most 1 time to create an even forest.
 *
 *        1
 *         \
 *          2
 * This is an even forest because the two connected components have 2 nodes each.
 *
 */
public class EvenTree {

    static int answer;

    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= t_nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < t_edges; i++) {
            int source = t_from.get(i);
            int destination = t_to.get(i);
            graph.get(destination).add(source);
        }

        answer = 0;

        dfs(1, graph);

        return answer;
    }

    static int dfs(int source, List<List<Integer>> graph) {
        int child = 1;

        if (graph.get(source).isEmpty()) {
            return 1;
        }

        for (int i = 0; i < graph.get(source).size(); i++) {
            child += dfs(graph.get(source).get(i), graph);
        }

        if (child % 2 == 0 && source != 1) {
            answer++;
            return 0;
        }

        return child;
    }

    public static void main(String[] args) {
        List<Integer> t_from = new ArrayList<>();
        List<Integer> t_to = new ArrayList<>();
        t_from.add(2);
        t_to.add(1);
        t_from.add(3);
        t_to.add(1);
        t_from.add(4);
        t_to.add(3);
        t_from.add(5);
        t_to.add(2);
        t_from.add(6);
        t_to.add(1);

        System.out.println(evenForest(6, 5, t_from, t_to)); // 2 because we can remove 2 edges to get an even forest
    }
}
