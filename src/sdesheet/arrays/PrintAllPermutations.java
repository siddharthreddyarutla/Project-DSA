package sdesheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {

  /**
   * Finding all possible permutations.
   * <p>
   * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,
   * 3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
   */

  public static void main(String[] args) {
    int[] nums = new int[3];
    nums[0] = 1;
    nums[1] = 2;
    nums[2] = 3;

    int[] temp = new int[5];
    temp[0] = 1;
    temp[1] = 2;
    temp[2] = 3;
    temp[3] = 4;
    temp[4] = 5;
    System.out.println(printAllPermutations(nums));
    //            System.out.println(printAllPermutations(temp));
  }

  /**
   * time complexity is n!*n
   * space n!
   *
   * @param nums
   *
   * @return
   */
  public static List<List<Long>> printAllPermutations(int[] nums) {
    List<List<Long>> permutations = new ArrayList<>();
    possiblePermutations(0, nums.length, nums, permutations);
    return permutations;
  }

  private static void possiblePermutations(int index, int n, int[] nums,
      List<List<Long>> permutations) {
    if (index == n - 1) {
      List<Long> temp = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        temp.add((long) nums[i]);
      }
      permutations.add(temp);
      return;
    }
    for (int i = index; i < n; i++) {
      swap(index, i, nums);
      possiblePermutations(index + 1, n, nums, permutations);
      swap(index, i, nums);
    }
  }

  public static void swap(int index, int i, int[] nums) {
    int temp = nums[index];
    nums[index] = nums[i];
    nums[i] = temp;
  }
}

