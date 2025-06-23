package sdeSheet.linkedListAndArrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {

  /**
   * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
   * such that each unique element appears only once. The relative order of the elements should
   * be kept the same. Then return the number of unique elements in nums.
   * <p>
   * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
   * following things:
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,2]
   * Output: 2, nums = [1,2,_]
   * Explanation: Your function should return k = 2, with the first two elements of nums being 1
   * and 2 respectively.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   * Example 2:
   * <p>
   * Input: nums = [0,0,1,1,1,2,2,3,3,4]
   * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
   * Explanation: Your function should return k = 5, with the first five elements of nums being
   * 0, 1, 2, 3, and 4 respectively.
   * It does not matter what you leave beyond the returned k (hence they are underscores).
   */

  public static void main(String[] args) {
    int[] temp = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    System.out.println(removeDuplicates(temp));
    System.out.println(Arrays.toString(temp));
  }

  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(1)
   *
   * @param nums
   *
   * @return
   */
  public static int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int i = 0;
    for (int j = 1; j < nums.length; j++) {
      if (nums[i] != nums[j]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }
}
