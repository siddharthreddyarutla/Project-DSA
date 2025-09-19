package random;

public class PatternMatching {

  public static void main(String[] args) {

    System.out.println(isPatternMatching("siddharth", "s7h"));
    System.out.println(isPatternMatching("siddharth", "s3h"));
    System.out.println(isPatternMatching("siddharth", "s2d4h"));
    System.out.println(isPatternMatching("siddharth", "s2d4g"));
    System.out.println(isPatternMatching("siddharth", "si6h"));
    System.out.println(isPatternMatching("ab", "a0b"));
  }

  public static boolean isPatternMatching(String s, String pattern) {

    if (s.isEmpty()) {
      return false;
    }
    if (pattern.isEmpty()) {
      return true;
    }

    int indexOfS = 0;
    int indexOfPattern = 0;

    while (indexOfS < s.length() && indexOfPattern < pattern.length()) {
      if (Character.isLetter(pattern.charAt(indexOfPattern))) {
        if (pattern.charAt(indexOfPattern) != s.charAt(indexOfS)) {
          return false;
        } else {
          indexOfPattern++;
          indexOfS++;
        }
      } else if (Character.isDigit(pattern.charAt(indexOfPattern))) {
        if (pattern.charAt(indexOfPattern) != 0) {
          indexOfS += (pattern.charAt(indexOfPattern) - '0');
        }
        indexOfPattern++;
      }
    }
    return true;
  }
}
