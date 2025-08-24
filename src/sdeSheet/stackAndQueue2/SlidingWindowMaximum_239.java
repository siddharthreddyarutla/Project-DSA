package sdeSheet.stackAndQueue2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(
        maxSlidingWindowUsingPriorityQueue(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    System.out.println(
        Arrays.toString(maxSlidingWindowUsingDeque(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)));
  }


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

  public static int[] maxSlidingWindowUsingDeque(int[] nums, int k) {

  }
}
