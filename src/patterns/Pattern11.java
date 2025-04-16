package patterns;

public class Pattern11 {

  /**
   * 	23. Problem statement
   * 	Send feedback
   * 	Aryan and his friends are very fond of the pattern. For a given integer ‘N’, they want to make the N-Binary Number Triangle.
   * 	You are required to print the pattern as shown in the examples below.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	1
   *  0 1
   *  1 0 1
   */


  public static void main(String[] args) {
    nBinaryTriangle(6);
  }


  public static void nBinaryTriangle(int n) {
    // Write your code here.
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i + 1; j++) {
        if ((i + j) % 2 == 0) {
          System.out.print("1 ");
        } else {
          System.out.print("0 ");
        }
      }
      System.out.println();
    }
  }
}
