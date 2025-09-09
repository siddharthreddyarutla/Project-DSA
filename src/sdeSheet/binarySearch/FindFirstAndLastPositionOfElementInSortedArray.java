package sdeSheet.binarySearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

  /**
   * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
   * position of a given target value.
   * <p>
   * If target is not found in the array, return [-1, -1].
   * <p>
   * You must write an algorithm with O(log n) runtime complexity.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [5,7,7,8,8,10], target = 8
   * Output: [3,4]
   * Example 2:
   * <p>
   * Input: nums = [5,7,7,8,8,10], target = 6
   * Output: [-1,-1]
   * Example 3:
   * <p>
   * Input: nums = [], target = 0
   * Output: [-1,-1]
   */

  public static void main(String[] args) {
    System.out.println(Arrays.toString(searchRange(new int[] {1, 2, 3}, 2)));
    System.out.println(Arrays.toString(searchRangeOptimal(new int[] {1, 2, 3}, 2)));
  }

  /**
   * This dint clear all the test cases but initial approach what I thought
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int[] searchRange(int[] nums, int target) {

    if (nums.length < 1) {
      return new int[] {-1, -1};
    }
    if (nums.length == 1 && nums[0] == target) {
      return new int[] {0, 0};
    }

    int[] ans = new int[2];
    int pos = binarySearch(nums, target, 0, nums.length - 1);
    if (pos == -1) {
      return new int[] {-1, -1};
    }
    ans[0] = pos;
    if (pos == 0) {
      int posRight = binarySearch(nums, target, pos + 1, nums.length - 1);
      ans[1] = posRight == -1 ? pos : posRight;
      return ans;
    }
    if (pos == nums.length - 1) {
      int posLeft = binarySearch(nums, target, 0, pos - 1);
      ans[1] = posLeft == -1 ? pos : posLeft;
      return ans;
    }
    int posLeft = binarySearch(nums, target, 0, pos - 1);
    if (posLeft != -1) {
      int right = ans[0];
      ans[0] = posLeft;
      ans[1] = right;
      return ans;
    }
    int posRight = binarySearch(nums, target, pos + 1, nums.length - 1);
    ans[1] = posRight == -1 ? pos : posRight;
    return ans;
  }

  public static int binarySearch(int[] nums, int target, int left, int right) {
    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }

  public static int[] searchRangeOptimal(int[] nums, int target) {
    if (nums.length < 1) {
      return new int[] {-1, -1};
    }
    if (nums.length == 1 && nums[0] == target) {
      return new int[] {0, 0};
    }

    int firstPos = findFirst(nums, target);
    if (firstPos == -1) {
      return new int[] {-1, -1};
    }
    int lastPos = findLast(nums, target);
    return new int[] {firstPos, lastPos};
  }

  public static int findFirst(int[] nums, int target) {
    int left = 0, right = nums.length - 1, ans = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        ans = mid;
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }

  public static int findLast(int[] nums, int target) {
    int left = 0, right = nums.length - 1, ans = -1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        ans = mid;
        left = mid + 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return ans;
  }
}
