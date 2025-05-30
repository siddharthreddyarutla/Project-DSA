package sdesheet.arrays4;

import java.util.HashMap;

public class longestSubArrayWithZeroSum {

  // https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/

  /**
   * Given an array arr containing both positive and negative integers, the task is to compute
   * the length of the largest subarray that has a sum of 0.
   * <p>
   * Examples:
   * <p>
   * Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
   * Output: 5
   * Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
   * Input: arr[] = [2, 10, 4]
   * Output: 0
   * Explanation: There is no subarray with a sum of 0.
   * Input: arr[] = [1, 0, -4, 3, 1, 0]
   * Output: 5
   * Explanation: The subarray is [0, -4, 3, 1, 0].
   */

  public static void main(String[] args) {
    System.out.println(maxLen(new int[] {15, -2, 2, -8, 1, 7, 10, 23}));
    System.out.println(maxLen(new int[] {2, 10, 4}));
    System.out.println(maxLen(new int[] {1, 0, -4, 3, 1, 0}));
    System.out.println();
    System.out.println(maxLenOptimized(new int[] {15, -2, 2, -8, 1, 7, 10, 23}));
    System.out.println(maxLenOptimized(new int[] {2, 10, 4}));
    System.out.println(maxLenOptimized(new int[] {1, 0, -4, 3, 1, 0}));
  }

  /**
   * Time Complexity: O(N^2) as we have two loops for traversal
   * <p>
   * Space Complexity: O(1) as we aren’t using any extra space.
   *
   * @param arr
   *
   * @return
   */
  public static int maxLen(int[] arr) {
    int maxlen = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == 0) {
          maxlen = Math.max(maxlen, (j - i + 1));
        }
      }
    }
    return maxlen;
  }

  /**
   * Time Complexity: O(N), as we are traversing the array only once
   * <p>
   * Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into
   * our hashmap
   *
   * @param arr
   *
   * @return
   */
  public static int maxLenOptimized(int[] arr) {
    int prefixSum = 0;
    int maxLen = prefixSum;
    HashMap<Integer, Integer> hash = new HashMap<>(arr.length);

    for (int i = 0; i < arr.length; i++) {
      prefixSum += arr[i];
      if (prefixSum == 0) {
        maxLen = Math.max(maxLen, i + 1);
      }
      if (hash.containsKey(prefixSum)) {
        maxLen = Math.max(maxLen, (i - hash.get(prefixSum)));
      } else {
        hash.put(prefixSum, i);
      }
    }
    return maxLen;
  }
}
