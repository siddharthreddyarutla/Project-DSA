package sdeSheet.strings2;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {

  /**
   * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "anagram", t = "nagaram"
   * <p>
   * Output: true
   * <p>
   * Example 2:
   * <p>
   * Input: s = "rat", t = "car"
   * <p>
   * Output: false
   */

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram", "nagaram"));
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    int i = 0;
    while (i < s.length()) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      i++;
    }
    i = 0;
    while (i < t.length()) {
      if (map.containsKey(t.charAt(i))) {
        int value = map.get(t.charAt(i));
        if (value > 1) {
          map.put(t.charAt(i), value - 1);
        } else {
          map.remove(t.charAt(i));
        }
        i++;
      } else {
        break;
      }
    }
    return map.isEmpty() ? true : false;
  }

  public static boolean isAnagramOptimal(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    int[] count = new int[26]; // assuming only lowercase a-z

    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
      count[t.charAt(i) - 'a']--;
    }

    for (int c : count) {
      if (c != 0) {
        return false;
      }
    }
    return true;
  }
}
