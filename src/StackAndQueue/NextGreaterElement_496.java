package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_496 {

  // https://takeuforward.org/data-structure/next-greater-element-using-stack/

  /**
   * The next greater element of some element x in an array is the first greater element that is
   * to the right of x in the same array.
   * <p>
   * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset
   * of nums2.
   * <p>
   * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and
   * determine the next greater element of nums2[j] in nums2. If there is no next greater
   * element, then the answer for this query is -1.
   * <p>
   * Return an array ans of length nums1.length such that ans[i] is the next greater element as
   * described above.
   * <p>
   * Example 1:
   * <p>
   * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
   * Output: [-1,3,-1]
   * Explanation: The next greater element for each value of nums1 is as follows:
   * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
   * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
   * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
   */

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));
    System.out.println(
        Arrays.toString(nextGreaterElementUsingStack(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2})));
  }

  /**
   * Time complexity: O(n)
   * space complexity: O(n)
   *
   * @param nums1
   * @param nums2
   *
   * @return
   */
  public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      int nextGreater = -1;
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
          int index = j;
          while (index < nums2.length) {
            if (nums2[index] > nums1[i]) {
              nextGreater = nums2[index];
              break;
            }
            index++;
          }
        }
      }
      result[i] = nextGreater;
    }
    return result;
  }

  public static int[] nextGreaterElementOptimized(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      int nextGreater = -1;
      int indexInNums2 = -1;
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) {
          indexInNums2 = j;
          break;
        }
      }
      while (indexInNums2 < nums2.length) {
        if (nums2[indexInNums2] > nums1[i]) {
          nextGreater = nums2[indexInNums2];
          break;
        }
        indexInNums2++;
      }
      result[i] = nextGreater;
    }
    return result;
  }

  public static int[] nextGreaterElementUsingStack(int[] nums1, int[] nums2) {
    int[] nextGreater = new int[10001];
    Stack<Integer> stack = new Stack<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
        stack.pop();
      }
      nextGreater[nums2[i]] = stack.isEmpty() ? -1 : stack.peek();
      stack.push(nums2[i]);
    }
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = nextGreater[nums1[i]];
    }
    return nums1;
  }
}
