package basicmath;


public class ArmstrongNumber {

  /**
   * Problem statement
   * You are given an integer 'n'. Return 'true' if 'n' is an Armstrong number, and 'false'
   * otherwise.
   * <p>
   * An Armstrong number is a number (with 'k' digits) such that the sum of its digits raised to
   * 'kth' power is equal to the number itself. For example, 371 is an Armstrong number because
   * 3^3 + 7^3 + 1^3 = 371.
   * <p>
   * Detailed explanation ( Input/output format, Notes, Images )
   * Sample Input 1 :
   * 1
   * <p>
   * Sample Output 1 :
   * true
   * <p>
   * Explanation of Sample Input 1 :
   * 1 is an Armstrong number as, 1^1 = 1.
   * <p>
   * Sample Input 2 :
   * 103
   * <p>
   * Sample Output 2 :
   * false
   * <p>
   * Sample Input 3 :
   * 1634
   * <p>
   * Sample Output 3 :
   * true
   * <p>
   * Explanation of Sample Input 3 :
   * 1634 is an Armstrong number, as 1^4 + 6^4 + 3^4 + 4^4 = 1634
   */

  public static void main(String[] args) {
    System.out.print(isArmstrongNumber(1634));
  }


  /**
   * Time Complexity: O(log10N + 1) where N is the input number. The time complexity is
   * determined
   * by the number of digits in the input integer N. In the worst case when N is a multiple of 10
   * the number of digits in N is log10 N + 1.
   * <p>
   * In the while loop we divide N by 10 until it becomes 0 which takes log10N iterations.
   * In each iteration of the while loop we perform constant time operations like modulus and
   * division
   * and pushing elements into the vector.
   * <p>
   * Space Complexity: O(1) as only a constant amount of additional memory for the reversed number
   * regardless of size of the input number.
   *
   * @param n
   *
   * @return
   */
  public static boolean isArmstrongNumber(int n) {
    int digitCount = CountDigits.countDigitsOptimized(n);
    int actualN = n;
    int sum = 0;
    while (n > 0) {
      int digit = n % 10;
      n = n / 10;
      sum += (int) Math.pow(digit, digitCount);
    }
    return sum == actualN;
  }
}
