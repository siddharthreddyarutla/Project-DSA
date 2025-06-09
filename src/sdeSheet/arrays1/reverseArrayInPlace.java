package sdeSheet.arrays1;

import java.util.Arrays;

public class reverseArrayInPlace {

  /**
   * Input: nums = [3,2,1]
   * Output: [1,2,3]
   */


  public static void main(String[] args) {
    int[] temp = new int[] {4, 3, 2, 1};
    reverseArray(temp);
    System.out.println(Arrays.toString(temp));
  }

  public static void reverseArray(int[] nums) {
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
