package patterns;

public class Pattern10 {

  /**
   *
   * 	24. Problem statement
   * 	Send feedback
   * 	Aryan and his friends are very fond of the pattern. They want to make the Reverse N-Number Crown for a given integer' N'.
   * 	Given 'N', print the corresponding pattern.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	1         1
   *  1 2     2 1
   *  1 2 3 3 2 1
   */


  public static void main(String[] args) {
    numberCrown(8);
  }

  public static void numberCrown(int n) {
    // Write your code here.
    int spacesCount = 2*(n-1);
    for (int i=1; i<=n; i++) {
      for (int j=1; j<=i; j++) {
        System.out.print(j + " ");
      }
      for (int j=0; j<spacesCount; j++) {
        System.out.print(" ");
      }
      for (int j=i; j>0; j--) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
