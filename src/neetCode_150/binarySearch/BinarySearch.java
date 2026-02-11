package neetCode_150.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

  /**
   * 704. Binary Search
   * Solved
   * Easy
   * <p>
   * Topics
   * premium lock icon
   * Companies
   * Given an array of integers nums which is sorted in ascending order, and an integer target,
   * write a function to search target in nums. If target exists, then return its index.
   * Otherwise, return -1.
   * <p>
   * You must write an algorithm with O(log n) runtime complexity.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [-1,0,3,5,9,12], target = 9
   * Output: 4
   * Explanation: 9 exists in nums and its index is 4
   * Example 2:
   * <p>
   * Input: nums = [-1,0,3,5,9,12], target = 2
   * Output: -1
   * Explanation: 2 does not exist in nums so return -1
   */

  public static void main(String[] args) {

  }

  public static int search(int[] nums, int target) {
    int n = nums.length;
    int start = 0;
    int end = n - 1;

    while (start <= end) {
      int mid = start + (end - start) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        start++;
      } else {
        end--;
      }
      List<Integer> res = new ArrayList<>();
    }

    return -1;
  }
}
