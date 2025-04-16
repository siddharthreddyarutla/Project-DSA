package patterns;

public class Pattern9 {

  /**
   * 	22. Problem statement
   * 	Send feedback
   * 	Ninja was very fond of patterns. For a given integer ‘N’, he wants to make the N-Star Rotated Triangle.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	*
   *  **
   *  ***
   *  **
   *  *
   */

  public static void main(String[] args) {
    nStarTriangle(10);
  }


  public static void nStarTriangle(int n) {
    // Write your code here.
    for (int i=0; i<n; i++) {
      for (int j=0; j<i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i=n; i>0; i--) {
      for (int j=0; j<i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void nStarTriangleSecond(int n) {
    // Write your code here.
    for (int i=1; i<=n; i++) {
      for (int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
    for (int i=n-1; i>0; i--) {
      for (int j=1; j<=i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
