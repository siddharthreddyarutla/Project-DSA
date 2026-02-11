package neetCode_150.arrays;

import java.util.HashSet;

public class validSudoko {

  public static void main(String[] args) {


  }

  public boolean isValidSudoku(char[][] board) {

    for (int i = 0; i < board.length; i++) {
      if (!validateRow(i, board)) {
        return false;
      }
    }

    for (int i = 0; i < board.length; i++) {
      if (!validateCol(i, board)) {
        return false;
      }
    }

    for (int i = 0; i < board.length; i += 3) {
      for (int j = 0; j < board.length; j += 3) {
        if (!validate3x3(i, j, board)) {
          return false;
        }
      }
    }

    return true;

  }

  public boolean validateRow(int row, char[][] board) {
    HashSet<Character> set = new HashSet<>();
    for (int col = 0; col < 9; col++) {
      if (board[row][col] == '.') {
        continue;
      }
      if (set.contains(board[row][col])) {
        return false;
      } else {
        set.add(board[row][col]);
      }
    }
    return true;
  }


  public boolean validateCol(int col, char[][] board) {
    HashSet<Character> set = new HashSet<>();
    for (int row = 0; row < 9; row++) {
      if (board[row][col] == '.') {
        continue;
      }
      if (set.contains(board[row][col])) {
        return false;
      } else {
        set.add(board[row][col]);
      }
    }
    return true;
  }

  public boolean validate3x3(int row, int col, char[][] board) {
    HashSet<Character> set = new HashSet<>();
    for (int i = row; i < row + 3; i++) {
      for (int j = col; j < col + 3; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (set.contains(board[i][j])) {
          return false;
        } else {
          set.add(board[i][j]);
        }
      }
    }
    return true;
  }
}
