package patterns;

public class Pattern18 {

  /**
   * 	Problem statement
   * 	Send feedback
   * 	Ninja has been given a task to print the required star pattern and he asked your help for the same.
   * 	You must return an ‘N’*’N’ matrix corresponding to the given star pattern.
   * 	Example:
   * 	Input: ‘N’ = 4
   * 	Output:
   * 	****
   *  *  *
   *  *  *
   *  ****
   */

  public static void main(String[] args) {
    getStarPattern(10);
    getStarPatternSecond(10);
  }


  public static void getStarPattern(int n) {
    // Write your code here
    for (int i = 1; i <= n; i++) {
      if (i == 1 || i == n) {
        for (int j = 0; j < n; j++) {
          System.out.print("*");
        }
      } else {
        System.out.print("*");
        for (int j = 0; j < n - 2; j++) {
          System.out.print(" ");
        }
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public static void getStarPatternSecond(int n) {
    // Write your code here
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 || i == n || j == 1 || j == n) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
