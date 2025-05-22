package sdesheet.arrays3;

import java.util.Arrays;

public class searchIn2DMatrix_74 {

  // https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/

  /**
   * You are given an m x n integer matrix matrix with the following two properties:
   * <p>
   * Each row is sorted in non-decreasing order.
   * The first integer of each row is greater than the last integer of the previous row.
   * Given an integer target, return true if target is in matrix or false otherwise.
   * <p>
   * You must write a solution in O(log(m * n)) time complexity.
   * Example 1:
   * <p>
   * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
   * Output: true
   */

  public static void main(String[] args) {
    int[][] matrix = new int[][] {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    System.out.println(searchMatrix(matrix, 3));
    System.out.println(searchMatrixBetter(matrix, 60));
    System.out.println(searchMatrixOptimal(matrix, 10));
  }

  /**
   * Time Complexity: O(N X M), where N = given row number, M = given column number.
   * Reason: In order to traverse the matrix, we are using nested loops running for n and m times
   * respectively.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param matrix
   * @param target
   *
   * @return
   */
  public static boolean searchMatrix(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == target) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * T.C = O(n)
   * S.C = O(n)
   *
   * @param matrix
   * @param target
   *
   * @return
   */
  public static boolean searchMatrixBetter(int[][] matrix, int target) {
    int[] temp = Arrays.stream(matrix).flatMapToInt(Arrays::stream).toArray();
    int pointer = temp.length / 2;
    while (pointer > 0 && pointer < temp.length) {
      if (temp[pointer] == target) {
        return true;
      } else if (temp[pointer] > target) {
        pointer--;
      } else {
        pointer++;
      }
    }
    return false;
  }

  /**
   * T.C = O (m+n)
   * S.C = O(1)
   *
   * @param matrix
   * @param target
   *
   * @return
   */
  public static boolean searchMatrixOptimal(int[][] matrix, int target) {
    boolean found = false;
    found = findTarget(matrix, target, 0, matrix[0].length - 1);
    return found;
  }

  public static boolean findTarget(int[][] matrix, int target, int i, int j) {
    if (i >= matrix.length) {
      return false;
    }
    if (matrix[i][j] == target) {
      return true;
    }
    if (matrix[i][j] > target) {
      while (j >= 0) {
        if (matrix[i][j] == target) {
          return true;
        }
        j--;
      }
    }
    i++;
    return findTarget(matrix, target, i, j);
  }

  /**
   * Time Complexity: 𝑂(𝑚+𝑛)
   * Space Complexity: O(1) (Iterative approach, no recursion stack)
   *
   * @param matrix
   * @param target
   *
   * @return
   */
  public static boolean searchMatrixOptimized(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int i = 0, j = cols - 1;

    while (i < rows && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return false;
  }
}
