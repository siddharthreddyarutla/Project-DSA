package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

  // https://takeuforward.org/data-structure/implement-stack-using-single-queue/

  /**
   * Topics
   * premium lock icon
   * Companies
   * Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack
   * should support all the functions of a normal stack (push, top, pop, and empty).
   * <p>
   * Implement the MyStack class:
   * <p>
   * void push(int x) Pushes element x to the top of the stack.
   * int pop() Removes the element on the top of the stack and returns it.
   * int top() Returns the element on the top of the stack.
   * boolean empty() Returns true if the stack is empty, false otherwise.
   * Notes:
   * <p>
   * You must use only standard operations of a queue, which means that only push to back,
   * peek/pop from front, size and is empty operations are valid.
   * Depending on your language, the queue may not be supported natively. You may simulate a
   * queue using a list or deque (double-ended queue) as long as you use only a queue's standard
   * operations.
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input
   * ["MyStack", "push", "push", "top", "pop", "empty"]
   * [[], [1], [2], [], [], []]
   * Output
   * [null, null, null, 2, 2, false]
   * <p>
   * Explanation
   * MyStack myStack = new MyStack();
   * myStack.push(1);
   * myStack.push(2);
   * myStack.top(); // return 2
   * myStack.pop(); // return 2
   * myStack.empty(); // return False
   */

  public static void main(String[] args) {
    MyStackUsingQueue myStackUsingQueue = new MyStackUsingQueue();
    myStackUsingQueue.push(1);
    myStackUsingQueue.push(2);
    myStackUsingQueue.push(3);
    System.out.println(myStackUsingQueue.top());
    System.out.println(myStackUsingQueue.pop());
    System.out.println(myStackUsingQueue.empty());
  }

  class MyStack {

    private final List<Integer> stack;

    public MyStack() {
      stack = new ArrayList<>();
    }

    public void push(int x) {
      stack.add(x);
    }

    public int pop() {
      return stack.remove(stack.size() - 1);
    }

    public int top() {
      return stack.get(stack.size() - 1);
    }

    public boolean empty() {
      return stack.isEmpty();
    }
  }


  /**
   * Time Complexity: O(N)
   * <p>
   * Space Complexity: O(N)
   */
  static class MyStackUsingQueue {

    private Queue<Integer> queue;
    private Queue<Integer> helperQueue;

    public MyStackUsingQueue() {
      queue = new LinkedList<>();
      helperQueue = new LinkedList<>();
    }

    public void push(int x) {
      while (!queue.isEmpty()) {
        helperQueue.offer(queue.poll());
      }
      queue.offer(x);
      while (!helperQueue.isEmpty()) {
        queue.offer(helperQueue.poll());
      }
    }

    public int pop() {
      return queue.poll();
    }

    public int top() {
      return queue.peek();
    }

    public boolean empty() {
      return queue.isEmpty();
    }
  }
}
