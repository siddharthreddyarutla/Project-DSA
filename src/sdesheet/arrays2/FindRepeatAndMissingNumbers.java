package sdesheet.arrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class FindRepeatAndMissingNumbers {

  // https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/

  /**
   * Problem Statement: You are given a read-only array of N integers with values also in the
   * range [1, N] both inclusive. Each integer appears exactly once except A which appears twice
   * and B which is missing. The task is to find the repeating and missing numbers A and B where
   * A repeats twice and B is missing.
   * <p>
   * Examples
   * <p>
   * Example 1:
   * Input Format:  array[] = {3,1,2,5,3}
   * Result: {3,4)
   * Explanation: A = 3 , B = 4
   * Since 3 is appearing twice and 4 is missing
   * <p>
   * Example 2:
   * Input Format: array[] = {3,1,2,5,4,6,7,5}
   * Result: {5,8)
   * Explanation: A = 5 , B = 8
   * Since 5 is appearing twice and 8 is missing
   */

  public static void main(String[] args) {
    System.out.println(findTwoElement(new int[] {1, 3, 3}));
    System.out.println(findTwoElement(new int[] {4, 3, 6, 2, 1, 1}));
    System.out.println(Arrays.toString(findMissingRepeatingNumbers(new int[] {1, 3, 3})));
    System.out.println(Arrays.toString(findMissingRepeatingNumbers(new int[] {4, 3, 6, 2, 1, 1})));
  }

  /***
   * Time Complexity: O(2N), where N = the size of the given array.
   * Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).
   *
   * Space Complexity: O(N) as we are using a hash array to solve this problem.
   *
   * @param arr
   * @return
   */
  public static ArrayList<Integer> findTwoElement(int arr[]) {
    // code here
    int[] temp = new int[arr.length + 1];
    ArrayList<Integer> misAndRepeatNumbers = new ArrayList<>(arr.length);
    for (int i = 0; i < arr.length; i++) {
      if (temp[arr[i]] > 0) {
        misAndRepeatNumbers.add(arr[i]);
        break;
      }
      temp[arr[i]]++;
    }
    for (int i = 0; i < temp.length; i++) {
      if (temp[i] == 0 && i != 0) {
        misAndRepeatNumbers.add(i);
        break;
      }
    }
    return misAndRepeatNumbers;
  }

  /**
   * Time Complexity: O(N), where N = the size of the given array.
   * Reason: We are using only one loop running for N times. So, the time complexity will be O(N).
   * <p>
   * Space Complexity: O(1) as we are not using any extra space to solve this problem.
   *
   * @param arr
   *
   * @return
   */
  public static int[] findMissingRepeatingNumbers(int[] arr) {

    int n = arr.length;
    int sumOfNNaturalNumbers = (n * (n + 1)) / 2;
    int sumOfPowersOfNNaturalNumbers = (n * (n + 1) * ((2 * n) + 1)) / 6;
    int sn = 0, sn2 = 0;
    for (int num : arr) {
      sn += num;
      sn2 += num * num;
    }
    int value1 = sn - sumOfNNaturalNumbers;   // x - y
    int value2 = sn2 - sumOfPowersOfNNaturalNumbers; // x^2 - y^2
    // (x - y) (x + y ) = value2
    // x - y = value => value2 = value2 / value1;
    value2 = value2 / value1;
    int x = (value1 + value2) / 2;
    int y = value2 - x;
    return new int[] {x, y};
  }
}
