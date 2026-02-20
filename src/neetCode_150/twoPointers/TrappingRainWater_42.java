package neetCode_150.twoPointers;

public class TrappingRainWater_42 {

  public static void main(String[] args) {

    System.out.println(trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
  }

  public static int trap(int[] height) {

    int ans = 0;
    int n = height.length;

    for (int i = 1; i < n - 1; i++) {

      // left
      int maxHeightLeft = 0;
      for (int j = i - 1; j >= 0; j--) {
        maxHeightLeft = Math.max(maxHeightLeft, height[j]);
      }

      // right
      int maxHeightRight = 0;
      for (int j = i + 1; j < n; j++) {
        maxHeightRight = Math.max(maxHeightRight, height[j]);
      }

      int minOfBoth = Math.min(maxHeightRight, maxHeightLeft);
      if (minOfBoth > height[i]) {
        ans += minOfBoth - height[i];
      }
    }

    return ans;
  }

  public int trapOptimal(int[] height) {

    int ans = 0;
    int n = height.length;
    int[] prefix = new int[n];
    prefix[0] = height[0];
    int[] suffix = new int[n];
    suffix[n - 1] = height[n - 1];


    for (int i = 1; i < n; i++) {
      prefix[i] = Math.max(prefix[i - 1], height[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      suffix[i] = Math.max(suffix[i + 1], height[i]);
    }


    for (int i = 1; i < n; i++) {
      ans += Math.min(prefix[i], suffix[i]) - height[i];
    }

    return ans;
  }
}
