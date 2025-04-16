package patterns;

public class Pattern15 {

  /**
   * 	Sam is curious about Alpha-Hills, so he decided to create Alpha-Hills of different sizes.
   * 	An Alpha-hill is represented by a triangle, where alphabets are filled in palindromic order.
   * 	For every value of ‘N’, help sam to return the corresponding Alpha-Hill.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   *     A
   *   A B A
   * A B C B A
   */


  public static void main(String[] args) {
    alphaHill(10);
  }

  public static void alphaHill(int n) {
    // Write your code here
    for (int i = 1; i <= n; i++) {
      char c = 'A';
      for (int j = 1; j <= n - i; j++) {
        System.out.print(" ");
      }
      for (int j = 1; j <= 2 * i - 1; j++) {
        System.out.print(c + " ");
        if (j < ((2 * i) / 2)) {
          c++;
        } else {
          c--;
        }
      }
      System.out.println();
    }
  }
}
