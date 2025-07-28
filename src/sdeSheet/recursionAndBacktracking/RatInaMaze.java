package sdeSheet.recursionAndBacktracking;

import java.util.ArrayList;

public class RatInaMaze {

  // https://takeuforward.org/data-structure/rat-in-a-maze/

  /**
   * Consider a rat placed at position (0, 0) in an n x n square matrix mat[][]. The rat's goal
   * is to reach the destination at position (n-1, n-1). The rat can move in four possible
   * directions: 'U'(up), 'D'(down), 'L' (left), 'R' (right).
   * <p>
   * The matrix contains only two possible values:
   * <p>
   * 0: A blocked cell through which the rat cannot travel.
   * 1: A free cell that the rat can pass through.
   * Your task is to find all possible paths the rat can take to reach the destination, starting
   * from (0, 0) and ending at (n-1, n-1), under the condition that the rat cannot revisit any
   * cell along the same path. Furthermore, the rat can only move to adjacent cells that are
   * within the bounds of the matrix and not blocked.
   * If no path exists, return an empty list.
   */


  public static void main(String[] args) {
    System.out.println(
        ratInMaze(new int[][] {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}));
  }

  /**
   * Time Complexity: O(4^(m*n)), because on every cell we need to try 4 different directions.
   * <p>
   * Space Complexity:  O(m*n), Maximum Depth of the recursion tree(auxiliary space).
   *
   * @param maze
   *
   * @return
   */
  public static ArrayList<String> ratInMaze(int[][] maze) {
    // code here
    ArrayList<String> directions = new ArrayList<>();
    int[][] visited = new int[maze.length][maze[0].length];
    findPath(0, 0, maze, visited, new ArrayList<>(), directions);
    return directions;
  }

  public static void findPath(int row, int col, int[][] maze, int[][] visited,
      ArrayList<Character> paths, ArrayList<String> directions) {
    if (row < 0 || col < 0 || row > maze.length - 1 || col > maze[0].length - 1
        || visited[row][col] == 1 || maze[row][col] == 0) {
      return;
    }
    if (row == maze.length - 1 && col == maze[0].length - 1) {
      StringBuilder sb = new StringBuilder();
      for (Character s : paths) {
        sb.append(s);
      }
      directions.add(sb.toString());
      return;
    }
    visited[row][col] = 1;
    // Down
    paths.add('D');
    findPath(row + 1, col, maze, visited, paths, directions);
    paths.remove(paths.size() - 1);

    // up
    paths.add('U');
    findPath(row - 1, col, maze, visited, paths, directions);
    paths.remove(paths.size() - 1);

    // Right
    paths.add('R');
    findPath(row, col + 1, maze, visited, paths, directions);
    paths.remove(paths.size() - 1);

    // Left
    paths.add('L');
    findPath(row, col - 1, maze, visited, paths, directions);
    paths.remove(paths.size() - 1);

    visited[row][col] = 0;
  }
}
