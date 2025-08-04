package sdeSheet.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 {

  // https://takeuforward.org/data-structure/kth-largest-smallest-element-in-an-array/

  /**
   * Given an integer array nums and an integer k, return the kth largest element in the array.
   * <p>
   * Note that it is the kth largest element in the sorted order, not the kth distinct element.
   * <p>
   * Can you solve it without sorting?
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [3,2,1,5,6,4], k = 2
   * Output: 5
   * Example 2:
   * <p>
   * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
   * Output: 4
   */

  public static void main(String[] args) {
    System.out.println(findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
    System.out.println(findKthLargestOptimized(new int[] {3, 2, 1, 5, 6, 4}, 2));
    System.out.println(findKthLargestOptimized(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    System.out.println("------------------------");
    System.out.println(findKthLargestMostOptimized(new int[] {3, 2, 1, 5, 6, 4}, 2));
    System.out.println(findKthLargestMostOptimized(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
  }

  /**
   * Time complexity: O(nlogn)
   * Space complexity: O(1)
   *
   * @param nums
   * @param k
   *
   * @return
   */
  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  /**
   * Time complexity: O(nlogn)
   * Space complexity: O(N)
   *
   * @param nums
   * @param k
   *
   * @return
   */
  public static int findKthLargestOptimized(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
      priorityQueue.add(num);
    }
    int index = k - 1;
    while (index > 0) {
      priorityQueue.poll();
      index--;
    }
    return priorityQueue.element();
  }

  /**
   * Time complexity: O(nlogk)
   * Space complexity: O(N)
   *
   * @param nums
   * @param k
   *
   * @return
   */
  public static int findKthLargestMostOptimized(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
    for (int num : nums) {
      minHeap.offer(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}
