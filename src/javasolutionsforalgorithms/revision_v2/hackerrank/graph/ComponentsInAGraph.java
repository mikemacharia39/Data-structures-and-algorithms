package javasolutionsforalgorithms.revision_v2.hackerrank.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/components-in-graph/problem">...</a>
 *
 * There are 2 * N nodes in an undirected graph, and a number of edges connecting some nodes.
 * In each edge, the first value will be between 1 and N, inclusive.
 * The second node will be between 1+N and 2 * N, inclusive.
 * Given a list of edges, determine the size of the smallest and largest connected components that have 2 or more nodes.
 * A node can have any number of connections. The highest node value will always be connected to at least 1 other node.
 *
 * Note Single nodes should not be considered in the answer.
 *
 * Find the smallest and largest connected components in the graph
 *
 * Example 1:
 * edges: [[1,5],[1,6], [2,4]]
 * answer: [2, 3], because the smallest connected component is 2 and the largest connected component is 3
 *
 */
public class ComponentsInAGraph {

    /**
     * Create class Graph include.
     * Constructor with given V vertices.
     * addEdge: add edge to the graph.
     * V: return the number of vertices in the graph.
     * adj(int v): return the list of adjacent vertices to given v vertex.
     */
    class Graph {
        private final int V;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            adj = (List<Integer>[]) new List[V];
            for (int v = 0; v < V; v++)
                adj[v] = new ArrayList<Integer>();
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        public int V() {
            return V;
        }

        public Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    class ConnectedComponent {
        private boolean marked[];
        private int count = 0;
        //minCC saves the minimum number of vertices in one connected component (minCC > 1)
        private int minCC = Integer.MAX_VALUE;
        //maxCC saves the maximum number of vertices in one connected component (minCC > 1)
        private int maxCC = 1;

        public ConnectedComponent(Graph G) {
            marked = new boolean[G.V()];
            for (int v = 0; v < G.V(); v++) {
                if (!marked[v]) {
                    //initialize the count (count the vertices in one connected component)
                    count = 0;
                    //run dfs
                    dfs(G, v);
                    //get the minimum vertices in CC and maximum vertices in CC
                    if (minCC > count && count > 1) minCC = count;
                    if (maxCC < count) maxCC = count;
                }
            }
        }

        private void dfs(Graph G, int v) {
            marked[v] = true;
            count++;
            for (int w: G.adj(v)) {
                if (!marked[w])
                    dfs(G, w);
            }
        }

        public int getMaxCC() {return maxCC;}
        public int getMinCC() {return minCC;}
    }


    class Result {
        public List<Integer> componentsInGraph(List<List<Integer>> gb) {
            int E = gb.size();

            Graph G = new Graph(2 * E + 1);
            for (int i = 0; i < E; i++) {
                G.addEdge(gb.get(i).get(0), gb.get(i).get(1));
            }

            ConnectedComponent cc = new ConnectedComponent(G);
            List<Integer> result = new ArrayList<>();
            result.add(cc.getMinCC());
            result.add(cc.getMaxCC());
            return result;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> gb = new ArrayList<>();
        gb.add(List.of(1, 5));
        gb.add(List.of(1, 6));
        gb.add(List.of(2, 4));

        ComponentsInAGraph.Result result = new ComponentsInAGraph().new Result();
        System.out.println(result.componentsInGraph(gb));
    }
}
