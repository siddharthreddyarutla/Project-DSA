package neetCode_150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

  /**
   * Code
   * <p>
   * Testcase
   * Testcase
   * <p>
   * Test Result
   * 49. Group Anagrams
   * Solved
   * Medium
   * <p>
   * Topics
   * premium lock icon
   * Companies
   * Given an array of strings strs, group the anagrams together. You can return the answer in any
   * order.
   * <p>
   * <p>
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
   */

  public static void main(String[] args) {

  }

  public List<List<String>> groupAnagrams(String[] strs) {

    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      char[] arr = strs[i].toCharArray();
      Arrays.sort(arr);
      String s = new String(arr);

      map.computeIfAbsent(s, k -> new ArrayList<>()).add(strs[i]);
    }

    return new ArrayList<>(map.values());
  }
}
