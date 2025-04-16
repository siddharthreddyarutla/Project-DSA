package patterns;

public class Pattern8 {

  /**
   * 	21. Problem statement
   * 	Send feedback
   * 	Ninja was very fond of patterns. For a given integer ‘N’, he wants to make the N-Star Diamond.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	   *
   *    ***
   *   *****
   *   *****
   *    ***
   *     *
   */

  public static void main(String[] args) {
    nStarDiamond(10);
  }

  public static void nStarDiamond(int n) {
    // Write your code here.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        System.out.print(" ");
      }
      for (int j = 0; j < 2 * i + 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i = n; i > 0; i--) {
      for (int j = n - i; j > 0; j--) {
        System.out.print(" ");
      }
      for (int j = 0; j < 2 * i - 1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
