package basicmath;

public class ReverseNumber {

  /**
   * Reverse Digits of A Number
   * <p>
   * Problem Statement: Given an integer N return the reverse of the given number.
   * <p>
   * Note: If a number has trailing zeros, then its reverse will not include them. For e.g.,
   * reverse of 10400 will be 401 instead of 00401.
   * <p>
   * Examples
   * Example 1:
   * Input:N = 12345
   * Output:54321
   * Explanation: The reverse of 12345 is 54321.
   * Example 2:
   * Input:N = 7789
   * Output: 9877
   * Explanation: The reverse of number 7789 is 9877.
   */

  public static void main(String[] args) {
    System.out.print(reverseNumber(-1230));
  }

  /**
   * Brute force approach
   * Time Complexity: O(log10N + 1) where N is the input number. The time complexity is
   * determined by
   * the number of digits in the input integer N. In the worst case when N is a multiple of 10
   * the number of digits in N is log10 N + 1.
   * <p>
   * In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
   * In each iteration of the while loop we perform constant time operations like modulus and
   * division and pushing elements into the vector.
   * Space Complexity: O(1) as only a constant amount of additional memory for the reversed
   * number regardless of size of the input number.
   *
   * @param n
   *
   * @return
   */
  public static int reverseNumber(int n) {
    boolean isNegative = false;
    if (n < 0) {
      isNegative = true;
      n = Math.abs(n);
    }
    int reversedNumber = 0;
    while (n > 0) {
      int lastDigit = n % 10;
      n /= 10;
      reversedNumber = reversedNumber * 10 + lastDigit;
    }
    return isNegative ? -reversedNumber : reversedNumber;
  }

  public static int reverseNumberOptimized(int n) {
    int reversed = 0;

    while (n != 0) {
      int digit = n % 10;
      n /= 10;
      // Check for overflow
      if (reversed > Integer.MAX_VALUE / 10 || reversed < Integer.MIN_VALUE / 10) {
        return 0;
      }
      reversed = reversed * 10 + digit;
    }
    return reversed;
  }
}
