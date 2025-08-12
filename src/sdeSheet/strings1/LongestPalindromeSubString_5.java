package sdeSheet.strings1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class LongestPalindromeSubString_5 {

  // https://takeuforward.org/data-structure/reverse-words-in-a-string/

  /**
   * Given a string s, return the longest palindromic substring in s.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "babad"
   * Output: "bab"
   * Explanation: "aba" is also a valid answer.
   * Example 2:
   * <p>
   * Input: s = "cbbd"
   * Output: "bb"
   */

  public static void main(String[] args) {
    System.out.println(longestPalindrome("babad"));
    System.out.println(longestPalindrome("cbbd"));
    System.out.println();
    System.out.println(longestPalindromeUsingRecursion("babad"));
  }

  public static String longestPalindrome(String s) {
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        if (isPalindrome(i, j, s)) {
          ans.add(s.substring(i, j + 1));
        }
      }
    }
    return ans.stream().max(Comparator.comparingInt(String::length)).orElse(null);
  }

  public static boolean isPalindrome(int left, int right, String s) {
    while (left <= right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static String longestPalindromeUsingRecursion(String s) {
    List<List<String>> ans = new ArrayList<>();
    List<String> subStrings = new ArrayList<>();
    findLongestPalindrome(0, s, subStrings, ans);
    return ans.stream().flatMap(Collection::stream).max(Comparator.comparingInt(String::length))
        .orElse(null);
  }

  public static void findLongestPalindrome(int index, String s, List<String> subStrings,
      List<List<String>> ans) {
    if (index == s.length()) {
      ans.add(new ArrayList<>(subStrings));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(index, i, s)) {
        subStrings.add(s.substring(index, i + 1));
        findLongestPalindrome(i + 1, s, subStrings, ans);
        subStrings.remove(subStrings.size() - 1);
      }
    }
  }
}
