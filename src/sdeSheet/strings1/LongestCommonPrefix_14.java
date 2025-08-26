package sdeSheet.strings1;

public class LongestCommonPrefix_14 {

  /**
   * Write a function to find the longest common prefix string amongst an array of strings.
   * <p>
   * If there is no common prefix, return an empty string "".
   * <p>
   * Example 1:
   * <p>
   * Input: strs = ["flower","flow","flight"]
   * Output: "fl"
   * Example 2:
   * <p>
   * Input: strs = ["dog","racecar","car"]
   * Output: ""
   * Explanation: There is no common prefix among the input strings.
   */


  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
  }

  /**
   * Time complexity = O(S)
   * Space complexity - O(1)
   *
   * @param strs
   *
   * @return
   */
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    // Start with the first string as the tentative prefix.
    String prefix = strs[0];
    for (String str : strs) {
      while (!str.startsWith(prefix)) {
        /* For each next string, while that string does not start with prefix, chop off the last
         character of prefix. */
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }
    return prefix;
  }
}
