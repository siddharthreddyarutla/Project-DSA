package patterns;

public class Pattern7 {

  /**

  20. Geek is very fond of patterns. Once, his teacher gave him a  pattern to solve. He gave Geek an integer n and asked him to build a pattern.
	Help Geek to build a pattern.

	Example 1:
	Input: 5
	Output:
*********
 *******
  *****
   ***
    *

   */


  public static void main(String[] args) {
    printTriangle(4);
  }


  public static void printTriangle(int n) {
    // code here
    for (int i=n; i>0; i--) {
      for (int j=0; j<n-i; j++) {
        System.out.print(" ");
      }
      for (int j=2*i-1; j>0; j--) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
