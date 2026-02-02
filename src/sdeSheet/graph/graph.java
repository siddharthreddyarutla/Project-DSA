package sdeSheet.graph;

import java.util.ArrayList;
import java.util.List;

public class graph {

  public static void main(String[] args) {
    UnDirectionalGraph unDirectionalGraph = new UnDirectionalGraph(5);

    unDirectionalGraph.addEdge(0, 1);
    unDirectionalGraph.addEdge(1, 2);
    unDirectionalGraph.addEdge(1, 3);
    unDirectionalGraph.addEdge(2, 3);
    unDirectionalGraph.addEdge(2, 4);

    unDirectionalGraph.print();
  }

  public static class UnDirectionalGraph {

    int V;
    List<List<Integer>> vertexEdgesList;

    public UnDirectionalGraph(int v) {
      this.V = v;
      this.vertexEdgesList = new ArrayList<>(v);
      for (int i = 0; i < V; i++) {
        vertexEdgesList.add(new ArrayList<>());
      }

    }

    public void addEdge(int u, int v) {
      vertexEdgesList.get(u).add(v);
      vertexEdgesList.get(v).add(u);

    }

    public void print() {
      for (int i = 0; i < V; i++) {
        System.out.println(i + " -> " + vertexEdgesList.get(i));
      }
    }
  }
}
