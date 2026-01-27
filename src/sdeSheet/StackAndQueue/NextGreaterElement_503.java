package sdeSheet.StackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement_503 {

  // https://takeuforward.org/data-structure/next-greater-element-using-stack/

  /**
   * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is
   * nums[0]), return the next greater number for every element in nums.
   * <p>
   * The next greater number of a number x is the first greater number to its traversing-order
   * next in the array, which means you could search circularly to find its next greater number.
   * If it doesn't exist, return -1 for this number.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,2,1]
   * Output: [2,-1,2]
   * Explanation: The first 1's next greater number is 2;
   * The number 2 can't find next greater number.
   * The second 1's next greater number needs to search circularly, which is also 2.
   */

  public static void main(String[] args) {
    System.out.println(Arrays.toString(nextGreaterElements(new int[] {1, 2, 1})));
    System.out.println(Arrays.toString(nextGreaterElementsOptimized(new int[] {1, 3, 2, 4})));
  }

  /**
   * Time Complexity: O(n²)
   * Space complexity:O(1)
   *
   * @param nums
   *
   * @return
   */
  public static int[] nextGreaterElements(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int nextIndex = i;
      int nextGreaterElement = -1;
      while (true) {
        nextIndex = (nextIndex + 1) % nums.length;

        if (nextIndex == i) {
          break;
        }

        if (nums[nextIndex] > nums[i]) {
          nextGreaterElement = nums[nextIndex];
          break;
        }
      }
      result[i] = nextGreaterElement;
    }
    return result;
  }

  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(N)
   *
   * @param nums
   *
   * @return
   */
  public static int[] nextGreaterElementsOptimized(int[] nums) {
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int[] result = new int[nums.length];
    Collections.sort(stack, Collections.reverseOrder());

    for (int i = 2 * n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
        stack.pop();
      }
      if (i < n) {
        if (stack.isEmpty()) {
          result[i] = -1;
        } else {
          result[i] = stack.peek();
        }
      }
      stack.push(nums[i % n]);
    }
    return result;
  }
}
