package basicmath;

import java.util.Arrays;

public class LCMAndHCF {

  /**
   * Given two integers a and b, the task is to compute their LCM and GCD and return an array
   * containing their LCM and GCD.
   * <p>
   * Examples:
   * <p>
   * Input: a = 5 , b = 10
   * Output: [10, 5]
   * Explanation: LCM of 5 and 10 is 10, while their GCD is 5.
   * <p>
   * Input: a = 14 , b = 8
   * Output: [56, 2]
   * Explanation: LCM of 14 and 8 is 56, while their GCD is 2.
   * <p>
   * Input: a = 1 , b = 1
   * Output: [1, 1]
   * Explanation: LCM of 1 and 1 is 1, while their GCD is 1.
   */


  public static void main(String[] args) {
    System.out.print(Arrays.toString(lcmAndGcd(60, 16)));
    System.out.println();
    System.out.print(Arrays.toString(lcmAndGcdROptimized(60, 16)));
  }

  /**
   * Time Complexity: O(min(N1, N2)) where N1 and N2 is the input number. The algorithm iterates
   * from
   * the minimum of N1 and N2 to 1 and each iteration checks whether both the numbers are
   * divisible by the current number (constant time operations).
   * <p>
   * Space Complexity: O(1) as the space complexity remains constant and independent of the input
   * size.
   * Only a fixed amount of memory is required to store the integer variables.
   *
   * @param a
   * @param b
   *
   * @return
   */
  public static int[] lcmAndGcd(int a, int b) {
    int lcm = findLCM(a, b);
    int gcd = findGCD(a, b);
    return new int[] {lcm, gcd};
  }

  /**
   * Iterate from the minimum of n1 and n2 because the greatest common divisor of two numbers cannot
   * exceed the smaller number.
   */
  private static int findGCD(int a, int b) {
    int iterator = Math.min(a, b);
    while (!(a % iterator == 0 && b % iterator == 0)) {
      iterator--;
    }
    return iterator;
  }

  private static int findLCM(int a, int b) {
    int iterator = Math.max(a, b);
    while (!(iterator % a == 0 && iterator % b == 0)) {
      iterator++;
    }
    return iterator;
  }


  public static int[] lcmAndGcdROptimized(int a, int b) {
    int gcd = findGCDOptimized(a, b);
    return new int[] {findLCMOptimized(a, b, gcd), gcd};
  }


  /**
   * The formula to calculate the LCM of two numbers, a and b, is: `LCM(a, b) = (a * b) / GCD(a, b)
   *
   * @param a
   * @param b
   * @param gcd
   *
   * @return
   */
  public static int findLCMOptimized(int a, int b, int gcd) {
    return (a * b) / gcd;
  }

  /**
   * The Euclidean Algorithm is a method for finding the greatest common divisor of two numbers.
   * It operates on the principle that the GCD of two numbers remains the same even if the
   * smaller number is subtracted from the larger number.
   * <p>
   * To find the GCD of n1 and n2 where n1 > n2:
   * <p>
   * Repeatedly subtract the smaller number from the larger number until one of them becomes 0.
   * Once one of them becomes 0, the other number is the GCD of the original numbers.
   *
   * @param a
   * @param b
   *
   * @return
   */
  public static int findGCDOptimized(int a, int b) {
    if (a == 0 || b == 0) {
      return Math.max(a, b);
    }
    if (a > b) {
      a = a - b;
    } else {
      b = b - a;
    }
    return findGCDOptimized(a, b);
  }
}
