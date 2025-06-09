package basicMath;

import java.util.Scanner;

public class CountDigits {

  /**
   * Example 1:
   * Input:N = 12345
   * Output:5
   * Explanation:  The number 12345 has 5 digits.
   * Example 2:
   * Input:N = 7789
   * Output: 4
   * Explanation: The number 7789 has 4 digits.
   */


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();
    System.out.print(countDigits(n));
    System.out.println();
    System.out.print(countDigitsOptimized(n));
  }

  /**
   * Brute force approach
   * <p>
   * Time Complexity: O(log10N + 1) where N is the input number. The time complexity is determined
   * by the number of digits in the input integer N. In the worst case when N is a multiple of 10
   * the number of digits in N is log10N + 1.
   * <p>
   * <p>
   * In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
   * In each iteration of the while loop we perform constant time operations like division and
   * increment the counter.
   * Space Complexity : O(1) as only a constant amount of additional memory for the counter
   * regardless of size of the input number.
   *
   * @param n
   *
   * @return
   */
  public static int countDigits(int n) {
    int count = 0;
    while (n > 0) {
      n /= 10;
      count++;
    }
    return count;
  }

  /**
   * Time Complexity: O(1)as simple arithmetic operations in constant time are computed on integers.
   * Space Complexity : O(1)as only a constant amount of additional memory for the count variable
   * regardless of size of the input number.
   */
  public static int countDigitsOptimized(int n) {
    return (int) Math.log10(n) + 1;
  }
}
