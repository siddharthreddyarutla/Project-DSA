package sdeSheet.binarySearch;

public class SearchInRotatedSortedArray_33 {

  // https://takeuforward.org/data-structure/search-element-in-a-rotated-sorted-array/

  /**
   * There is an integer array nums sorted in ascending order (with distinct values).
   * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
   * (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1],
   * nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated
   * at pivot index 3 and become [4,5,6,7,0,1,2].
   * Given the array nums after the possible rotation and an integer target, return the index of
   * target if it is in nums, or -1 if it is not in nums.
   * <p>
   * You must write an algorithm with O(log n) runtime complexity.
   * Example 1:
   * <p>
   * Input: nums = [4,5,6,7,0,1,2], target = 0
   * Output: 4
   * Example 2:
   * <p>
   * Input: nums = [4,5,6,7,0,1,2], target = 3
   * Output: -1
   */

  public static void main(String[] args) {
    System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    System.out.println(searchUsingBinarySearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
  }

  /**
   * Time Complexity: O(N), N = size of the given array.
   * Reason: We have to iterate through the entire array to check if the target is present in the
   * array.
   * <p>
   * Space Complexity: O(1)
   * Reason: We have not used any extra data structures, this makes space complexity, even in the
   * worst case as O(1).
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Time Complexity: O(logN), N = size of the given array.
   * Reason: We are using binary search to search the target.
   * <p>
   * Space Complexity: O(1)
   * Reason: We have not used any extra data structures, this makes space complexity, even in the
   * worst case as O(1).
   *
   * @param nums
   * @param target
   *
   * @return
   */
  public static int searchUsingBinarySearch(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      // eliminate the half's
      if (nums[low] <= nums[mid]) {
        if (nums[low] <= target && target <= nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      // else second half
      else {
        if (nums[mid] <= target && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}
