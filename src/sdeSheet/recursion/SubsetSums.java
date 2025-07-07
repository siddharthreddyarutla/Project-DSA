package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSums {

  // https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/

  /**
   * Given a array arr of integers, return the sums of all subsets in the list.  Return the sums
   * in any order.
   * <p>
   * Examples:
   * <p>
   * Input: arr[] = [2, 3]
   * Output: [0, 2, 3, 5]
   * Explanation: When no elements are taken then Sum = 0. When only 2 is taken then Sum = 2.
   * When only 3 is taken then Sum = 3. When elements 2 and 3 are taken then Sum = 2+3 = 5.
   * Input: arr[] = [1, 2, 1]
   * Output: [0, 1, 1, 2, 2, 3, 3, 4]
   * Explanation: The possible subset sums are 0 (no elements), 1 (either of the 1's), 2 (the
   * element 2), and their combinations.
   * Input: arr[] = [5, 6, 7]
   * Output: [0, 5, 6, 7, 11, 12, 13, 18]
   * Explanation: The possible subset sums are 0 (no elements), 5, 6, 7, and their combinations.
   */

  public static void main(String[] args) {
    System.out.println(subsetSums(new int[] {1, 2, 1}));
    System.out.println(subsetSums(new int[] {5, 6, 7}));
    System.out.println();
    System.out.println(subsetSumsMutation(new int[] {1, 2, 1}));
    System.out.println(subsetSumsMutation(new int[] {5, 6, 7}));
  }

  public static List<Integer> subsetSums(int[] arr) {
    // code here
    List<Integer> list = new ArrayList<>();
    subsetSum(0, arr, list, 0);
    return list;
  }

  public static List<Integer> subsetSumsMutation(int[] arr) {
    // code here
    List<Integer> list = new ArrayList<>();
    subsetSumWithoutMutation(0, arr, list, 0);
    return list;
  }

  /**
   * Algo:
   *
   * For each element in the array, you have 2 choices:
   *
   * Include the element in the current subset.
   *
   * Exclude the element from the current subset.
   */

  /**
   * Base case index == arr.length	You’ve considered every element, so the running total sum
   * equals the sum of one particular subset. You push it into list.
   * <p>
   * Include branch	sum += arr[index] adds the current element, then you recurse to the next index.
   * <p>
   * Exclude branch	You undo the addition (sum -= arr[index]) and recurse again, effectively
   * skipping the element. Because sum is a local primitive, each call has its own copy, so
   * there’s no cross‑call interference.
   *
   * @param index
   * @param arr
   * @param list
   * @param sum
   */
  public static void subsetSum(int index, int[] arr, List<Integer> list, int sum) {
    if (index == arr.length) {
      list.add(sum);
      return;
    }
    // Include the element
    sum += arr[index];
    subsetSum(index + 1, arr, list, sum);

    // Reverse back to retain the original state
    sum -= arr[index];
    subsetSum(index + 1, arr, list, sum);
  }

  /**
   * Time Complexity: O(2^n). Each index has two ways. You can either pick it up
   * or not pick it. So for n index time complexity for O(2^n)
   * <p>
   * Space Complexity: O(2^n) for storing subset sums, since 2^n subsets can be generated for an
   * array of size n.
   *
   * @param index
   * @param arr
   * @param list
   * @param sum
   */
  public static void subsetSumWithoutMutation(int index, int[] arr, List<Integer> list, int sum) {
    if (index == arr.length) {
      list.add(sum);
      return;
    }
    // Include the element
    subsetSumWithoutMutation(index + 1, arr, list, sum + arr[index]);

    // Exclude the element
    subsetSumWithoutMutation(index + 1, arr, list, sum);
  }
}

