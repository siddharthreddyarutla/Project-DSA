package sdeSheet.greedyAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumNumberOfCoins {

  // https://takeuforward.org/data-structure/find-minimum-number-of-coins/

  /**
   * Problem Statement: Given a value V, if we want to make a change for V Rs, and we have an
   * infinite supply of each of the denominations in Indian currency, i.e., we have an infinite
   * supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum
   * number of coins and/or notes needed to make the change.
   * <p>
   * Examples:
   * Example 1:
   * Input: V = 70
   * Output: 2
   * Explaination: We need a 50 Rs note and a 20 Rs note.
   * <p>
   * Example 2:
   * Input: V = 121
   * Output: 3
   * Explaination: We need a 100 Rs note, a 20 Rs note and a 1 Rs coin.
   */

  public static void main(String[] args) {
    System.out.println(minPartition(43));
    System.out.println(minPartition(1000));
    System.out.println(minPartition(70));
    System.out.println(minPartition(121));
    System.out.println(minPartitionCount(121));
  }

  /**
   * Time Complexity:O(V)
   * Space Complexity:O(1)
   *
   * @param N
   *
   * @return
   */
  public static List<Integer> minPartition(int N) {
    int[] currency = new int[] {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    int i = currency.length - 1;
    List<Integer> min = new ArrayList<>();
    while (i >= 0) {
      if (N >= currency[i]) {
        min.add(currency[i]);
        N -= currency[i];
      } else {
        i--;
      }
    }
    return min;
  }

  public static int minPartitionCount(int N) {
    int[] currency = new int[] {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};

    int i = currency.length - 1;
    int min = 0;
    while (i >= 0) {
      if (N >= currency[i]) {
        min++;
        N -= currency[i];
      } else {
        i--;
      }
    }
    return min;
  }
}


