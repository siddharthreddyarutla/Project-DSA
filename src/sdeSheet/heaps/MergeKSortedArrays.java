package sdeSheet.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

  /**
   * Given k sorted arrays arranged in the form of a matrix of size k * k. The task is to merge
   * them into one sorted array. Return the merged sorted array ( as a pointer to the merged
   * sorted arrays in cpp, as an ArrayList in java, and list in python).
   * <p>
   * Input: k = 3, arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
   * Output: 1 2 3 4 5 6 7 8 9
   * Explanation: Above test case has 3 sorted arrays of size 3, 3, 3 arr[][] = [[1, 2, 3],[4, 5,
   * 6],[7, 8, 9]]. The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
   * Input: k = 4, arr[][]={{1,2,3,4},{2,2,3,4},{5,5,6,6},{7,8,9,9}}
   * Output: 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9
   * Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4 arr[][] = [[1, 2, 2, 2],
   * [3, 3, 4, 4], [5, 5, 6, 6], [7, 8, 9, 9 ]]. The merged list will be [1, 2, 2, 2, 3, 3, 4, 4,
   * 5, 5, 6, 6, 7, 8, 9, 9].
   */


  public static void main(String[] args) {
    System.out.println(mergeKArrays(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3));
    System.out.println(mergeKArraysOptimized(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 3));
  }

  public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
    // Write your code here.
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        result.add(arr[i][j]);
      }
    }
    Collections.sort(result);
    return result;
  }

  /**
   * Time complexity: O(m * n log (k))
   * Space complexity: O(k + n)
   *
   * @param arr
   * @param K
   *
   * @return
   */
  public static ArrayList<Integer> mergeKArraysOptimized(int[][] arr, int K) {
    // Here using int[] instead of any custom class
    // 0 index has value
    // 1 index has row
    // 2 index has col
    /* Since PriorityQueue is a min-heap by default, the array with the smallest a[0] value will
     be at the top. */
    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

    int rows = arr.length;
    int cols = arr[0].length;
    // As it is given sorted k arrays, assuming rows are sorted
    for (int i = 0; i < rows; i++) {
      minHeap.offer(new int[] {arr[i][0], i, 0});
    }

    ArrayList<Integer> result = new ArrayList<>();
    // Looping over each col with respective to col, at max heap will have k max elements
    while (!minHeap.isEmpty()) {
      int[] val = minHeap.poll();
      int row = val[1];
      int col = val[2];
      result.add(val[0]);

      if (col + 1 < cols) {
        minHeap.offer(new int[] {arr[row][col + 1], row, col + 1});
      }
    }
    return result;
  }
}
