package patterns;

public class Pattern6 {

  /**
  	19. Geek is very fond of patterns. Once, his teacher gave him a pattern to solve. He gave Ram an integer n and asked him to build a pattern.
	Help Ram build a pattern.
	Example 1:
	Input: 5
Output:
    *
   ***
  *****
 *******
*********
	Example 2:
	Input: 3
Output:
  *
 ***
*****

   */

  public static void main(String[] args) {
    printTriangle(40);
  }

  public static void printTriangle(int n) {
    // code here
    for (int i=0; i<n; i++) {
      for (int j=0; j<n-i-1; j++) {
        System.out.print(" ");
      }
      for (int j=0; j<2*i+1; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
