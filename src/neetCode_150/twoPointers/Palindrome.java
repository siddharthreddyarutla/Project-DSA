package neetCode_150.twoPointers;

public class Palindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
  }

  public static boolean isPalindrome(String s) {

    if (s.isEmpty()) {
      return true;
    }

    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
