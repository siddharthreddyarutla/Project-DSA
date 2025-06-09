package sdeSheet.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rotateMatrixBy90Degree_48 {

  // https://takeuforward.org/data-structure/rotate-image-by-90-degree/

  /**
   * Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
   * Note: Rotate matrix 90 degrees anticlockwise
   * Examples
   * Example 1:
   * Input: [[1,2,3],[4,5,6],[7,8,9]]
   * Output: [[7,4,1],[8,5,2],[9,6,3]]
   * Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.
   * Example 2:
   * Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
   * Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
   * Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix
   *
   * @param args
   */

  public static void main(String[] args) {
    int[][] temp = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] temp1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    System.out.println(Arrays.deepToString(rotateSimilar(temp)));
    System.out.println(rotate(temp1));
    int[][] temp2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotateMatrix90(temp2);
    System.out.println(Arrays.deepToString(temp2));
  }

  /**
   * Time Complexity: O(N*N) to linearly iterate and put it into some other matrix.
   * <p>
   * Space Complexity: O(N*N) to copy it into some other matrix.
   *
   * @param matrix
   *
   * @return
   */
  public static List<List<Long>> rotate(int[][] matrix) {
    List<List<Long>> rotated = new ArrayList<>();
    for (int j = 0; j < matrix[0].length; j++) {
      List<Long> test = new ArrayList<>();
      for (int i = matrix.length - 1; i >= 0; i--) {
        test.add((long) matrix[i][j]);
      }
      rotated.add(test);
    }
    return rotated;
  }

  public static int[][] rotateSimilar(int[][] matrix) {
    int n = matrix.length;
    int[][] rotated = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        rotated[j][n - i - 1] = matrix[i][j];
      }
    }
    return rotated;
  }

  public static void rotateMatrix90(int[][] matrix) {
    // Transpose a matrix first
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = i + 1; j < matrix[0].length; j++) {
        int temp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = temp;
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      int low = 0;
      int high = matrix.length - 1;
      while (low < high) {
        int temp = matrix[i][low];
        matrix[i][low] = matrix[i][high];
        matrix[i][high] = temp;
        low++;
        high--;
      }
    }
  }
}
