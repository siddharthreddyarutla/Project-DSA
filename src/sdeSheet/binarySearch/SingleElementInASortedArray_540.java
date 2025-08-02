package sdeSheet.binarySearch;

public class SingleElementInASortedArray_540 {

  // https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/

  /**
   * You are given a sorted array consisting of only integers where every element appears exactly
   * twice, except for one element which appears exactly once.
   * <p>
   * Return the single element that appears only once.
   * <p>
   * Your solution must run in O(log n) time and O(1) space.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,2,3,3,4,4,8,8]
   * Output: 2
   * Example 2:
   * <p>
   * Input: nums = [3,3,7,7,10,11,11]
   * Output: 10
   */

  public static void main(String[] args) {
    System.out.println(singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
    System.out.println(singleNonDuplicate1(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
    System.out.println(singleNonDuplicateUsingBinarySearch(new int[] {3, 3, 7, 7, 10, 11, 11}));
  }

  /**
   * Time Complexity: O(N), N = size of the given array.
   * Reason: We are traversing the entire array.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param nums
   *
   * @return
   */
  public static int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    for (int i = 1; i < nums.length; i += 2) {
      if (nums[i] != nums[i - 1]) {
        return nums[i - 1];
      }
    }
    return nums[nums.length - 1];
  }

  /**
   * Time Complexity: O(N), N = size of the given array.
   * Reason: We are traversing the entire array.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param nums
   *
   * @return
   */
  public static final int singleNonDuplicate1(int[] nums) {
    int ans = 0;
    for (int num : nums) {
      ans = ans ^ num;
    }
    return ans;
  }

  // Intution -
  // (even, odd) element is present on right side
  // (odd, even) element is present on left side


  /**
   * Time Complexity: O(logN), N = size of the given array.
   * Reason: We are basically using the Binary Search algorithm.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param nums
   *
   * @return
   */
  public static final int singleNonDuplicateUsingBinarySearch(int[] nums) {
    int n = nums.length;
    if (n == 1) {
      return nums[0];
    }
    if (nums[0] != nums[1]) {
      return nums[0];
    }
    if (nums[n - 1] != nums[n - 2]) {
      return nums[n - 1];
    }

    int low = 1;
    int high = n - 2;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
        return nums[mid];
      } else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[
          mid + 1])) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}