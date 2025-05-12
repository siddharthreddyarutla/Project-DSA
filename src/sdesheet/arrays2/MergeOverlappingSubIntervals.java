package sdesheet.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubIntervals {

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
    System.out.println((merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
  }

  public static List<List<Integer>> merge(int[][] intervals) {

    int[][] mergedIntervals = new int[intervals.length][];
    for (int i = 0; i < intervals.length - 1; i++) {
      List<Integer> merge = new ArrayList<>();
      if (intervals[i][1] > intervals[i + 1][0]) {
        merge.add(intervals[i][0]);
        merge.add(intervals[i + 1][1]);
        i++;
      } else {
        merge.add(intervals[i][0]);
        merge.add(intervals[i][1]);
      }
      mergedIntervals.add(merge);
    }
    return mergedIntervals;
  }
}
