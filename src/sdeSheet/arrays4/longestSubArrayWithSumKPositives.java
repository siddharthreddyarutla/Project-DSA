package sdeSheet.arrays4;

public class longestSubArrayWithSumKPositives {

  // https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/

  /**
   * Problem Statement: Given an array and a sum k, we need to print the length of the longest
   * subarray that sums to k.
   * <p>
   * Examples
   * <p>
   * Example 1:
   * Input Format: N = 3, k = 5, array[] = {2,3,5}
   * Result: 2
   * Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
   * <p>
   * Example 2:
   * Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
   * Result: 3
   * Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
   */

  public static void main(String[] args) {
    System.out.println(longestSubarrayOptimal(new int[] {10, 5, 2, 7, 1, -10}, 15));
  }


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

  /**
   * Time Complexity: O(2*N), where N = size of the given array.
   * Reason: The outer while loop i.e. the right pointer can move up to index n-1(the last index)
   * . Now, the inner while loop i.e. the left pointer can move up to the right pointer at most.
   * So, every time the inner loop does not run for n times rather it can run for n times in
   * total. So, the time complexity will be O(2*N) instead of O(N2).
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param arr
   * @param k
   *
   * @return
   */
  public static int longestSubarrayOptimal(int[] arr, int k) {
    int i = 0;
    int j = 0;
    int n = arr.length;
    int prefixSum = arr[0];
    int max = 0;
    while (j < n) {
      while (i <= j && prefixSum > k) {
        prefixSum -= arr[i];
        i++;
      }
      if (prefixSum == k) {
        max = Math.max(max, j - i + 1);
      }
      j++;
      if (j < n) {
        prefixSum += arr[j];
      }
    }
    return max;
  }
}
