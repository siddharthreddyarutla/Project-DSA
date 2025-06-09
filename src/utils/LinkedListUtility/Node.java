package utils.LinkedListUtility;

public class Node<T> {

  public final T value;
  public Node<T> prev;
  public Node<T> next;

  public Node(T value) {
    this.value = value;
    this.prev = null;
    this.next = null;
  }

  public Node(T value, Node<T> prev, Node<T> next) {
    this.value = value;
    this.prev = prev;
    this.next = next;
  }
}
