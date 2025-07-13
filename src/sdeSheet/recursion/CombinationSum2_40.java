package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2_40 {

  // https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/

  /**
   * Given a collection of candidate numbers (candidates) and a target number (target), find all
   * unique combinations in candidates where the candidate numbers sum to target.
   * <p>
   * Each number in candidates may only be used once in the combination.
   * <p>
   * Note: The solution set must not contain duplicate combinations.
   * <p>
   * Example 1:
   * <p>
   * Input: candidates = [10,1,2,7,6,1,5], target = 8
   * Output:
   * [
   * [1,1,6],
   * [1,2,5],
   * [1,7],
   * [2,6]
   * ]
   * Example 2:
   * <p>
   * Input: candidates = [2,5,2,1,2], target = 5
   * Output:
   * [
   * [1,2,2],
   * [5]
   * ]
   */

  public static void main(String[] args) {
    System.out.println(combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println();
    System.out.println(combinationSum2Optimised(
        new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 27));
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    HashSet<List<Integer>> combinationList = new HashSet<>();
    combination(0, candidates, target, new ArrayList<>(), combinationList);
    return new ArrayList<>(combinationList);
  }

  public static List<List<Integer>> combinationSum2Optimised(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> combinationList = new ArrayList<>();
    combination(0, target, candidates, new ArrayList<>(), combinationList);
    return combinationList;
  }

  /**
   * Can refer combinationSum1 for better idea
   *
   * @param index
   * @param candidates
   * @param target
   * @param canSum
   * @param combinationList
   */
  public static void combination(int index, int[] candidates, int target, List<Integer> canSum,
      HashSet<List<Integer>> combinationList) {
    // Base condition
    if (index == candidates.length) {
      if (target == 0) {
        List<Integer> add = new ArrayList<>(canSum);
        Collections.sort(add);
        combinationList.add(add);
      }
      return;
    }
    if (target >= candidates[index]) {
      canSum.add(candidates[index]);
      combination(index + 1, candidates, target - candidates[index], canSum, combinationList);
      canSum.remove(canSum.size() - 1);
    }
    combination(index + 1, candidates, target, canSum, combinationList);
  }

  /**
   * Time Complexity:O(2^n*k)
   * <p>
   * Reason: Assume if all the elements in the array are unique then the no. of subsequence you
   * will get will be O(2^n). we also add the ds to our ans when we reach the base case that will
   * take “k”//average space for the ds.
   * <p>
   * Space Complexity:O(k*x)
   * <p>
   * Reason: if we have x combinations then space will be x*k where k is the average length of
   * the combination.
   *
   * @param index
   * @param target
   * @param candidates
   * @param canSum
   * @param combinationList
   */
  public static void combination(int index, int target, int[] candidates, List<Integer> canSum,
      List<List<Integer>> combinationList) {
    // Base condition
    if (target == 0) {
      combinationList.add(new ArrayList<>(canSum));
      return;
    }
    // Can pick from index to n-1 for combinations
    for (int i = index; i < candidates.length; i++) {
      // Here ignore adjacent similar values to avoid duplicates to form combination
      if (i > index && candidates[i] == candidates[i - 1]) {
        continue;
      }
      /* If candidate is greater than target break that recursion tree at that node because
      further it is not possible to form combinations */
      if (target < candidates[i]) {
        break;
      }
      canSum.add(candidates[i]);
      combination(i + 1, target - candidates[i], candidates, canSum, combinationList);
      // backtrack
      canSum.remove(canSum.size() - 1);
    }
  }
}
