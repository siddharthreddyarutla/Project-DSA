package StackAndQueue;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

  // https://leetcode.com/problems/implement-queue-using-stacks/

  /**
   * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue
   * should support all the functions of a normal queue (push, peek, pop, and empty).
   * <p>
   * Implement the MyQueue class:
   * <p>
   * void push(int x) Pushes element x to the back of the queue.
   * int pop() Removes the element from the front of the queue and returns it.
   * int peek() Returns the element at the front of the queue.
   * boolean empty() Returns true if the queue is empty, false otherwise.
   * Notes:
   * <p>
   * You must use only standard operations of a stack, which means only push to top, peek/pop
   * from top, size, and is empty operations are valid.
   * Depending on your language, the stack may not be supported natively. You may simulate a
   * stack using a list or deque (double-ended queue) as long as you use only a stack's standard
   * operations.
   */

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    myQueue.push(2);
    System.out.println(myQueue.peek());
    System.out.println(myQueue.pop());
    System.out.println(myQueue.empty());
  }

  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(N)
   */
  static class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> helperStack;

    public MyQueue() {
      stack = new Stack<>();
      helperStack = new Stack<>();
    }

    public void push(int x) {
      while (!stack.isEmpty()) {
        helperStack.push(stack.pop());
      }
      stack.push(x);
      while (!helperStack.isEmpty()) {
        stack.push(helperStack.pop());
      }
    }

    public int pop() {
      return stack.pop();
    }

    public int peek() {
      return stack.peek();
    }

    public boolean empty() {
      return stack.isEmpty();
    }
  }
}
