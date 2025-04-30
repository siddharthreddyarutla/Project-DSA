package sdesheet.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

  /**
   * A permutation of an array of integers is an arrangement of its members into a sequence or
   * linear order.
   * <p>
   * For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,
   * 3,2],
   * [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
   * The next permutation of an array of integers is the next lexicographically greater
   * permutation of
   * its integer. More formally, if all the permutations of the array are sorted in one container
   * according to their lexicographical order, then the next permutation of that array is the
   * permutation that follows it in the sorted container. If such arrangement is not possible, the
   * array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
   * <p>
   * For example, the next permutation of arr = [1,2,3] is [1,3,2].
   * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
   * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a
   * lexicographical larger rearrangement.
   */

  public static void main(String[] args) {
    int[] temp = {3, 2, 1};

    int[] temp1 = {1, 2, 3, 6, 5, 4};

    int[] temp3 = {2, 3, 1};
    System.out.println(nextPermutation(temp));
    nextPermutationOptimized(temp1);
    System.out.println(Arrays.toString(temp1));
    nextPermutationOptimized(temp3);
    System.out.println(Arrays.toString(temp3));
  }

  /**
   * Brute force
   * Time complexity = n! * n
   *
   * @param nums
   *
   * @return
   */
  private static List<Long> nextPermutation(int[] nums) {
    List<Long> numsList = new ArrayList<>();
    for (int num : nums) {
      numsList.add((long) num);
    }
    boolean nextPermutationFound = false;
    List<List<Long>> permutations =
        PrintAllPermutations.printAllPermutations(Arrays.stream(nums).sorted().toArray());
    for (List<Long> permutation : permutations) {
      if (nextPermutationFound) {
        return permutation;
      }
      if (permutation.equals(numsList)) {
        nextPermutationFound = true;
      }
    }
    return permutations.get(0);
  }

  public static void nextPermutationOptimized(int[] nums) {
    int pivot = -1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
      }
    }
    if (pivot == -1) {
      reverseArray(nums, 0, nums.length - 1);
      return;
    }
    for (int i = nums.length - 1; i > pivot; i--) {
      if (nums[i] > nums[pivot]) {
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = temp;
        break;
      }
    }
    reverseArray(nums, pivot + 1, nums.length - 1);
  }

  public static void reverseArray(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
