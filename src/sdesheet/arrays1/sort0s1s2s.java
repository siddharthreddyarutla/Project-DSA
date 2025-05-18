package sdesheet.arrays1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort0s1s2s {

  //  https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/

  /**
   * Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to
   * in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N)
   * and constant space)
   * <p>
   * Examples
   * Input: nums = [2,0,2,1,1,0]
   * Output: [0,0,1,1,2,2]
   * <p>
   * Input: nums = [2,0,1]
   * Output: [0,1,2]
   * <p>
   * Input: nums = [0]
   * Output: [0]
   */


  public static void main(String[] args) {
    System.out.println(sort0s1s2sBetter(new int[] {2, 0, 2, 1, 1, 0}));
    System.out.println(sort0s1s2sBetter(new int[] {2, 0, 1}));
    int[] temp = {2, 0, 1};
    sort(temp);
    System.out.println(Arrays.toString(temp));
    int[] temp1 = {2, 0, 2, 1, 1, 0};
    sort0s1s2sOptimal(temp1);
    System.out.println(Arrays.toString(temp1));
  }

  /**
   * Time Complexity: O(N*logN)
   * Space Complexity: O(1)
   *
   * @param nums
   *
   * @return
   */
  public static void sort(int[] nums) {
    Arrays.sort(nums); // in place
    int[] sorted = Arrays.stream(nums).sorted().toArray(); // new array created on sort
  }

  /**
   * Time Complexity: O(N) + O(N), where N = size of the array. First O(N) for counting the
   * number of 0’s, 1’s, 2’s, and second O(N) for placing them correctly in the original array.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param nums
   *
   * @return
   */
  public static List<Long> sort0s1s2sBetter(int[] nums) {

    int zeros = 0;
    int ones = 0;
    int twos = 0;
    List<Long> ans = new ArrayList<>(nums.length);
    for (int num : nums) {
      if (num == 0) {
        zeros++;
      } else if (num == 1) {
        ones++;
      } else {
        twos++;
      }
    }
    while (zeros > 0) {
      ans.add(0L);
      zeros--;
    }
    while (ones > 0) {
      ans.add(1L);
      ones--;
    }
    while (twos > 0) {
      ans.add(2L);
      twos--;
    }
    return ans;
  }

  /**
   * Using DUTCH NATIONAL FLAG ALGO
   * Time Complexity: O(N), where N = size of the given array.
   * Reason: We are using a single loop that can run at most N times.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param nums
   */
  public static void sort0s1s2sOptimal(int[] nums) {
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {
      if (nums[mid] == 0) {
        PrintAllPermutations.swap(low, mid, nums);
        low++;
        mid++;
      } else if (nums[mid] == 1) {
        mid++;
      } else {
        PrintAllPermutations.swap(high, mid, nums);
        high--;
      }
    }
  }
}
