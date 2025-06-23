package sdeSheet.linkedListAndArrays;

public class trappingRainWater_42 {

  // https://takeuforward.org/data-structure/trapping-rainwater/

  /**
   * Given n non-negative integers representing an elevation map where the width of each bar is
   * 1, compute how much water it can trap after raining.
   * <p>
   * Example 1:
   * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
   * Output: 6
   * <p>
   * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,
   * 3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
   * Example 2:
   * <p>
   * Input: height = [4,2,0,3,2,5]
   * Output: 9
   */

  public static void main(String[] args) {
    System.out.println(trapRainWater(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    System.out.println(trapRainWater(new int[] {4, 2, 0, 3, 2, 5}));
    System.out.println();
    System.out.println(trapRainWaterBetter(new int[] {4, 2, 0, 3, 2, 5}));
    System.out.println(trapRainWaterBetter(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }

  /**
   * Time Complexity: O(N*N) as for each index we are calculating leftMax and rightMax so it is a
   * nested loop.
   * <p>
   * Space Complexity: O(1).
   *
   * @param height
   *
   * @return
   */
  public static int trapRainWater(int[] height) {
    int n = height.length;
    int totalRainWaterStored = 0;
    for (int i = 0; i < n; i++) {
      int j = i;
      int leftMax = Integer.MIN_VALUE;
      int rightMax = Integer.MIN_VALUE;
      while (j >= 0) {
        leftMax = Math.max(leftMax, height[j]);
        j--;
      }
      j = i;
      while (j < n) {
        rightMax = Math.max(rightMax, height[j]);
        j++;
      }
      totalRainWaterStored += Math.min(leftMax, rightMax) - height[i];
    }
    return totalRainWaterStored;
  }

  /**
   * Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for
   * computing prefix and suffix array.
   * <p>
   * Space Complexity: O(N)+O(N) for prefix and suffix arrays.
   *
   * @param height
   *
   * @return
   */
  public static int trapRainWaterBetter(int[] height) {
    int n = height.length;
    int[] prefixSum = new int[n];
    prefixSum[0] = height[0];
    for (int i = 1; i < n; i++) {
      prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
    }
    int[] suffixSum = new int[n];
    suffixSum[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      suffixSum[i] = Math.max(suffixSum[i + 1], height[i]);
    }
    int trapRainWater = 0;
    for (int i = 0; i < n; i++) {
      trapRainWater += Math.min(prefixSum[i], suffixSum[i]) - height[i];
    }
    return trapRainWater;
  }

  /**
   * Time Complexity: O(N) because we are using 2 pointer approach.
   * <p>
   * Space Complexity: O(1) because we are not using anything extra.
   *
   * @param height
   *
   * @return
   */
  public static int trapRainWaterOptimal(int[] height) {
    int n = height.length;
    int leftMax = 0;
    int rightMax = 0;
    int left = 0;
    int right = n - 1;
    int res = 0;

    while (left <= right) {
      if (height[left] <= height[right]) {
        if (height[left] > leftMax) {
          leftMax = height[left];
        } else {
          res += leftMax - height[left];
        }
        left++;
      } else {
        if (rightMax <= height[right]) {
          rightMax = height[right];
        } else {
          res += rightMax - height[right];
        }
        right--;
      }
    }
    return res;
  }
}
