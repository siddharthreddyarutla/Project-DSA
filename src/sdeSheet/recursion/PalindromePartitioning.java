package sdeSheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

  // https://takeuforward.org/data-structure/palindrome-partitioning/

  /**
   * Given a string s, partition s such that every substring of the partition is a palindrome.
   * Return all possible palindrome partitioning of s.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "aab"
   * Output: [["a","a","b"],["aa","b"]]
   * Example 2:
   * <p>
   * Input: s = "a"
   * Output: [["a"]]
   */

  public static void main(String[] args) {
    PalindromePartitioning s = new PalindromePartitioning();
    System.out.println(s.partition("aabb"));
  }

  /**
   * Time Complexity: O( (2^n) *k*(n/2) )
   * <p>
   * Reason: O(2^n) to generate every substring and O(n/2)  to check if the substring generated
   * is a palindrome. O(k) is for inserting the palindromes in another data structure, where k
   * is the average length of the palindrome list.
   * <p>
   * Space Complexity: O(k * x)
   * <p>
   * Reason: The space complexity can vary depending upon the length of the answer. k is the
   * average length of the list of palindromes and if we have x such list of palindromes in our
   * final answer. The depth of the recursion tree is n, so the auxiliary space required is equal
   * to the O(n).
   *
   * @param s
   *
   * @return
   */
  public List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    palindromePartition(s, 0, new ArrayList<>(), ans);
    return ans;
  }

  public static void palindromePartition(String s, int index, List<String> subString,
      List<List<String>> ans) {
    if (index == s.length()) {
      ans.add(new ArrayList<>(subString));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index, i)) {
        subString.add(s.substring(index, i + 1));
        palindromePartition(s, i + 1, subString, ans);
        subString.remove(subString.size() - 1);
      }
    }
  }

  public static boolean isPalindrome(String s, int start, int end) {
    while (start < end) {
      if (s.charAt(start) == s.charAt(end)) {
        start++;
        end--;
      } else {
        return false;
      }
    }
    return true;
  }
}
