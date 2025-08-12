package sdeSheet.strings1;

public class ReverseWordsInAString_151 {

  // https://takeuforward.org/data-structure/reverse-words-in-a-string/

  /**
   * Given an input string s, reverse the order of the words.
   * <p>
   * A word is defined as a sequence of non-space characters. The words in s will be separated by
   * at least one space.
   * <p>
   * Return a string of the words in reverse order concatenated by a single space.
   * <p>
   * Note that s may contain leading or trailing spaces or multiple spaces between two words. The
   * returned string should only have a single space separating the words. Do not include any
   * extra spaces.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "the sky is blue"
   * Output: "blue is sky the"
   * Example 2:
   * <p>
   * Input: s = "  hello world  "
   * Output: "world hello"
   * Explanation: Your reversed string should not contain leading or trailing spaces.
   */

  public static void main(String[] args) {

  }

  public String reverseWords(String s) {
    s.trim();
    String[] parts = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = parts.length - 1; i >= 0; i--) {
      sb.append(parts[i]);
      if (i > 0) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }
}
