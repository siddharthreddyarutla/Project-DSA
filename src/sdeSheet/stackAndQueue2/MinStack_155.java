package sdeSheet.stackAndQueue2;

import java.util.Stack;

public class MinStack_155 {

  // https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/

  /**
   * Design a stack that supports push, pop, top, and retrieving the minimum element in constant
   * time.
   * <p>
   * Implement the MinStack class:
   * <p>
   * MinStack() initializes the stack object.
   * void push(int val) pushes the element val onto the stack.
   * void pop() removes the element on the top of the stack.
   * int top() gets the top element of the stack.
   * int getMin() retrieves the minimum element in the stack.
   * You must implement a solution with O(1) time complexity for each function.
   * <p>
   * Example 1:
   * <p>
   * Input
   * ["MinStack","push","push","push","getMin","pop","top","getMin"]
   * [[],[-2],[0],[-3],[],[],[],[]]
   * <p>
   * Output
   * [null,null,null,null,-3,null,0,-2]
   * <p>
   * Explanation
   * MinStack minStack = new MinStack();
   * minStack.push(-2);
   * minStack.push(0);
   * minStack.push(-3);
   * minStack.getMin(); // return -3
   * minStack.pop();
   * minStack.top();    // return 0
   * minStack.getMin(); // return -2
   */

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top());    // return 0
    System.out.println(minStack.getMin());
  }

  /**
   * time complexity - O(1)
   * Space complexity - O(1)
   * push() → O(1)
   * pop() → O(1)
   * top() → O(1)
   * getMin() → O(1)
   */
  static class MinStack {
    /* Key as integer and value as the min of all */ Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
      stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(new Pair<>(val, val));
      } else {
        Pair<Integer, Integer> topEle = stack.peek();
        if (topEle.second < val) {
          stack.push(new Pair<>(val, topEle.second));
        } else {
          stack.push(new Pair<>(val, val));
        }
      }
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
      return stack.peek().first;
    }

    public int getMin() {
      return stack.peek().second;
    }
  }


  static class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
      this.first = first;
      this.second = second;
    }
  }
}
