package sdesheet;


import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  // https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/

  /**
   * Given an integer numRows, return the first numRows of Pascal's triangle.
   *
   * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
   *
   * Example 1:
   *
   * Input: numRows = 5
   * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
   * Example 2:
   *
   * Input: numRows = 1
   * Output: [[1]]
   */

  public static void main(String[] args) {
    System.out.print(nCr(7, 4));
    System.out.println();
    System.out.println(nCrOptimized(7, 4));
    System.out.println();
    System.out.print(nthRow(5));
    System.out.println();
    System.out.print(nthRowOptimized(5));
    System.out.println();
    System.out.print(nthRowOptimized2(5));
    System.out.println();
    System.out.print(generatePascalTriangle(5));
  }

  /**
   * Problem 1 : In this case, we are given the row number r and the column number c, and we need to
   * find out the element at position (r,c).
   *
   *  use: nCr formula = n! / r! * (n -r)!
   *
   * We have an easier formula to find out the element i.e. r-1Cc-1. Let’s try to analyze the formula
   * to find the value of the combination assuming r-1 as n and c-1 as r:
   *
   * Time Complexity: O(c), where c = given column number.
   * Reason: We are running a loop for r times, where r is c-1.
   *
   * Space Complexity: O(1) as we are not using any extra space.
   * @param n
   * @param r
   *
   * @return
   */
  public static long nCr(int n, int r) {

    n -=1;
    r -=1;
    int nMinusR = n - r;
    int nFac = 1;
    int rFac = 1;

    for (int i=n;i>nMinusR; i--) {
      nFac *= i;
    }
    for (int i=1; i<=r; i++) {
      rFac *= i;
    }
    return (long) nFac / rFac;
  }

  /**
   *
   * n=5, r=3
   * n=4, r=2
   * 4*3/2*1
   * 4/1 * 3/2 => n will go till 2 times by n-1 and r will go i + 1
   *
   * @param n
   * @param r
   * @return
   */
  public static long nCrOptimized(int n, int r) {
    r -= 1;
    n -= 1;
    int res = 1;
    for (int i = 0; i < r; i++) {
      res = res * (n - i);
      res = res / (i + 1);
    }
    return res;
  }

  /**
   * Given the row number n. Print the n-th row of Pascal’s triangle.
   * Time Complexity: O(n*r), where n is the given row number, and r is the column index
   * which can vary from 0 to n-1.
   * Reason: We are calculating the element for each column. Now, there are total n columns, and
   * for each column, the calculation of the element takes O(r) time where r is the column index.
   *
   * Space Complexity: O(1) as we are not using any extra space.
   */
  public static List<Long> nthRow(int r) {
    // use ncr formula to do
    List<Long> ans = new ArrayList<>();
    for (int c=1; c<=r;c++) {
        ans.add(nCrOptimized(r, c));
    }
    return ans;
  }


  public static List<Long> nthRowOptimized(int r) {
    int pos = 1;
    List<Long> ans = new ArrayList<>();

    for (int i = r; i > 0; i--) {
      if (i == r) {
        ans.add(1L);
      } else {
        ans.add(ans.get(pos-1) * i / pos);
        pos++;
      }
    }
    return ans;
  }

  public static List<Long> nthRowOptimized2(int r) {
    List<Long> ans = new ArrayList<>();
    ans.add(1L);
    long res = 1L;
    for (int i = 1; i < r; i++) {
      res *= (r - i);
      res /= i;
      ans.add(res);
    }
    return ans;
  }

  /**
   * Time Complexity: O(n2), where n = number of rows(given).
   * Reason: We are generating a row for each single row. The number of rows is n. And generating
   * an entire row takes O(n) time complexity.
   * <p>
   * Space Complexity: In this case, we are only using space to store the answer. That is why
   * space complexity can still be considered as O(1).
   *
   * @param numRows
   *
   * @return
   */
  public static List<List<Long>> generatePascalTriangle(int numRows) {
    List<List<Long>> ans = new ArrayList<>();
    for (int r = 1; r <= numRows; r++) {
      ans.add(nthRowOptimized(r));
    }
    return ans;
  }
}
