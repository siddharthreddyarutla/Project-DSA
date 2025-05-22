package sdesheet.arrays3;

public class uniquePaths_62 {

  // https://takeuforward.org/data-structure/grid-unique-paths-count-paths-from-left-top-to-the-right-bottom-of-a-matrix/

  /**
   * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i
   * .e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n -
   * 1]). The robot can only move either down or right at any point in time.
   * <p>
   * Given the two integers m and n, return the number of possible unique paths that the robot
   * can take to reach the bottom-right corner.
   * <p>
   * Input: m = 3, n = 2
   * Output: 3
   * Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right
   * corner:
   * 1. Right -> Down -> Down
   * 2. Down -> Down -> Right
   * 3. Down -> Right -> Down
   * <p>
   * Input:
   * A = 2, B = 2
   * Output: 2
   * Explanation: There are only two unique
   * paths to reach the end of the matrix of
   * size two from the starting cell of the
   * matrix.
   * Example 2:
   * <p>
   * Input:
   * A = 3, B = 4
   * Output: 10
   * Explanation: There are only 10 unique
   * paths to reach the end of the matrix of
   * size two from the starting cell of the
   * matrix.
   */

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 7));
    System.out.println(uniquePaths(3, 2, new int[3][2]));
    System.out.println(findUniqPaths(3, 7));
  }

  public static int uniquePaths(int m, int n) {
    return findUniqPaths(0, 0, m, n);
  }

  public static int uniquePaths(int m, int n, int[][] dp) {
    return findUniqPaths(0, 0, m, n, dp);
  }

  /**
   * T.C = O(n!)
   * S.C = O(n!)
   *
   * @param i
   * @param j
   * @param m
   * @param n
   *
   * @return
   */
  public static int findUniqPaths(int i, int j, int m, int n) {
    if (i > m - 1 || j > n - 1) {
      return 0;
    }
    if (i == m - 1 && j == n - 1) {
      return 1;
    }
    return findUniqPaths(i + 1, j, m, n) + findUniqPaths(i, j + 1, m, n);
  }


  /**
   * DP solution
   * T.C = O(M*N)
   * S.C = O(M*N)
   *
   * @param i
   * @param j
   * @param m
   * @param n
   * @param dp
   *
   * @return
   */
  public static int findUniqPaths(int i, int j, int m, int n, int[][] dp) {
    if (i > m - 1 || j > n - 1) {
      return 0;
    }
    if (i == m - 1 && j == n - 1) {
      return 1;
    }
    if (dp[i][j] != 0) {
      return dp[i][j];
    } else {
      return dp[i][j] = findUniqPaths(i + 1, j, m, n, dp) + findUniqPaths(i, j + 1, m, n, dp);
    }
  }

  public static int findUniqPaths(int m, int n) {
    int b = m + n - 2;
    int r = m - 1;
    int res = 1;
    for (int i=0; i<r; i++) {
      res *= (b-i);
      res /= (i+1);
    }
    return res;
  }
}
