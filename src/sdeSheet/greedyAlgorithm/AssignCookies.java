package sdeSheet.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class AssignCookies {

  // https://takeuforward.org/plus/dsa/problems/assign-cookies

  /**
   * Assume you are an awesome parent and want to give your children some cookies. But, you
   * should give each child at most one cookie.
   * <p>
   * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child
   * will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the
   * cookie j to the child i, and the child i will be content. Your goal is to maximize the
   * number of your content children and output the maximum number.
   * <p>
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: g = [1,2,3], s = [1,1]
   * Output: 1
   * Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
   * And even though you have 2 cookies, since their size is both 1, you could only make the
   * child whose greed factor is 1 content.
   * You need to output 1.
   * Example 2:
   * <p>
   * Input: g = [1,2], s = [1,2,3]
   * Output: 2
   * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
   * You have 3 cookies and their sizes are big enough to gratify all of the children,
   * You need to output 2
   */

  public static void main(String[] args) {
    System.out.println(findContentChildren(new int[] {10, 9, 8, 7}, new int[] {5, 6, 7, 8}));
  }

  /**
   * Sorting `O(n log n + m log m)` (n = g.length, m = s.length)
   * Two‑pointer O(n + m)
   * Extra space O(1)
   *
   * @param g
   * @param s
   *
   * @return
   */
  public static int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0;
    int j = 0;
    int cnt = 0;
    while (i < g.length && j < s.length) {
      if (s[j] >= g[i]) {
        cnt++;
        i++;
        j++;
      } else {
        j++;
      }
    }
    return cnt;
  }
}
