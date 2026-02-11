package neetCode_150.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

  /**
   * Given an integer array nums and an integer k, return the k most frequent elements. You may
   * return the answer in any order.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,1,2,2,3], k = 2
   * <p>
   * Output: [1,2]
   * <p>
   * Example 2:
   * <p>
   * Input: nums = [1], k = 1
   * <p>
   * Output: [1]
   * <p>
   * Example 3:
   * <p>
   * Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
   * <p>
   * Output: [1,2]
   */


  public static void main(String[] args) {

  }

  public int[] topKFrequent(int[] nums, int k) {

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    List<Integer> ans = new ArrayList<>();

    List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());

    mapList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

    for (Map.Entry<Integer, Integer> entry : mapList) {
      if (k > 0) {
        ans.add(entry.getKey());
        k--;
      }
    }

    return ans.stream().mapToInt(Integer::intValue).toArray();
  }

  public int[] topKFrequentOptimized(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
      if (!a.getValue().equals(b.getValue())) {
        return Integer.compare(a.getValue(), b.getValue());
      } else {
        return Integer.compare(a.getKey(), b.getKey());
      }
    });

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    int[] ans = new int[k];
    int i = 0;
    for (Map.Entry<Integer, Integer> entry : minHeap) {
      ans[i] = entry.getKey();
      i++;
    }

    List.of(0).stream().sorted();

    return ans;
  }
}
