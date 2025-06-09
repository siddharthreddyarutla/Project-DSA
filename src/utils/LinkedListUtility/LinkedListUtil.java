package utils.LinkedListUtility;

import java.util.List;
import java.util.Objects;

public class LinkedListUtil<T> {
  Node<T> head;
  Node<T> tail;
  int size = 0;

  public void display(Node<T> head) {
    Node<T> temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.print("END");
  }

  public Node<T> addList(List<T> list) {
    for (T item : list) {
      addLast(item);
    }
    return head;
  }

  public void addLast(T value) {
    Node<T> newNode = new Node<>(value);
    if (Objects.isNull(tail)) {
      tail = newNode;
      return;
    }
    tail.next = newNode;
    tail = newNode;
    size++;
  }
}
