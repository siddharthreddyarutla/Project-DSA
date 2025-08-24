package sdeSheet.strings2;

public class FindTheIndexOfTheFirstOccurrenceInAString_28 {

  /**
   * Given two strings needle and haystack, return the index of the first occurrence of needle in
   * haystack, or -1 if needle is not part of haystack.
   * <p>
   * Example 1:
   * <p>
   * Input: haystack = "sadbutsad", needle = "sad"
   * Output: 0
   * Explanation: "sad" occurs at index 0 and 6.
   * The first occurrence is at index 0, so we return 0.
   * Example 2:
   * <p>
   * Input: haystack = "leetcode", needle = "leeto"
   * Output: -1
   * Explanation: "leeto" did not occur in "leetcode", so we return -1.
   */

  public static void main(String[] args) {
    System.out.println(strStr("sadbutsad", "sad"));
  }

  public static int strStr(String haystack, String needle) {
    if (haystack.contains(needle)) {
      return haystack.indexOf(needle);
    } else {
      return -1;
    }
  }
}
