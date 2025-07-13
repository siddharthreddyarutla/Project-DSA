package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CombinationSum1_39 {

  // https://takeuforward.org/data-structure/combination-sum-1/

  /**
   * Given an array of distinct integers candidates and a target integer target, return a list of
   * all unique combinations of candidates where the chosen numbers sum to target. You may return
   * the combinations in any order.
   * <p>
   * The same number may be chosen from candidates an unlimited number of times. Two combinations
   * are unique if the frequency of at least one of the chosen numbers is different.
   * <p>
   * The test cases are generated such that the number of unique combinations that sum up to
   * target is less than 150 combinations for the given input.
   * <p>
   * Example 1:
   * <p>
   * Input: candidates = [2,3,6,7], target = 7
   * Output: [[2,2,3],[7]]
   * Explanation:
   * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
   * 7 is a candidate, and 7 = 7.
   * These are the only two combinations.
   * Example 2:
   * <p>
   * Input: candidates = [2,3,5], target = 8
   * Output: [[2,2,2,2],[2,3,3],[3,5]]
   * Example 3:
   * <p>
   * Input: candidates = [2], target = 1
   * Output: []
   */

  public static void main(String[] args) {
    System.out.println(combinationSum(new int[] {2, 3, 6, 7}, 7));
    System.out.println();
    System.out.println(combinationSum1(new int[] {2, 3, 6, 7}, 7));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> combinationList = new ArrayList<>();
    combination(0, candidates, target, new ArrayList<>(), combinationList);
    return combinationList;
  }

  public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
    List<List<Integer>> combinationList = new ArrayList<>();
    combination(0, candidates, target, new ArrayList<>(), combinationList);
    return combinationList;
  }

  /**
   * Time Complexity: O(2^t * k) where t is the target, k is the average length
   * <p>
   * Reason: Assume if you were not allowed to pick a single element multiple times, every
   * element will have a couple of options: pick or not pick which is 2^n different recursion
   * calls, also assuming that the average length of every combination generated is k. (to put
   * length k data structure into another data structure)
   * <p>
   * Why not (2^n) but (2^t) (where n is the size of an array)?
   * <p>
   * Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or
   * not pick” an element.
   * <p>
   * Space Complexity: O(k*x), k is the average length and x is the no. of combinations
   *
   * @param index
   * @param candidates
   * @param target
   * @param canSum
   * @param combinationList
   */
  public static void combination(int index, int[] candidates, int target, List<Integer> canSum,
      List<List<Integer>> combinationList) {
    // Base condition
    if (index == candidates.length) {
      // If index is reached and target became zero then found the candidate sum
      if (target == 0) {
        combinationList.add(canSum);
      }
      return;
    }
    /* If candidate is equal and less than then decrement target and pick but instead going next
    as one candidate can be picked unlimited times don't increment*/
    if (target >= candidates[index]) {
      combination(index, candidates, target - candidates[index],
          Stream.concat(canSum.stream(), Stream.of(candidates[index])).toList(), combinationList);
    }
    /* Not pick case increment the index and do nothing */
    combination(index + 1, candidates, target, canSum, combinationList);
  }

  /**
   * A bit of performance improvement without streams
   *
   * @param index
   * @param candidates
   * @param target
   * @param canSum
   * @param combinationList
   */
  public static void combinationWithoutStream(int index, int[] candidates, int target,
      List<Integer> canSum, List<List<Integer>> combinationList) {
    // Base condition
    if (index == candidates.length) {
      // If index is reached and target became zero then found the candidate sum
      if (target == 0) {
        combinationList.add(canSum);
      }
      return;
    }
    /* If candidate is equal and less than then decrement target and pick but instead going next
    as one candidate can be picked unlimited times don't increment*/
    if (target >= candidates[index]) {
      /* We mutate it in‑place (add before the recursive call, remove after) so we don’t allocate
       a new list at every level. */
      canSum.add(candidates[index]);
      combination(index, candidates, target - candidates[index], canSum, combinationList);
      canSum.remove(canSum.size() - 1);
    }
    /* Not pick case increment the index and do nothing */
    combination(index + 1, candidates, target, canSum, combinationList);
  }
}
