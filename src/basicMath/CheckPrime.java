package basicMath;

import java.util.Scanner;

public class CheckPrime {

  /**
   * A prime number is a positive integer that is divisible by exactly 2 integers, 1 and the
   * number itself.
   * <p>
   * You are given a number 'n'.
   * <p>
   * Find out whether 'n' is prime or not.
   * <p>
   * Example :
   * Input: 'n' = 5
   * <p>
   * Output: YES
   * <p>
   * Explanation: 5 is only divisible by 1 and 5. 2, 3 and 4 do not divide 5.
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    scanner.close();
    System.out.print(isPrime(num));
  }


  /**
   * Time Complexity: O(N) where N is the input number as we iterate from 1 to N performing
   * constant-time operation for each iteration.
   * <p>
   * Space Complexity : O(1) as the space used by the algorithm does not increase with the size
   * of the input.
   *
   * @param num
   *
   * @return
   */
  public static boolean isPrime(int num) {
    if (num == 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    int iterator = 2;
    while (iterator < num) {
      if (num % iterator == 0) {
        return false;
      }
      iterator++;
    }
    return true;
  }


  /**
   * We can optimise the algorithm by only iterating up to the square root of n when checking for
   * factors.
   * This is because if n has a factor greater than its square root, it must also have a factor
   * smaller than its square root.
   * <p>
   * Time Complexity: O(sqrt(N))where N is the input number. The loop iterates up to the square
   * root of n performing constant time operations at each step.
   * <p>
   * Space Complexity : O(1) as the space complexity remains constant and independent of the
   * input size. Only a fixed amount of memory is required to store the integer variables.
   *
   * @param num
   *
   * @return
   */
  public static boolean isPrimeOptimized(int num) {
    if (num == 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    int iterator = 2;
    while (iterator < Math.sqrt(num)) {
      if (num % iterator == 0) {
        return false;
      }
      iterator++;
    }
    return true;
  }
}
