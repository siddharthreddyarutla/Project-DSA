package StackAndQueue;

import java.util.ArrayList;
import java.util.List;

public class CustomQueue<T> {

  private List<T> queue;

  public CustomQueue() {
    queue = new ArrayList<>();
  }

  public void offer(T data) {
    queue.add(data);
  }

  public T poll() {
    return queue.remove(0);
  }

  public T peek() {
    return queue.get(0);
  }

  public boolean isEmpty() {
    return queue.isEmpty();
  }

  public void printAll() {
    for (T value : queue) {
      System.out.print(value);
    }
  }

  public static void main(String[] args) {
    CustomQueue<Integer> customQueue = new CustomQueue<>();
    customQueue.offer(1);
    customQueue.offer(2);
    customQueue.offer(3);
    customQueue.offer(4);
    customQueue.offer(5);
    customQueue.printAll();
    System.out.println();
    System.out.println(customQueue.peek());
    System.out.println(customQueue.poll());
    System.out.println(customQueue.peek());
    System.out.println(customQueue.isEmpty());
  }
}
