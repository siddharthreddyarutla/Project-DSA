package sdeSheet.strings2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

  /**
   * Given an array of strings strs, group the anagrams together. You can return the answer in
   * any order.
   * <p>
   * Example 1:
   * <p>
   * Input: strs = ["eat","tea","tan","ate","nat","bat"]
   * <p>
   * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
   * <p>
   * Explanation:
   * <p>
   * There is no string in strs that can be rearranged to form "bat".
   * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
   * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
   *
   * @param args
   */

  public static void main(String[] args) {
    System.out.println(groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println();
    System.out.println(groupAnagramsOptimized(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<String> strings = new ArrayList<>();
    for (String str : strs) {
      strings.add(str);
    }

    List<List<String>> ans = new ArrayList<>();
    while (!strings.isEmpty()) {
      List<String> anagramList = new ArrayList<>();
      for (int i = 0; i < strings.size(); i++) {
        if (anagramList.isEmpty()) {
          anagramList.add(strings.get(i));
        } else {
          if (isAnagram(anagramList.get(0), strings.get(i))) {
            anagramList.add(strings.get(i));
          }
        }
      }
      ans.add(anagramList);
      strings.removeAll(anagramList);
    }
    return ans;
  }

  public static boolean isAnagram(String a, String b) {

    if (a.length() != b.length()) {
      return false;
    }

    int[] alphabet = new int[26];
    for (int i = 0; i < a.length(); i++) {
      alphabet[a.charAt(i) - 'a']++;
      alphabet[b.charAt(i) - 'a']--;
    }

    for (int i = 0; i < alphabet.length; i++) {
      if (alphabet[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static List<List<String>> groupAnagramsOptimized(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> list = map.getOrDefault(key, new ArrayList<>());
      list.add(str);
      map.put(key, list);
    }
    return new ArrayList<>(map.values());
  }
}
