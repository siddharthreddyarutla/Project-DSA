package sdesheet.arrays2;

import java.util.Arrays;

public class FindDuplicateInAnArrayOfIntegers_287 {

  // https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/

  /**
   * Problem Statement: Given an array of N + 1 size, where each element is between 1 and N.
   * Assuming there is only one duplicate number, your task is to find the duplicate number.
   * <p>
   * Examples:
   * Example 1:
   * <p>
   * Input: arr=[1,3,4,2,2]
   * <p>
   * Output: 2
   * <p>
   * Explanation: Since 2 is the duplicate number the answer will be 2.
   * <p>
   * Example 2:
   * <p>
   * Input: [3,1,3,4,2]
   * <p>
   * Output:3
   * <p>
   * Explanation: Since 3 is the duplicate number the answer will be 3.
   */

  public static void main(String[] args) {
    System.out.println(findDuplicate(new int[] {1, 3, 4, 2, 2}));
    System.out.println(findDuplicateOptimized(new int[] {1, 3, 4, 2, 2}));
    System.out.println(findDuplicateOptimized1(new int[] {1, 3, 4, 2, 2}));
  }

  /**
   * T.C - O(n log n) for sort + O(n)  - O(Nlogn + N)
   * S.C - O(1)
   *
   * @param nums
   *
   * @return
   */
  public static int findDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] == nums[i]) {
        return nums[i];
      }
    }
    return 0;
  }

  /**
   * Time Complexity: O(N), as we are traversing through the array only once.
   * <p>
   * Space Complexity: O(N), as we are using extra space for frequency array.
   *
   * @param nums
   *
   * @return
   */
  public static int findDuplicateOptimized(int[] nums) {
    int n = nums.length;
    int[] hashValues = new int[n];
    for (int i = 0; i < n; i++) {
      int hashKey = nums[i] % n;
      if (hashValues[hashKey] > 0) {
        return nums[i];
      } else {
        hashValues[hashKey] = nums[i];
      }
    }
    return 0;
  }

  /**
   * Time Complexity: O(N), as we are traversing through the array only once.
   * <p>
   * Space Complexity: O(N), as we are using extra space for frequency array.
   *
   * @param arr
   *
   * @return
   */
  public static int findDuplicateOptimized1(int[] arr) {
    int n = arr.length;
    int[] freq = new int[n + 1];
    for (int i = 0; i < n; i++) {
      if (freq[arr[i]] == 0) {
        freq[arr[i]] += 1;
      } else {
        return arr[i];
      }
    }
    return 0;
  }
}
