package patterns;

public class Pattern13 {

  /**
   * 	Aryan and his friends are very fond of patterns. For a given integer ‘N’, they want to make the Increasing Letter Triangle.
   * 	Example:
   * 	Input: ‘N’ = 3
   * 	Output:
   * 	A
   *  A B
   *  A B C
   */

  public static void main(String[] args) {
//    nLetterTriangle(30);
    nLetterTriangleSecond(30);
  }


  /**
   * this will fail after input size after 26
   * @param n
   */
  public static void nLetterTriangle(int n) {
    // Write your code here
    String[] letters =
        {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z"};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(letters[j] + " ");
      }
      System.out.println();
    }
  }


  public static void nLetterTriangleSecond(int n) {
    // Write your code here
    for (int i=0; i<n; i++) {
      for(char j='A'; j<='A'+i; j++) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
