package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Subsets2_90 {

  // https://takeuforward.org/data-structure/subset-ii-print-all-the-unique-subsets/

  /**
   * Given an integer array nums that may contain duplicates, return all possible subsets (the
   * power set).
   * <p>
   * The solution set must not contain duplicate subsets. Return the solution in any order.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [1,2,2]
   * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
   * Example 2:
   * <p>
   * Input: nums = [0]
   * Output: [[],[0]]
   */

  public static void main(String[] args) {

  }

  public static List<List<Integer>> subsetsWithDup(int[] nums) {
    HashSet<List<Integer>> subsetList = new HashSet<>();
    subsets(0, nums, new ArrayList<>(), subsetList);
    return new ArrayList<>(subsetList);
  }

  /**
   * Time Complexity: O(2^n) for generating every subset and O(k)  to insert every subset in
   * another data structure if the average length of every subset is k. Overall O(k * 2^n).
   * <p>
   * Space Complexity: O(2^n * k) to store every subset of average length k. Auxiliary space is O
   * (n)  if n is the depth of the recursion tree.
   *
   * @param index
   * @param nums
   * @param subsets
   * @param subsetList
   */
  public static void subsets(int index, int[] nums, List<Integer> subsets,
      HashSet<List<Integer>> subsetList) {
    if (index == nums.length) {
      List<Integer> copy = new ArrayList<>(subsets);
      Collections.sort(copy);
      subsetList.add(new ArrayList<>(copy));
      return;
    }
    subsets.add(nums[index]);
    subsets(index + 1, nums, subsets, subsetList);
    subsets.remove(subsets.size() - 1);
    subsets(index + 1, nums, subsets, subsetList);
  }

  public static void subsets(int index, int[] nums, List<Integer> subsets,
      List<List<Integer>> subsetList) {
    subsetList.add(new ArrayList<>(subsets));
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) {
        continue;
      }
      subsets.add(nums[i]);
      subsets(i + 1, nums, subsets, subsetList);
      subsets.remove(subsets.size() - 1);
    }
  }
}
