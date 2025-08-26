package sdeSheet.StackAndQueue;

import java.util.Stack;

public class ValidParentheses_20 {

  // https://takeuforward.org/data-structure/check-for-balanced-parentheses/

  /**
   * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine
   * if the input string is valid.
   * <p>
   * An input string is valid if:
   * <p>
   * Open brackets must be closed by the same type of brackets.
   * Open brackets must be closed in the correct order.
   * Every close bracket has a corresponding open bracket of the same type.
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input: s = "()"
   * <p>
   * Output: true
   * <p>
   * Example 2:
   * <p>
   * Input: s = "()[]{}"
   * <p>
   * Output: true
   * <p>
   * Example 3:
   * <p>
   * Input: s = "(]"
   * <p>
   * Output: false
   */

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("()[]{}"));
  }

  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(N)
   *
   * @param s
   *
   * @return
   */
  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char value = s.charAt(i);
      if (value == '(' || value == '{' || value == '[') {
        stack.push(s.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        if ((value == ')' && stack.peek() == '(') || (value == '}' && stack.peek() == '{') || (
            value == ']' && stack.peek() == '[')) {
          stack.pop();
        } else {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}
