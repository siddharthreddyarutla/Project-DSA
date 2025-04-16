package basicmath;

public class SumOfNDivisors {

  /**
   * Given a positive integer n, The task is to find the value of Σi F(i) where i is from 1 to n
   * and function F(i) is defined as the sum of all divisors of i.
   * <p>
   * Examples:
   * <p>
   * Input: n = 4
   * Output: 15
   * Explanation:
   * F(1) = 1
   * F(2) = 1 + 2 = 3
   * F(3) = 1 + 3 = 4
   * F(4) = 1 + 2 + 4 = 7
   * So, F(1) + F(2) + F(3) + F(4)
   * = 1 + 3 + 4 + 7 = 15
   * Input: n = 5
   * Output: 21
   * Explanation:
   * F(1) = 1
   * F(2) = 1 + 2 = 3
   * F(3) = 1 + 3 = 4
   * F(4) = 1 + 2 + 4 = 7
   * F(5) = 1 + 5 = 6
   * So,  F(1) + F(2) + F(3) + F(4) + F(5)
   * = 1 + 3 + 4 + 7 + 6 = 21
   */

  public static void main(String[] args) {
    System.out.print(sumOfDivisors(4));
  }

  /**
   * for (int i = 1; i <= n; i++)  → runs `n` times
   * <p>
   * for (int j = 1; j <= i; j++) → for each `i`, runs `i` times
   * <p>
   * 1 + 2 + 3 + ... + n = n(n + 1)/2 → which is  O(n²)
   * <p>
   * Time Complexity = O(n²)
   * Space Complexity = O(1)
   */
  public static int sumOfDivisors(int n) {
    // code here
    int divisorsSum = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          divisorsSum += j;
        }
      }
    }
    return divisorsSum;
  }
}
