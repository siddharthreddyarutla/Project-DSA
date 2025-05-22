package sdesheet.arrays3;

import com.sun.jdi.VMMismatchException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class countReversePairs_493 {

  // https://takeuforward.org/data-structure/count-reverse-pairs/

  /**
   * Given an integer array nums, return the number of reverse pairs in the array.
   * <p>
   * A reverse pair is a pair (i, j) where:
   * <p>
   * 0 <= i < j < nums.length and
   * nums[i] > 2 * nums[j].
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,3,2,3,1]
   * Output: 2
   * Explanation: The reverse pairs are:
   * (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
   * (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
   * Example 2:
   * <p>
   * Input: nums = [2,4,3,5,1]
   * Output: 3
   * Explanation: The reverse pairs are:
   * (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
   * (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
   * (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
   */

  public static void main(String[] args) {
    System.out.println(reversePairs(new int[] {2, 4, 3, 5, 1}));
    int[] temp = new int[] {2, 4, 3, 5, 1};
    System.out.println(reversePairsOptimized(temp));
    System.out.println(reversePairsOptimized(new int[] {-5, -5}));
  }

  public static int reversePairs(int[] nums) {
    int reversePairsCount = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > (2 * nums[j])) {
          reversePairsCount++;
        }
      }
    }
    return reversePairsCount;
  }

  public static int reversePairsOptimized(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  public static int mergeSort(int[] nums, int low, int high) {
    int count = 0;
    if (low >= high) {
      return count;
    }
    int mid = (low + high) / 2;
    count += mergeSort(nums, low, mid);
    count += mergeSort(nums, mid + 1, high);
    count += countPairs(nums, low, mid, high);
    merge(nums, low, mid, high);
    return count;
  }

  public static void merge(int[] nums, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    List<Integer> temp = new ArrayList<>(nums.length);
    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left]);
        left++;
      } else {
        temp.add(nums[right]);
        right++;
      }
    }
    while (left <= mid) {
      temp.add(nums[left]);
      left++;
    }
    while (right <= high) {
      temp.add(nums[right]);
      right++;
    }
    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i - low);
    }
  }

  public static int countPairs(int[] nums, int low, int mid, int high) {
    int cnt = 0;
    int right = mid + 1;
    for (int i = low; i <= mid; i++) {
      while (right <= high && nums[i] > 2 * nums[right]) {
        right++;
      }
      cnt += (right - (mid + 1));
    }
    return cnt;
  }
}
