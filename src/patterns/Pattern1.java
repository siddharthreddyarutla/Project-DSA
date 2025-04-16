package patterns;

public class Pattern1 {

  /**

	14. Geek is very fond of patterns. Once, his teacher gave him a square pattern to solve. He gave Geek an integer n and asked him to build a pattern.
	Help Geek to build a square pattern with the help of *  such that each * is space-separated in each line.

	Example 1:
	Input:
	n = 3
	Output:
	* * *
	* * *
  * * *

   */


  public static void main(String[] args) {
    Pattern1 pattern1 = new Pattern1();
    pattern1.printSquare(3);
  }


  void printSquare(int n) {
    int temp = n;
    while (temp > 0) {
      for(int j=0; j<n; j++) {
        System.out.print("* ");
      }
      System.out.println();
      temp--;
    }
  }
}
