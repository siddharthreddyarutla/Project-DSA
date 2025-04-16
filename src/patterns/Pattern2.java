package patterns;

public class Pattern2 {

  /**

	15. Geek is very fond of patterns. Once, his teacher gave him a pattern of triangle to solve.
	He gave Geek an integer n and asked him to build a pattern.
	Help Geek to build a triangle pattern using stars(*).

	Example 1:

	Input:
	n = 5
	Output:
	*
	* *
	* * *
	* * * *
  * * * * *

   */

  public static void main(String[] args) {
    printTriangle(3);
  }

  public static void printTriangle(int n) {
    // code here
    for (int i=0; i<n; i++) {
      for(int j=0; j<i+1; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
