package sdeSheet.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

  /**
   * Given an integer array nums and an integer k, return the k most frequent elements. You may
   * return the answer in any order.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,1,2,2,3], k = 2
   * Output: [1,2]
   * Example 2:
   * <p>
   * Input: nums = [1], k = 1
   * Output: [1]
   */

  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return b.getValue() - a.getValue();
      } else {
        return a.getKey() - b.getKey();
      }
    });
    minHeap.addAll(map.entrySet());
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll().getKey();
    }
    return result;
  }
}
