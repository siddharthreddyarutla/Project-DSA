package patterns;

public class Pattern4 {

  /**
  	17. Geek is very fond of patterns. Once, his teacher gave him a  pattern to solve. He gave Geek an integer n and asked him to build a pattern.
	Help Geek to build a pattern.

	Example 1:
	Input: 5

	Output:
	1
	2 2
	3 3 3
	4 4 4 4
  5 5 5 5 5

   */


  public static void main(String[] args) {
    printTriangle(5);
  }

  public static void printTriangle(int n) {
    // code here
    for (int i=1; i<=n; i++) {
      for (int j=0; j<i; j++) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
