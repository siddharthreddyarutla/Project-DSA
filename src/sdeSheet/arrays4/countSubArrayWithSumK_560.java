package sdeSheet.arrays4;

import java.util.HashMap;
import java.util.Map;

public class countSubArrayWithSumK_560 {

  /**
   * Given an array of integers nums and an integer k, return the total number of subarrays whose
   * sum equals to k.
   * <p>
   * A subarray is a contiguous non-empty sequence of elements within an array.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,1], k = 2
   * Output: 2
   * Example 2:
   * <p>
   * Input: nums = [1,2,3], k = 3
   * Output: 2
   */

  public static void main(String[] args) {
    System.out.println(subarraySum(new int[] {1, 2, 1, 2, 1}, 3));
    System.out.println(subarraySumOptimized(new int[] {9, 4, 0, 20, 3, 10, 5}, 33));
  }

  /**
   * Time Complexity: O(N2), where N = size of the array.
   * Reason: We are using two nested loops here. As each of them is running for exactly N times,
   * the time complexity will be approximately O(N2).
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param arr
   * @param k
   *
   * @return
   */
  public static int subarraySum(int[] arr, int k) {
    int maxlen = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          maxlen++;
        }
      }
    }
    return maxlen;
  }


  /**
   * Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where
   * N = size of the array.
   * Reason: For example, if we are using an unordered_map data structure in C++ the time
   * complexity will be O(N) but if we are using a map data structure, the time complexity will
   * be O(N*logN). The least complexity will be O(N) as we are using a loop to traverse the array.
   * <p>
   * Space Complexity: O(N) as we are using a map data structure.
   *
   * @param arr
   * @param k
   *
   * @return
   */
  public static int subarraySumOptimized(int[] arr, int k) {
    int n = arr.length;
    int[] prefixSum = new int[arr.length];
    int cnt = 0;
    Map<Integer, Integer> map = new HashMap<>(arr.length);

    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = prefixSum[i - 1] + arr[i];
    }

    for (int j = 0; j < n; j++) {
      // case - 2
      if (prefixSum[j] == k) {
        cnt++;
      }
      // case - 1
      int psOfiMinus1 = prefixSum[j] - k;
      if (map.containsKey(psOfiMinus1)) {
        cnt += map.get(psOfiMinus1);
      }
      int value = map.getOrDefault(prefixSum[j], 0);
      map.put(prefixSum[j], value + 1);
    }
    return cnt;
  }
}
