package sdeSheet.stackAndQueue2;

import java.util.Stack;

public class LargestRectangleInAHistogram {

  // https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/

  /**
   * Given an array of integers heights representing the histogram's bar height where the width
   * of each bar is 1, return the area of the largest rectangle in the histogram.
   * <p>
   * Input: heights = [2,1,5,6,2,3]
   * Output: 10
   * Explanation: The above is a histogram where width of each bar is 1.
   * The largest rectangle is shown in the red area, which has an area = 10 units.
   * <p>
   * Input: heights = [2,1,5,6,2,3]
   * Output: 10
   * Explanation: The above is a histogram where width of each bar is 1.
   * The largest rectangle is shown in the red area, which has an area = 10 units.
   */

  public static void main(String[] args) {
    System.out.println(largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    System.out.println(largestRectangleAreaOptimized(new int[] {2, 1, 5, 6, 2, 3}));
  }

  /**
   * Time Complexity: O(N*N )
   * <p>
   * Space Complexity: O(1)
   *
   * @param heights
   *
   * @return
   */
  public static int largestRectangleArea(int[] heights) {

    int maxHeight = 0;
    for (int i = 0; i < heights.length; i++) {
      int minWidth = Integer.MAX_VALUE;
      for (int j = i; j < heights.length; j++) {
        minWidth = Math.min(heights[j], minWidth);
        maxHeight = Math.max(maxHeight, minWidth * (j - i + 1));
      }
    }
    return maxHeight;
  }

  /**
   * Time Complexity: O( 3N )
   * <p>
   * Space Complexity: O(3N) where 3 is for the stack, left small array and a right small array
   *
   * @param heights
   *
   * @return
   */
  public static int largestRectangleAreaOptimized(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int[] leftSmallerNearest = new int[n];
    int[] rightSmallerNearest = new int[n];

    /* Finding right nearest smaller element to form a rectangle */
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      rightSmallerNearest[i] = !stack.isEmpty() ? stack.peek() : n;
      stack.push(i);
    }
    stack.clear();
    /* Finding left nearest smaller element to form a rectangle */
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
        stack.pop();
      }
      leftSmallerNearest[i] = !stack.isEmpty() ? stack.peek() : -1;
      stack.push(i);
    }
    int max = 0;
    /* After finding left and right boundaries do
     *  Area = Length(height) * breadth(width)
     *  Height is nothing but the array index height and width is left and right smallest nearest
     *  element -1
     *  */
    for (int i = 0; i < n; i++) {
      max = Math.max(max, ((rightSmallerNearest[i] - leftSmallerNearest[i] - 1) * heights[i]));
    }
    return max;
  }
}
