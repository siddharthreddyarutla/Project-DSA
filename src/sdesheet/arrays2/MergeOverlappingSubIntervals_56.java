package sdesheet.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals_56 {

  // https://takeuforward.org/data-structure/merge-overlapping-sub-intervals/

  /**
   * Problem Statement: Given an array of intervals, merge all the overlapping intervals and
   * return an array of non-overlapping intervals.
   * Examples
   * Example 1:
   * Input: intervals=[[1,3],[2,6],[8,10],[15,18]]
   * Output: [[1,6],[8,10],[15,18]]
   * Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
   * intervals.
   * <p>
   * Example 2:
   * Input: [[1,4],[4,5]]
   * Output: [[1,5]]
   * Explanation: Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
   */


  public static void main(String[] args) {
    System.out.println(
        (Arrays.deepToString(merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}}))));
    System.out.println(Arrays.deepToString(
        merge(new int[][] {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}})));
    System.out.println(Arrays.deepToString(mergeSimilar(
        new int[][] {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}})));
    System.out.println(Arrays.deepToString(mergeOptimized(
        new int[][] {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}})));
  }

  /**
   * Time Complexity: O(N*logN) + O(2*N), where N = the size of the given array.
   * Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that,
   * we are using 2 loops i and j. But while using loop i, we skip all the intervals that are
   * merged with loop j. So, we can conclude that every interval is roughly visited twice
   * (roughly, once for checking or skipping and once for merging). So, the time complexity will
   * be 2*N instead of N2.
   * <p>
   * Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except
   * for the answer array, we are not using any extra space.
   *
   * @param intervals
   *
   * @return
   */
  public static int[][] merge(int[][] intervals) {

    List<int[]> mergedIntervals = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      for (int j = i + 1; j < intervals.length; j++) {
        if (end > intervals[j][0]) {
          end = Math.max(end, intervals[j][1]);
          i++;
        } else {
          break;
        }
      }
      mergedIntervals.add(new int[] {start, end});
    }
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }

  public static int[][] mergeSimilar(int[][] intervals) {

    List<int[]> mergedIntervals = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      if (!mergedIntervals.isEmpty() && mergedIntervals.get(mergedIntervals.size() - 1)[1] >= end) {
        continue;
      }
      for (int j = i + 1; j < intervals.length; j++) {
        if (end > intervals[j][0]) {
          end = Math.max(end, intervals[j][1]);
        } else {
          break;
        }
      }
      mergedIntervals.add(new int[] {start, end});
    }
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }


  /**
   * Time Complexity: O(N*logN) + O(N), where N = the size of the given array.
   * Reason: Sorting the given array takes  O(N*logN) time complexity. Now, after that, we are
   * just using a single loop that runs for N times. So, the time complexity will be O(N).
   * <p>
   * Space Complexity: O(N), as we are using an answer list to store the merged intervals. Except
   * for the answer array, we are not using any extra space.
   *
   * @param intervals
   *
   * @return
   */
  public static int[][] mergeOptimized(int[][] intervals) {

    List<int[]> mergedIntervals = new ArrayList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int i = 0; i < intervals.length; i++) {
      if (mergedIntervals.isEmpty() || intervals[i][0] > mergedIntervals.get(
          mergedIntervals.size() - 1)[1]) {
        mergedIntervals.add(new int[] {intervals[i][0], intervals[i][1]});
      } else {
        mergedIntervals.get(mergedIntervals.size() - 1)[1] =
            Math.max(mergedIntervals.get(mergedIntervals.size() - 1)[1], intervals[i][1]);
      }
    }
    return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
  }
}
