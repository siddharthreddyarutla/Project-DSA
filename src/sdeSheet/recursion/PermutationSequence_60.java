package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class PermutationSequence_60 {

  // https://takeuforward.org/data-structure/find-k-th-permutation-sequence/

  /**
   * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
   * <p>
   * By listing and labeling all of the permutations in order, we get the following sequence for
   * n = 3:
   * <p>
   * "123"
   * "132"
   * "213"
   * "231"
   * "312"
   * "321"
   * Given n and k, return the kth permutation sequence.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: n = 3, k = 3
   * Output: "213"
   * Example 2:
   * <p>
   * Input: n = 4, k = 9
   * Output: "2314"
   */


  public static void main(String[] args) {
    System.out.println(getPermutation(3, 3));
    System.out.println(getPermutationOptimized(4, 17));
  }

  /**
   * Time complexity: O(N! * N) +O(N! Log N!)
   * <p>
   * Reason:  The recursion takes O(N!)  time because we generate every possible permutation and
   * another O(N)  time is required to make a deep copy and store every sequence in the data
   * structure. Also, O(N! Log N!)  time required to sort the data structure
   * <p>
   * Space complexity: O(N)
   * <p>
   * Reason: Result stored in a vector, we are auxiliary space taken by recursion
   *
   * @param n
   * @param k
   *
   * @return
   */
  public static String getPermutation(int n, int k) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      stringBuilder.append(i);
    }
    HashSet<String> sequenceSet = new HashSet<>();
    permutations(stringBuilder.toString(), 0, sequenceSet);
    List<String> sequenceList = new ArrayList<>(sequenceSet);
    Collections.sort(sequenceList);
    return sequenceList.get(k - 1);
  }

  public static void permutations(String s, int index, HashSet<String> list) {
    if (index == s.length() - 1) {
      list.add(s);
      return;
    }
    for (int i = 0; i < s.length(); i++) {
      s = swap(index, i, s);
      permutations(s, index + 1, list);
      s = swap(index, i, s);
    }
  }

  public static String swap(int index, int i, String s) {
    StringBuilder sb = new StringBuilder(s);
    char temp = sb.charAt(index);
    sb.setCharAt(index, sb.charAt(i));
    sb.setCharAt(i, temp);
    return sb.toString();
  }

  /**
   * Time Complexity: O(N) * O(N) = O(N^2)
   * <p>
   * Reason: We are placing N numbers in N positions. This will take O(N) time. For every number,
   * we are reducing the search space by removing the element already placed in the previous step
   * . This takes another O(N) time.
   * <p>
   * Space Complexity: O(N)
   * <p>
   * Reason: We are storing  the numbers in a data structure(here vector)
   *
   * @param n
   * @param k
   *
   * @return
   */
  public static String getPermutationOptimized(int n, int k) {
    int fact = 1;
    List<Integer> number = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      number.add(i);
      fact *= i;
    }
    fact /= n;
    k = k - 1;
    StringBuilder s = new StringBuilder();

    while (true) {
      s.append(number.get(k / fact));
      number.remove(k / fact);
      if (number.isEmpty()) {
        break;
      }
      k = k % fact;
      fact /= number.size();
    }
    return s.toString();
  }
}
