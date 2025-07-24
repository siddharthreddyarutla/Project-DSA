package sdeSheet.recursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

  // https://takeuforward.org/data-structure/n-queen-problem-return-all-distinct-solutions-to-the-n-queens-puzzle/

  /**
   * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no
   * two queens attack each other.
   * <p>
   * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the
   * answer in any order.
   * <p>
   * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q'
   * and '.' both indicate a queen and an empty space, respectively.
   * <p>
   * Input: n = 4
   * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
   * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
   */

  public static void main(String[] args) {
    System.out.println(solveNQueens(4));
  }

  /**
   * Time Complexity: Exponential in nature since we are trying out all ways, to be precise its O
   * (N! * N).
   * <p>
   * Space Complexity: O( N2 )
   *
   * @param n
   *
   * @return
   */
  public static List<List<String>> solveNQueens(int n) {
    // Building board
    char[][] board = buildBoard(n);
    List<List<String>> distinctSolutions = new ArrayList<>();
    nQueen(board, n, 0, distinctSolutions);
    return distinctSolutions;
  }

  public static void nQueen(char[][] board, int n, int col, List<List<String>> distinctSolutions) {
    // Base condition
    if (col == n) {
      distinctSolutions.add(construct(board));
      return;
    }
    for (int row = 0; row < n; row++) {
      if (isValid(board, row, col, n)) {
        board[row][col] = 'Q';
        nQueen(board, n, col + 1, distinctSolutions);
        board[row][col] = '.';
      }
    }
  }

  public static boolean isValid(char[][] board, int row, int col, int n) {
    int rowCopy = row;
    int colCopy = col;

    // Top left diagonal
    while (row >= 0 && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      row--;
      col--;
    }
    // Retain values
    row = rowCopy;
    col = colCopy;
    // left most
    while (col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      col--;
    }
    // Retain
    col = colCopy;
    while (row < n && col >= 0) {
      if (board[row][col] == 'Q') {
        return false;
      }
      col--;
      row++;
    }
    return true;
  }

  public static List<String> construct(char[][] board) {
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      String s = new String(board[i]);
      ans.add(s);
    }
    return ans;
  }

  public static char[][] buildBoard(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = '.';
      }
    }
    return board;
  }
}
