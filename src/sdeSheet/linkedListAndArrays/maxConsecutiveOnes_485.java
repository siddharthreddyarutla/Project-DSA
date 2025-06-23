package sdeSheet.linkedListAndArrays;

public class maxConsecutiveOnes_485 {

  /**
   * Given a binary array nums, return the maximum number of consecutive 1's in the array.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,1,0,1,1,1]
   * Output: 3
   * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum
   * number of consecutive 1s is 3.
   * Example 2:
   * <p>
   * Input: nums = [1,0,1,1,0,1]
   * Output: 2
   */

  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
  }

  /**
   * Time Complexity: O(N) since the solution involves only a single pass.
   * <p>
   * Space Complexity: O(1) because no extra space is used.
   *
   * @param nums
   *
   * @return
   */
  public static int findMaxConsecutiveOnes(int[] nums) {
    int noOfOnes = 0;
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 1) {
        noOfOnes++;
        max = Math.max(max, noOfOnes);
      } else {
        noOfOnes = 0;
      }
    }
    return max;
  }
}
