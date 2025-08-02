package sdeSheet.recursionAndBacktracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

  /**
   * Given a string s and a dictionary of strings wordDict, return true if s can be segmented
   * into a space-separated sequence of one or more dictionary words.
   * <p>
   * Note that the same word in the dictionary may be reused multiple times in the segmentation.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: s = "leetcode", wordDict = ["leet","code"]
   * Output: true
   * Explanation: Return true because "leetcode" can be segmented as "leet code".
   * Example 2:
   * <p>
   * Input: s = "applepenapple", wordDict = ["apple","pen"]
   * Output: true
   * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
   * Note that you are allowed to reuse a dictionary word.
   * Example 3:
   * <p>
   * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
   * Output: false
   */

  public static void main(String[] args) {
    System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    System.out.println(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
    System.out.println(wordBreak1("cars", Arrays.asList("car", "ca", "rs")));
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    return checkValidWordBreak(s, wordDict);
  }

  public static boolean wordBreak1(String s, List<String> wordDict) {
    HashMap<String, Boolean> dp = new HashMap<>();
    return checkValidWordBreakOptimized(s, wordDict, dp);
  }

  public static boolean checkValidWordBreak(String s, List<String> wordDict) {
    if (s.isEmpty()) {
      return true;
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        if (checkValidWordBreak(s.substring(word.length()), wordDict)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean checkValidWordBreakOptimized(String s, List<String> wordDict,
      HashMap<String, Boolean> dp) {
    if (s.isEmpty()) {
      return true;
    }
    if (dp.containsKey(s)) {
      return dp.get(s);
    }
    for (String word : wordDict) {
      if (s.startsWith(word)) {
        String remainingWord = s.substring(word.length());
        if (checkValidWordBreakOptimized(remainingWord, wordDict, dp)) {
          dp.put(s, true);
          return true;
        }
      }
    }
    dp.put(s, false);
    return false;
  }
}



