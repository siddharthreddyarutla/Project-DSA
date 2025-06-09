package sdeSheet.arrays4;

import java.util.HashMap;

public class longestSubArrayWithSumK {

  // https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/

  /**
   * Given an array arr[] containing integers and an integer k, your task is to find the length
   * of the longest subarray where the sum of its elements is equal to the given value k. If
   * there is no subarray with sum equal to k, return 0.
   * <p>
   * Examples:
   * <p>
   * Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
   * Output: 6
   * Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10].
   * The length of the longest subarray with a sum of 15 is 6.
   * Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
   * Output: 5
   * Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
   * Input: arr[] = [10, -10, 20, 30], k = 5
   * Output: 0
   * Explanation: No subarray with sum = 5 is present in arr[].
   */

  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[] {-5, 8, -14, 2, 4, 12}, -5));
    System.out.println(longestSubarrayBetter(new int[] {10, -10, 20, 30}, 5));
  }


  /**
   * Time Complexity: O(N2) approx., where N = size of the array.
   * Reason: We are using two nested loops, each running approximately N times.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param arr
   * @param k
   *
   * @return
   */
  public static int longestSubarray(int[] arr, int k) {
    // code here
    int cnt = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          cnt = Math.max(cnt, j - i + 1);
        }
      }
    }
    return cnt;
  }

  public static int longestSubarrayBetter(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>(arr.length);
    int[] prefix = new int[arr.length];
    prefix[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      int value = prefix[i] - k;
      if (prefix[i] == k) {
        max = Math.max(max, i + 1);
      }
      if (map.containsKey(value)) {
        max = Math.max(max, i - map.get(value));
      }
      if (!map.containsKey(prefix[i])) {
        map.put(prefix[i], i);
      }
    }
    return max;
  }

  /**
   * Same as above but just removed the prefix sum calculation
   * <p>
   * <p>
   * Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where
   * N = size of the array.
   * Reason: For example, if we are using an unordered_map data structure in C++ the time
   * complexity will be O(N)(though in the worst case, unordered_map takes O(N) to find an
   * element and the time complexity becomes O(N2)) but if we are using a map data structure, the
   * time complexity will be O(N*logN). The least complexity will be O(N) as we are using a loop
   * to traverse the array.
   * <p>
   * Space Complexity: O(N) as we are using a map data structure.
   *
   * @param arr
   * @param k
   *
   * @return
   */
  public static int longestSubarrayBetterOptimal(int[] arr, int k) {
    HashMap<Integer, Integer> map = new HashMap<>(arr.length);
    int max = 0;
    int prefixSum = 0;
    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];
      int value = prefixSum - k;
      if (prefixSum == k) {
        max = Math.max(max, i + 1);
      }
      if (map.containsKey(value)) {
        max = Math.max(max, i - map.get(value));
      }
      if (!map.containsKey(prefixSum)) {
        map.put(prefixSum, i);
      }
    }
    return max;
  }
}
