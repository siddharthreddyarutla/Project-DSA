package neetCode_150.slidingWIndow;

import java.util.Arrays;

public class maximumSubArray {

  public static void main(String[] args) {
    int[] temp = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(Arrays.toString(maximumSumSubArray(temp)));
    System.out.println((Arrays.toString(maximumSumSubArrayOptimal(new int[] {-2, 3, 4, -10, 5}))));
    System.out.println((Arrays.toString(maximumSumSubArrayOptimal(temp))));
  }

  public static int[] maximumSumSubArray(int[] nums) {

    int n = nums.length;
    int max = 0;
    int start = 0, end = 0;

    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];

        if (sum > max) {
          max = sum;
          start = i;
          end = j;
        }
      }
    }
    int[] ans = new int[(end - start + 1)];
    int k = 0;
    for (int i = start; i <= end; i++) {
      ans[k] = nums[i];
      k++;
    }

    return ans;
  }


  public static int[] maximumSumSubArrayOptimal(int[] nums) {

    int max = nums[0];
    int n = nums.length;
    int currSum = nums[0];
    int start = 0, end = 0, tempStart = 0;

    for (int i = 1; i < n; i++) {

      if (currSum + nums[i] < nums[i]) {
        currSum = nums[i];
        tempStart = i;
      } else {
        currSum += nums[i];
      }

      if (currSum > max) {
        max = currSum;
        end = i;
        start = tempStart;
      }
    }

    int[] ans = new int[(end - start + 1)];
    int k = 0;
    for (int i = start; i <= end; i++) {
      ans[k] = nums[i];
      k++;
    }

    return ans;
  }
}
