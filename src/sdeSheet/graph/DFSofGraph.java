package sdeSheet.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSofGraph {

  public static void main(String[] args) {

    graph.UnDirectionalGraph unDirectionalGraph = new graph.UnDirectionalGraph(5);

    unDirectionalGraph.addEdge(0, 1);
    unDirectionalGraph.addEdge(1, 2);
    unDirectionalGraph.addEdge(1, 3);
    unDirectionalGraph.addEdge(2, 4);

    List<List<Integer>> adj = unDirectionalGraph.vertexEdgesList;
    List<Integer> res = new ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    visited[0] = true;
    dfsHelper(0, visited, adj, res);
    System.out.println(res);
  }


  /**
   * Time Complexity (TC):
   * O(V + E)
   * Space Complexity (SC):
   * O(V)
   * (due to recursion stack or explicit stack + visited array)
   *
   * @param u
   * @param visited
   * @param adj
   * @param res
   */
  public static void dfsHelper(Integer u, boolean[] visited, List<List<Integer>> adj,
      List<Integer> res) {

    res.add(u);

    for (Integer v : adj.get(u)) {
      if (!visited[v]) {
        visited[v] = true;
        dfsHelper(v, visited, adj, res);
      }
    }
  }
}
