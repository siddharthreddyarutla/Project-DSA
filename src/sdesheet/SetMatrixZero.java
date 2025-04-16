package sdesheet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetMatrixZero {

  // https://takeuforward.org/data-structure/set-matrix-zero/

  /**
   * Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
   * <p>
   * You must do it in place.
   * <p>
   * Examples 1:
   * <p>
   * Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
   * <p>
   * Output: [[1,0,1],[0,0,0],[1,0,1]]
   * <p>
   * Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
   * <p>
   * Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
   * <p>
   * Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
   * <p>
   * Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th
   * column will be set to 0
   */


  public static void main(String[] args) {
    int[][] matrix = {
        {1, 1, 1},
        {1, 0, 1},
        {1, 1, 1}
    };
    int[][] matrix1 = {
        {0, 1, 2, 0},
        {3, 4, 5, 2},
        {1, 3, 1, 5}
    };
    setZeros(matrix1);
    System.out.println();
    setZerosBetter(matrix);
    System.out.println();
    test(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 22));
  }

  /**
   * T.C = O(n^2)
   * S.C = O(n+m)
   *
   * @param matrix
   */
  public static void setZeros(int[][] matrix) {
    Set<Integer> rowsContaining0 = new HashSet<>();
    Set<Integer> columnsContaining0 = new HashSet<>();

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rowsContaining0.add(i);
          columnsContaining0.add(j);
        }
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (rowsContaining0.contains(i) || columnsContaining0.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
    System.out.print(Arrays.deepToString(matrix));
  }

  /**
   * Can be optimized with space
   * @param matrix
   */
  public static void setZerosBetter(int[][] matrix) {
    int extraCol = 1;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          if (j != 0) {
            matrix[0][j] = 0;
          } else {
            extraCol = 0;
          }
        }
      }
    }
    for (int i = 1; i < matrix.length; i++) {
      for (int j = 1; j < matrix[0].length; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (matrix[0][0] == 0) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[0][j] = 0;
      }
    }
    if (extraCol == 0) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][0] = 0;
      }
    }
    System.out.print(Arrays.deepToString(matrix));
  }

  public static void test(List<Integer> test) {
    System.out.print(test.stream().max(Integer::compareTo));
  }}
