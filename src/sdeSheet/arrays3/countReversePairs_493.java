package sdeSheet.arrays3;

import java.util.ArrayList;
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

  /**
   * Time Complexity: O(2N*logN), where N = size of the given array.
   * Reason: Inside the mergeSort() we call merge() and countPairs() except mergeSort() itself.
   * Now, inside the function countPairs(), though we are running a nested loop, we are actually
   * iterating the left half once and the right half once in total. That is why, the time
   * complexity is O(N). And the merge() function also takes O(N). The mergeSort() takes O(logN)
   * time complexity. Therefore, the overall time complexity will be O(logN * (N+N)) = O(2N*logN).
   * <p>
   * Space Complexity: O(N), as in the merge sort We use a temporary array to store elements in
   * sorted order.
   * <p>
   * Video Explanation
   *
   * @param nums
   *
   * @return
   */
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
