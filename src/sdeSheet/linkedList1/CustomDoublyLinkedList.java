package sdeSheet.linkedList1;

import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomDoublyLinkedList<T> {

  private Node head;
  private Node tail;
  private Long size = 0L;


  public class Node {

    private T value;
    private Node prev;
    private Node next;

    Node(T value) {
      this.value = value;
      this.prev = null;
      this.next = null;
    }

    Node(T value, Node prev, Node next) {
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }

  public void addFirst(T value) {
    Node newNode = new Node(value);
    if (Objects.isNull(head)) {
      this.head = newNode;
      size++;
      return;
    }
    if (Objects.isNull(tail)) {
      this.tail = this.head;
    }
    newNode.next = this.head;
    this.head.prev = newNode;
    this.head = newNode;
    size++;
  }

  public T removeLast() {
    if (Objects.isNull(this.tail) || Objects.isNull(this.head)) {
      throw new NoSuchElementException();
    }
    Node temp = this.head;
    for (int i = 1; i < size - 1; i++) {
      temp = temp.next;
    }
    T value = temp.next.value;
    temp.next = null;
    tail = temp;
    size--;
    return value;
  }

  public void addLast(T value) {
    if (Objects.isNull(tail)) {
      addFirst(value);
      return;
    }
    Node newNode = new Node(value);
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
    size++;
  }

  public T removeFirst() {
    if (Objects.isNull(this.tail) || Objects.isNull(this.head)) {
      throw new NoSuchElementException();
    }
    T value = head.value;
    head = head.next;
    size--;
    return value;
  }

  public void add(T value, int index) {
    if (index == 0) {
      addFirst(value);
      return;
    }
    if (index == size) {
      addLast(value);
      return;
    }
    Node temp = head;
    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }
    temp.next = new Node(value, temp, temp.next);
    size++;
  }

  public T remove(int index) {
    if (index == 0) {
      return this.removeFirst();
    }
    if (index == size) {
      return this.removeLast();
    }
    Node temp = this.head;
    for (int i = 1; i < index - 1; i++) {
      temp = temp.next;
    }
    Node temp1 = temp.next.next;
    T value = temp.next.value;
    temp.next = temp1;
    temp1.prev = temp;
    size--;
    return value;
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.println("END");
  }

  public static void main(String[] args) {
    CustomDoublyLinkedList<Long> customDoublyLinkedList = new CustomDoublyLinkedList<>();
    customDoublyLinkedList.addFirst(1L);
    customDoublyLinkedList.addFirst(2L);
    customDoublyLinkedList.addFirst(3L);
    customDoublyLinkedList.display();
    System.out.println("Removed element at last: " + customDoublyLinkedList.removeLast());
    customDoublyLinkedList.display();
    customDoublyLinkedList.addLast(4L);
    customDoublyLinkedList.display();
    customDoublyLinkedList.removeFirst();
    customDoublyLinkedList.display();
    customDoublyLinkedList.add(5L, 1);
    customDoublyLinkedList.display();
    System.out.println("Removing element at index 2: " + customDoublyLinkedList.remove(2));
    customDoublyLinkedList.display();
    System.out.println("Linked list size is : " + customDoublyLinkedList.size);
  }
}
