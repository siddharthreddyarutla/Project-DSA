package sdeSheet.strings1;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger_13 {

  /**
   * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
   * <p>
   * Symbol       Value
   * I             1
   * V             5
   * X             10
   * L             50
   * C             100
   * D             500
   * M             1000
   * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is
   * written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V +
   * II.
   * <p>
   * Roman numerals are usually written largest to smallest from left to right. However, the
   * numeral for four is not IIII. Instead, the number four is written as IV. Because the one is
   * before the five we subtract it making four. The same principle applies to the number nine,
   * which is written as IX. There are six instances where subtraction is used:
   * <p>
   * I can be placed before V (5) and X (10) to make 4 and 9.
   * X can be placed before L (50) and C (100) to make 40 and 90.
   * C can be placed before D (500) and M (1000) to make 400 and 900.
   * Given a roman numeral, convert it to an integer.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "III"
   * Output: 3
   * Explanation: III = 3.
   * Example 2:
   * <p>
   * Input: s = "LVIII"
   * Output: 58
   * Explanation: L = 50, V= 5, III = 3.
   * Example 3:
   * <p>
   * Input: s = "MCMXCIV"
   * Output: 1994
   * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
   */

  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
  }

  public static int romanToInt(String s) {
    Map<Character, Integer> romanToIntMap = new HashMap<>();
    romanToIntMap.put('I', 1);
    romanToIntMap.put('V', 5);
    romanToIntMap.put('X', 10);
    romanToIntMap.put('L', 50);
    romanToIntMap.put('C', 100);
    romanToIntMap.put('D', 500);
    romanToIntMap.put('M', 1000);

    int ans = 0;
    int prevValue = 0;

    // Traverse from right to left
    for (int i = s.length() - 1; i >= 0; i--) {
      int currValue = romanToIntMap.get(s.charAt(i));

      if (currValue < prevValue) {
        ans -= currValue;   // subtract if smaller than the next (to the right)
      } else {
        ans += currValue;   // otherwise, add it
      }

      prevValue = currValue;
    }

    return ans;
  }
}
