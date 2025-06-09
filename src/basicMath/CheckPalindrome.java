package basicMath;

public class CheckPalindrome {

  /**
   * Given an integer x, return true if x is a palindrome, and false otherwise.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: x = 121
   * Output: true
   * Explanation: 121 reads as 121 from left to right and from right to left.
   * Example 2:
   * <p>
   * Input: x = -121
   * Output: false
   * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
   * Therefore it is not a palindrome.
   * Example 3:
   * <p>
   * Input: x = 10
   * Output: false
   * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
   */

  public static void main(String[] args) {
    System.out.print(isPalindrome(121));
  }

  /**
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
  public static boolean isPalindrome(int n) {

    int originalValue = n;
    int reversedN = 0;
    while (n > 0) {
      int lastDigit = n % 10;
      n /= 10;
      reversedN = reversedN * 10 + lastDigit;
    }
    return reversedN == originalValue;
  }
}