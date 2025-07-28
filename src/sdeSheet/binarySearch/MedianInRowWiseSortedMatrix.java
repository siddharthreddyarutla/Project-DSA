package sdeSheet.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedianInRowWiseSortedMatrix {

  // https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/

  /**
   * Given a row-wise sorted matrix mat[][] where the number of rows and columns is always odd.
   * Return the median of the matrix.
   * <p>
   * Examples:
   * <p>
   * Input: mat[][] = [[1, 3, 5],
   * [2, 6, 9],
   * [3, 6, 9]]
   * Output: 5
   * Explanation: Sorting matrix elements gives us [1, 2, 3, 3, 5, 6, 6, 9, 9]. Hence, 5 is median.
   */

  public static void main(String[] args) {
    System.out.println(median(new int[][] {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}}));
  }


  /**
   * Time Complexity: O(MXN) + O(MXN(log(MXN))), where M = number of row in the given matrix, N =
   * number of columns in the given matrix
   * <p>
   * Reason: At first, we are traversing the matrix to copy the elements. This takes O(MXN) time
   * complexity. Then we are sorting the linear array of size (MXN), that takes O(MXN(log(MXN)))
   * time complexity
   * <p>
   * Space Complexity: O(MXN) as we are using a temporary list to store the elements of the matrix.
   *
   * @param mat
   *
   * @return
   */
  public static int median(int[][] mat) {
    // code here
    int m = mat.length;
    int n = mat[0].length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        list.add(mat[i][j]);
      }
    }
    Collections.sort(list);
    return list.get((m * n) / 2);
  }
}
