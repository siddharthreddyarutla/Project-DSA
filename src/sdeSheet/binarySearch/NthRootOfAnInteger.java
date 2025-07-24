package sdeSheet.binarySearch;

public class NthRootOfAnInteger {

  // https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/

  /**
   * You are given 2 numbers n and m, the task is to find n√m (nth root of m). If the root is not
   * integer then returns -1.
   * <p>
   * Examples :
   * <p>
   * Input: n = 2, m = 9
   * Output: 3
   * Explanation: 32 = 9
   * Input: n = 3, m = 9
   * Output: -1
   * Explanation: 3rd root of 9 is not integer.
   * Input: n = 1, m = 14
   * Output: 14
   */

  public static void main(String[] args) {
    System.out.println(nthRoot(1, 14));
    System.out.println(nthRootOptimised(1, 14));
  }

  public int mySqrt(int x) {
    return (int) Math.ceil(Math.sqrt(x));
  }
  
  /**
   * Time Complexity: O(M/N), M = the given number.
   * Reason: Since we are using linear search, we traverse the entire answer space.
   * <p>
   * Space Complexity: O(1) as we are not using any extra space.
   *
   * @param n
   * @param m
   *
   * @return
   */
  public static int nthRoot(int n, int m) {
    int x = m / n;
    for (int i = 1; i <= x; i++) {
      if (Math.pow(i, n) == m) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Time Complexity: O(logN), N = size of the given array.
   * Reason: We are basically using binary search to find the minimum.
   * <p>
   * Space Complexity: O(1)
   * Reason: We have not used any extra data structures, this makes space complexity, even in the
   * worst case as O(1).
   *
   * @param n
   * @param m
   *
   * @return
   */
  public static int nthRootOptimised(int n, int m) {
    int low = 1;
    int high = m / n;
    while (low <= high) {
      int mid = (low + high) / 2;
      double power = Math.pow(mid, n);
      if (power == m) {
        return mid;
      } else if (power < m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
