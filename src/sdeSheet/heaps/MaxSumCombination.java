package sdeSheet.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSumCombination {

  /**
   * You are given two integer arrays a[] and b[] of equal size. A sum combination is formed by
   * adding one element from a[] and one from b[], using each index pair (i, j) at most once.
   * Return the top k maximum sum combinations, sorted in non-increasing order.
   * <p>
   * Examples:
   * <p>
   * Input: a[] = [3, 2], b[] = [1, 4], k = 2
   * Output: [7, 6]
   * Explanation: Possible sums: 3 + 1 = 4, 3 + 4 = 7, 2 + 1 = 3, 2 + 4 = 6, Top 2 sums are 7 and 6.
   * Input: a[] = [1, 4, 2, 3], b[] = [2, 5, 1, 6], k = 3
   * Output: [10, 9, 9]
   * Explanation: The top 3 maximum possible sums are : 4 + 6 = 10, 3 + 6 = 9, and 4 + 5 = 9
   */

  public static void main(String[] args) {
    System.out.println(topKSumPairs(new int[] {3, 2}, new int[] {1, 4}, 2));
    System.out.println(topKSumPairsOptimized(new int[] {3, 2}, new int[] {1, 4}, 2));
  }

  public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
    // code here
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        result.add(a[i] + b[j]);
      }
    }
    Collections.sort(result, Comparator.reverseOrder());
    return new ArrayList<>(result.subList(0, k));
  }

  public static ArrayList<Integer> topKSumPairsOptimized(int[] a, int[] b, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        int sum = a[i] + b[j];
        if (minHeap.size() < k) {
          minHeap.offer(sum);
        } else if (sum > minHeap.peek()) {
          minHeap.poll();
          minHeap.offer(sum);
        }
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      result.add(minHeap.poll());
    }
    Collections.reverse(result); // Convert to non-increasing order
    return result;
  }
}
