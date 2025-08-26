package sdeSheet.StackAndQueue;


import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> {

  private final List<T> stack;

  public CustomStack() {
    stack = new ArrayList<>();
  }


  public void push(T data) {
    stack.add(data);
  }

  public T pop() {
        return stack.remove(stack.size() - 1);
  }

  public boolean isEmpty() {
    return stack.isEmpty();
  }

  public T peek() {
    return stack.get(stack.size() - 1);
  }

  public static void main(String[] args) {
    CustomStack<Integer> customStack = new CustomStack<>();
    customStack.push(1);
    customStack.push(2);
    customStack.push(3);
    customStack.push(4);
    customStack.push(5);
    System.out.println(customStack);
    System.out.println(customStack.pop());
    System.out.println(customStack.pop());
    System.out.println(customStack.peek());
    System.out.println(customStack.isEmpty());
  }
}
