package basicMath;

import java.util.ArrayList;

public class evenlyDivides {

  /**
   * Given a positive integer n, count the number of digits in n that divide n evenly (i.e.,
   * without leaving a remainder). Return the total number of such digits.
   * <p>
   * A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
   * Digits of n should be checked individually. If a digit is 0, it should be ignored because
   * division by 0 is undefined.
   * <p>
   * Examples :
   * <p>
   * Input: n = 12
   * Output: 2
   * Explanation: 1, 2 when both divide 12 leaves remainder 0.
   * Input: n = 2446
   * Output: 1
   * Explanation: Here among 2, 4, 6 only 2 divides 2446 evenly while 4 and 6 do not.
   * Input: n = 23
   * Output: 0
   * Explanation: 2 and 3, none of them divide 23 evenly.
   */


  public static void main(String[] args) {
    System.out.print(evenlyDivides(12));
  }

  public static int evenlyDivides(int n) {
    ArrayList<Integer> digitsArray = getDigitsInGivenNumber(n);
    int evenlyDivides = 0;
    for (Integer i : digitsArray) {
      if (i != 0 && n % i == 0) {
        evenlyDivides++;
      }
    }
    return evenlyDivides;
  }

  public static ArrayList<Integer> getDigitsInGivenNumber(int n) {
    ArrayList<Integer> digitsArray = new ArrayList<>();
    while (n > 0) {
      int lastDigit = n % 10;
      n /= 10;
      digitsArray.add(lastDigit);
    }
    return digitsArray;
  }
}
