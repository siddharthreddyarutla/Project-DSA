package sdeSheet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSofGraph {

  public static void main(String[] args) {
    graph.UnDirectionalGraph unDirectionalGraph = new graph.UnDirectionalGraph(5);

    unDirectionalGraph.addEdge(0, 1);
    unDirectionalGraph.addEdge(1, 2);
    unDirectionalGraph.addEdge(1, 3);
    unDirectionalGraph.addEdge(2, 3);
    unDirectionalGraph.addEdge(2, 4);

    System.out.println(BFS(unDirectionalGraph.vertexEdgesList));
  }

  /**
   * Because BFS = level-by-level traversal
   * And a queue enforces FIFO (First In, First Out), which is exactly what we need.
   * <p>
   * Queue ensures that nodes discovered earlier are explored earlier, preserving BFS levels.
   *
   * @param adj Time Complexity (TC):
   *            O(V + E)
   *            Each vertex is visited once and each edge is processed once.
   *            Space Complexity (SC):
   *            O(V)
   *
   * @return
   */
  public static List<Integer> BFS(List<List<Integer>> adj) {

    // code here
    List<Integer> ans = new ArrayList<>(adj.size());

    Queue<Integer> queue = new LinkedList<>();

    boolean[] visited = new boolean[adj.size()];

    queue.offer(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
      Integer u = queue.poll();

      ans.add(u);

      for (Integer v : adj.get(u)) {
        if (!visited[v]) {
          visited[v] = true;
          queue.offer(v);
        }
      }
    }
    return ans;
  }

}
