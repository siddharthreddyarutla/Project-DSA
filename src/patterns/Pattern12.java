package patterns;

public class Pattern12 {

  /**
   * 	Problem statement
   * 	Send feedback
   * 	Aryan and his friends are very fond of patterns. For a given integer ‘N’, they want to make the Increasing Number Triangle.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	1
   *  2 3
   *  4 5 6
   */

  public static void main(String[] args) {
    nNumberTriangle(10);
  }

  public static void nNumberTriangle(int n) {
    // Write your code here
    int numberIncrement = 1;
    for (int i=0; i<n; i++) {
      for (int j=0; j<=i; j++) {
        System.out.print(numberIncrement + " ");
        numberIncrement++;
      }
      System.out.println();
    }
  }
}
