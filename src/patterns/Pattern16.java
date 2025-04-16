package patterns;

public class Pattern16 {

  /**
   * 	Problem statement
   * 	Send feedback
   * 	Sam is researching on Alpha-Triangles. So, he needs to create them for different integers ‘N’.
   * 	An Alpha-Triangle is represented by the triangular pattern of alphabets in reverse order.
   * 	For every value of ‘N’, help sam to print the corresponding Alpha-Triangle.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	C
   *  C B
   *  C B A
   */

  public static void main(String[] args) {
    alphaTriangle(3);
  }

  public static void alphaTriangle(int n) {
    // Write your code here
    char c = 'A';
    c += n - 1;
    for (int i = 0; i < n; i++) {
      char test = c;
      for (int j = 0; j <= i; j++) {
        System.out.print(test + " ");
        test--;
      }
      System.out.println();
    }
  }
}
