package neetCode_150.slidingWIndow;

import java.util.Arrays;
import java.util.HashMap;

public class LongestRepeatingCharacterReplacement_424 {

  /**
   * You are given a string s and an integer k. You can choose any character of the string and
   * change it to any other uppercase English character. You can perform this operation at most k
   * times.
   * <p>
   * Return the length of the longest substring containing the same letter you can get after
   * performing the above operations.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: s = "ABAB", k = 2
   * Output: 4
   * Explanation: Replace the two 'A's with two 'B's or vice versa.
   * Example 2:
   * <p>
   * Input: s = "AABABBA", k = 1
   * Output: 4
   * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
   * The substring "BBBB" has the longest repeating letters, which is 4.
   * There may exists other ways to achieve this answer too.
   */

  public static void main(String[] args) {
    System.out.println(characterReplacement("AABABBA", 1));
  }

  public static int characterReplacement(String s, int k) {

    if (s.isEmpty()) {
      return 0;
    }

    if (s.length() <= k) {
      return s.length();
    }

    int max = 1;

    for (int i = 0; i < s.length(); i++) {
      HashMap<Character, Integer> map = new HashMap<>();
      int maxFrequency = 0;
      for (int j = i; j < s.length(); j++) {
        Character c = s.charAt(j);

        map.put(c, map.getOrDefault(c, 0) + 1);

        maxFrequency = Math.max(maxFrequency, map.get(c));

        int changes = (j - i + 1) - maxFrequency;

        if (changes <= k) {
          max = Math.max(max, j - i + 1);
        } else {
          break;
        }

      }
    }

    return max;
  }

  public static int characterReplacementBetter(String s, int k) {
    int max = 0;

    int i = 0;
    int j = 0;
    int n = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    int maxFrequency = 0;

    while (j < n) {

      Character c = s.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);

      maxFrequency = Math.max(maxFrequency, map.get(c));

      // Until the window is valid shrink the window

      while ((j - i + 1) - maxFrequency > k) {
        Character charAtI = s.charAt(i);

        // Remove element from the map
        if (map.get(charAtI) > 1) {
          map.put(charAtI, map.get(charAtI) - 1);
        } else {
          map.remove(charAtI);
        }
        i++;
      }

      // if it satisfies the condition update the max and move forward
      if ((j - i + 1) - maxFrequency <= k) {
        max = Math.max(max, (j - i + 1));
        j++;
      }
    }

    return max;
  }


  public static int characterReplacementOptimal(String s, int k) {
    int max = 0;

    int i = 0;
    int j = 0;
    int n = s.length();
    HashMap<Character, Integer> map = new HashMap<>();
    int maxFrequency = 0;

    while (j < n) {

      Character c = s.charAt(j);
      map.put(c, map.getOrDefault(c, 0) + 1);

      maxFrequency = Math.max(maxFrequency, map.get(c));

      // Removed while as no need to remove all just keep the window consistent size
      if ((j - i + 1) - maxFrequency > k) {
        Character charAtI = s.charAt(i);
        if (map.get(charAtI) > 1) {
          map.put(charAtI, map.get(charAtI) - 1);
        } else {
          map.remove(charAtI);
        }
        i++;
      }

      if ((j - i + 1) - maxFrequency <= k) {
        max = Math.max(max, (j - i + 1));
        j++;
      }
    }

    return max;
  }
}
