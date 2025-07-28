package sdeSheet.arrays2;

import java.util.Arrays;

public class FindDuplicateInAnArrayOfIntegers_287 {

  // https://takeuforward.org/data-structure/find-the-duplicate-in-an-array-of-n1-integers/

  /**
   * Given an array of integers nums containing n + 1 integers where each integer is in the range
   * [1, n] inclusive.
   * <p>
   * There is only one repeated number in nums, return this repeated number.
   * <p>
   * You must solve the problem without modifying the array nums and using only constant extra
   * space.
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
    System.out.println(findDuplicateOptimized2(new int[] {1, 3, 4, 2, 2}));
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

  public static int findDuplicateOptimized2(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];

    // Phase 1: Find intersection
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    // Phase 2: Find entrance (duplicate)
    slow = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }
}
