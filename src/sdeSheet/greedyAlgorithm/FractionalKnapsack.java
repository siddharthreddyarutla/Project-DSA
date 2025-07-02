package sdeSheet.greedyAlgorithm;

import utils.GenericUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

  // https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/

  /**
   * Given two arrays, val[] and wt[], representing the values and weights of items, and an
   * integer capacity representing the maximum weight a knapsack can hold, determine the maximum
   * total value that can be achieved by putting items in the knapsack. You are allowed to break
   * items into fractions if necessary.
   * Return the maximum value as a double, rounded to 6 decimal places.
   * <p>
   * Examples :
   * <p>
   * Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50
   * Output: 240.000000
   * Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split
   * the third item with value 120 and weight 30, to fit it into weight 20. so it becomes
   * (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of
   * item we can have is 240.00 from the given capacity of sack.
   * Input: val[] = [60, 100], wt[] = [10, 20], capacity = 50
   * Output: 160.000000
   * Explanation: Take both the items completely, without breaking. Total maximum value of item
   * we can have is 160.00 from the given capacity of sack.
   * Input: val[] = [10, 20, 30], wt[] = [5, 10, 15], capacity = 100
   * Output: 60.000000
   * Explanation: In this case, the knapsack capacity exceeds the combined weight of all items (5
   * + 10 + 15 = 30). Therefore, we can take all items completely, yielding a total maximum value
   * of 10 + 20 + 30 = 60.000000.
   */

  public static void main(String[] args) {
    System.out.println(fractionalKnapsack(new int[] {60, 100, 120}, new int[] {10, 20, 30}, 50));
    System.out.println();
    System.out.println(fractionalKnapsack(new int[] {8, 2, 10, 1, 9, 7, 2, 6, 4, 9},
        new int[] {10, 1, 7, 7, 5, 1, 8, 6, 8, 7}, 21));
  }

  /**
   * Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through
   * all the items for calculating the answer.
   * <p>
   * Space Complexity: O(1), no additional data structure has been used.
   *
   * @param values
   * @param weights
   * @param W
   *
   * @return
   */
  public static double fractionalKnapsack(int[] values, int[] weights, int W) {
    List<GenericUtils.Pair<Integer, Integer>> list = new ArrayList<>();
    for (int i = 0; i < values.length; i++) {
      GenericUtils.Pair<Integer, Integer> pair = new GenericUtils.Pair<>(values[i], weights[i]);
      list.add(pair);
    }
    list.sort((a, b) -> Double.compare((double) b.first / b.second, (double) a.first / a.second));
    double res = 0;
    int i = 0;
    while (W > 0 && i < values.length) {
      GenericUtils.Pair<Integer, Integer> pair = list.get(i);
      if (W >= pair.second) {
        res += pair.first;
        W -= pair.second;
      } else {
        res += ((double) pair.first / pair.second) * W;
        W = 0;
      }
      i++;
    }
    return res;
  }
}
