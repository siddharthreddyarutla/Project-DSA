package sdeSheet.recursionAndBacktracking;

import java.util.Arrays;

public class SudokoSolver {

  // https://takeuforward.org/data-structure/sudoku-solver/

  /**
   * Given a 9x9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has
   * the following properties.
   * <p>
   * 1. All the rows should be filled with numbers(1 - 9) exactly once.
   * <p>
   * 2. All the columns should be filled with numbers(1 - 9) exactly once.
   * <p>
   * 3. Each 3x3 submatrix should be filled with numbers(1 - 9) exactly once.
   * <p>
   * Note: Character '.' indicates empty cell.
   */

  public static void main(String[] args) {
    solveSudoku(new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}});
  }

  /**
   * Time Complexity: O(9^x), in the worst case, as x is the number of empty cell that you
   * can place 9 possible ways
   * <p>
   * Space Complexity: O(1), since we are refilling the given board itself, there is no extra
   * space required, so constant space complexity.
   *
   * @param board
   */
  public static void solveSudoku(char[][] board) {
    solve(board);
    System.out.println(Arrays.deepToString(board));
  }

  public static boolean solve(char[][] board) {
    // Fill all the possibilities of first row
    for (int row = 0; row < board.length; row++) {
      // Then fill all possibilities in the col for each row
      for (int col = 0; col < board[0].length; col++) {
        // If it is only . consider as empty cell
        if (board[row][col] == '.') {
          // Try to fill 1 to 9, try out each occurrence
          for (char c = '1'; c <= '9'; c++) {
            // Check the number before placing whether it is safe to place or not
            if (isSafe(board, row, col, c)) {
              // If it is safe then place it on board
              board[row][col] = c;
              // If the placement of number is safe you return true else if it not possible
              // Further recursion then place . and break that recursion tree and backtrack
              if (solve(board)) {
                return true;
              }
              board[row][col] = '.';
            }
          }
          // false if not able to place any in that col
          return false;
        }
      }
    }
    // true if it reaches end of the row
    return true;
  }

  public static boolean isSafe(char[][] board, int row, int col, char c) {
    // Loop 1 to 9
    for (int i = 0; i < 9; i++) {
      // Check whether row or col has the character to place if yes return false
      if (board[row][i] == c || board[i][col] == c) {
        return false;
      }
    }
    // Checking for the 3x3 grid
    // Try to find the first cell gridRow and gridCol and then go till 3 as you know 9x9 has 3x3
    // of count 3 small grids
    // Eg: (5, 7) first cell is (3,6) -> 5/3=1 * 3 = 3 and 7/3=2 * 3 = 6
    int gridRow = 3 * (row / 3);
    int gridCol = 3 * (col / 3);
    for (int i = gridRow; i < gridRow + 3; i++) {
      for (int j = gridCol; j < gridCol + 3; j++) {
        if (board[i][j] == c) {
          return false;
        }
      }
    }
    return true;
  }
}
