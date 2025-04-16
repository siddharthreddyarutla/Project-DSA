package patterns;

public class Pattern17 {

  /**
   * 	Problem statement
   * 	Send feedback
   * 	Sam is curious about symmetric patterns, so he decided to create one.
   * 	For every value of ‘N’, return the symmetry as shown in the example.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * * * * * * *
   * * *     * *
   * *         *
   * *         *
   * * *     * *
   * * * * * * *
   */

  public static void main(String[] args) {
    symmetry(10);
  }


  public static void symmetry(int n) {
    // Write your code here

    int spaces = 0;
    for (int i = n; i > 0; i--) {
      // left side
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      // spaces
      for (int j = 0; j < spaces; j++) {
        System.out.print(" ");
      }
      spaces += 2;
      // right side
      for (int j = 1; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    spaces = 2 * n;
    for (int i = 0; i < n; i++) {
      // left side
      for (int j = 0; j <= i; j++) {
        System.out.print("* ");
      }
      for (int j = 0; j < spaces; j++) {
        System.out.print(" ");
      }
      spaces -= 2;
      // right side
      for (int j = 0; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
