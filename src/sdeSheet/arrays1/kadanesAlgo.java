package sdeSheet.arrays1;

public class kadanesAlgo {

  //  https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/

  /**
   * Problem Statement: Given an integer array arr, find the contiguous subarray (containing at
   * least one number) which
   * has the largest sum and returns its sum and prints the subarray.
   * <p>
   * Examples
   * Example 1:
   * Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
   * Output: 6
   * Explanation: [4,-1,2,1] has the largest sum = 6.
   * Examples 2:
   * Input: arr = [1]
   * Output: 1
   * Explanation: Array has only one element and which is giving positive sum of 1.
   */

  public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    int[] nums = new int[n];
    //    for (int i = 0; i < n; i++) {
    //      nums[i] = sc.nextInt();
    //    }
    //    sc.close();
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
    System.out.println(maxSubArrayOptimized(nums));
  }

  /**
   * Time Complexity: O(N2), where N = size of the array.
   * Reason: We are using two nested loops, each running approximately N times.
   * Space Complexity: O(1) as we are not using any extra space.
   */
  public static int maxSubArray(int[] nums) {
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum > max) {
          max = sum;
        }
      }
    }
    return max;
  }

  public static int maxSubArrayOptimized(int[] nums) {
    int maxSum = Integer.MIN_VALUE;
    int currSum = 0;
    for (int num : nums) {
      currSum += num;
      maxSum = Math.max(maxSum, currSum);
      if (currSum < 0) {
        currSum = 0;
      }
    }
    return maxSum;
  }
}
