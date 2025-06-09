package sdeSheet.arrays4;

import java.util.HashSet;
import java.util.LinkedList;

public class longestSubstringWithoutRepeatingCharacters_3 {

  // https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

  /**
   * Given a string s, find the length of the longest substring without duplicate characters.
   * Example 1:
   * Input: s = "abcabcbb"
   * Output: 3
   * Explanation: The answer is "abc", with the length of 3.
   * Example 2:
   * Input: s = "bbbbb"
   * Output: 1
   * Explanation: The answer is "b", with the length of 1.
   * Example 3:
   * Input: s = "pwwkew"
   * Output: 3
   * Explanation: The answer is "wke", with the length of 3.
   * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
   */

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("dvdf"));
    System.out.println(lengthOfLongestSubstringBetter("dvdf"));
    System.out.println(lengthOfLongestSubstringOptimized("dvdf"));
    LinkedList<Long> test = new LinkedList<>();
    test.add(2L);
    test.getFirst();
    test.getLast();
    System.out.println(test);
  }

  /**
   * Time Complexity: O( N2 )
   * <p>
   * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
   *
   * @param s
   *
   * @return
   */
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int cnt = 1;
    int max = 1;
    int left = 0;
    int right = left + 1;
    HashSet<String> set = new HashSet<>(n);
    set.add(String.valueOf(s.charAt(left)));
    while (left < n && right < n) {
      if (!set.contains(String.valueOf(s.charAt(right)))) {
        set.add(String.valueOf(s.charAt(right)));
        right++;
        cnt++;
        max = Math.max(max, cnt);
      } else {
        cnt = 1;
        set = new HashSet<>();
        left++;
        right = left + 1;
        set.add(String.valueOf(s.charAt(left)));
      }
    }
    return max;
  }

  /**
   * Time Complexity: O( N2 )
   * <p>
   * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
   *
   * @param str
   *
   * @return
   */
  public static int lengthOfLongestSubstringBetter(String str) {
    if (str.isEmpty()) {
      return 0;
    }
    int maxans = Integer.MIN_VALUE;
    for (int i = 0; i < str.length(); i++) {
      HashSet<Character> se = new HashSet<>();
      for (int j = i; j < str.length(); j++) {
        if (!se.contains(str.charAt(j))) {
          se.add(str.charAt(j));
          maxans = Math.max(maxans, j - i + 1);
        } else {
          break;
        }
      }
    }
    return maxans;
  }

  /**
   * Time Complexity: O( N ) (sometimes left and right both have to travel complete array)
   * <p>
   * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
   * <p>
   * Sliding window technique
   *
   * @param s
   *
   * @return
   */
  public static int lengthOfLongestSubstringOptimized(String s) {
    int n = s.length();
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int max = Integer.MIN_VALUE;
    int left = 0;
    int right = left + 1;
    HashSet<Character> set = new HashSet<>(n);
    set.add(s.charAt(left));
    while (right < n) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
        max = Math.max(max, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return max;
  }
}
