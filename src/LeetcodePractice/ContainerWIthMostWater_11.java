package LeetcodePractice;

public class ContainerWIthMostWater_11 {

  // https://leetcode.com/problems/container-with-most-water/

  /**
   * You are given an integer array height of length n. There are n vertical lines drawn such
   * that the two endpoints of the ith line are (i, 0) and (i, height[i]).
   * <p>
   * Find two lines that together with the x-axis form a container, such that the container
   * contains the most water.
   * <p>
   * Return the maximum amount of water a container can store.
   * <p>
   * Notice that you may not slant the container.
   * <p>
   * Input: height = [1,8,6,2,5,4,8,3,7]
   * Output: 49
   * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this
   * case, the max area of water (blue section) the container can contain is 49.
   */

  public static void main(String[] args) {
    System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    System.out.println(maxAreaOptimal(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }

  public static int maxArea(int[] height) {
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < height.length; i++) {
      for (int j = 0; j < height.length; j++) {
        int min = Math.min(height[i], height[j]);
        maxArea = Math.max(maxArea, min * (j - i));
      }
    }
    return maxArea;
  }

  /**
   * Time complexity: O(n)
   * Space complexity: O(1)
   *
   * @param height
   *
   * @return
   */
  public static int maxAreaOptimal(int[] height) {
    int n = height.length;
    int left = 0;
    int right = n - 1;
    int maxArea = Integer.MIN_VALUE;

    while (left < right) {
      int min = Math.min(height[left], height[right]);
      maxArea = Math.max(maxArea, min * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}
