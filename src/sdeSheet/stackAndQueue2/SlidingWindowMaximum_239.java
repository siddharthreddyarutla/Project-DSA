package sdeSheet.stackAndQueue2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(
        maxSlidingWindowUsingPriorityQueue(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(
        Arrays.toString(maxSlidingWindowUsingDeque(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }

  /**
   * Here removing from max heap is O(N) can be optimized with double ended queue like deque
   *
   * @param nums
   * @param k
   *
   * @return
   */
  public static int[] maxSlidingWindowUsingPriorityQueue(int[] nums, int k) {
    if (k > nums.length) {
      return new int[0];
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    int l = 0;
    while (l < k) {
      pq.offer(nums[l]);
      l++;
    }
    if (k == nums.length) {
      return new int[] {pq.peek()};
    }
    int[] ans = new int[nums.length - k + 1];
    int j = 0;
    for (int i = k; i < nums.length; i++) {
      ans[j] = pq.peek();
      pq.offer(nums[i]);
      pq.remove(nums[i - k]);
      j++;
      if (i == nums.length - 1) {
        ans[j] = pq.peek();
      }
    }
    return ans;
  }


  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(K)
   *
   * @param nums
   * @param k
   *
   * @return
   */
  public static int[] maxSlidingWindowUsingDeque(int[] nums, int k) {
    if (k > nums.length) {
      return new int[0];
    }
    int[] ans = new int[nums.length - k + 1];
    int j = 0;
    // Using deque for adding and removing from both ends, Storing only index here
    Deque<Integer> dq = new ArrayDeque<>();
    // Loop entire array once
    for (int i = 0; i < nums.length; i++) {
      /* Here we only keep max k size elements in deque, pop from first if exceeds, because we
      push from last */
      while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
        dq.pollFirst();
      }

      /* Here we remove all less than current element nums[i], we only need the max in the window
       why to store others even of window size, remove from last as max no index is stored at last*/
      while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
        dq.pollLast();
      }

      // add at last
      dq.offerLast(i);

      // Add to ans array if index is equal or greater than size of window
      if (i >= k - 1) {
        // peek from first as first has max no index
        ans[j] = nums[dq.peekFirst()];
        j++;
      }
    }
    return ans;
  }
}
