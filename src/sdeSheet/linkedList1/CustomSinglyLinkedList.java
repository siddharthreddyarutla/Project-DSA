package sdeSheet.linkedList1;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CustomSinglyLinkedList<T> {

  public Node head;
  public Node tail;
  public Long size = 0L;

  public CustomSinglyLinkedList() {

  }

  CustomSinglyLinkedList(Long size) {
    this.size = size;
  }

  public Node getHead() {
    return head;
  }

  public class Node {
    public T value;
    public Node next;

    Node(T value) {
      this.value = value;
      this.next = null;
    }

    Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.print("END");
  }

  public void display(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + " -> ");
      temp = temp.next;
    }
    System.out.print("END");
  }

  public void addFirst(T value) {
    Node newNode = new Node(value);
    newNode.next = head;
    head = newNode;
    size++;
    if (Objects.isNull(tail)) {
      tail = head;
    }
  }

  public void addLast(T value) {
    Node newNode = new Node(value);
    if (Objects.isNull(tail)) {
      addFirst(value);
      return;
    }
    tail.next = newNode;
    tail = newNode;
    size++;
  }

  public void add(T value) {
    addLast(value);
  }

  public Long size() {
    return size;
  }

  public T removeFirst() {
    if (Objects.isNull(head)) {
      throw new NoSuchElementException();
    }
    T value = head.value;
    head = head.next;
    size--;
    return value;
  }

  public T removeLast() {
    if (Objects.isNull(tail) || Objects.isNull(head)) {
      throw new NoSuchElementException();
    }
    Node temp = head;
    for (int i = 0; i < size - 2; i++) {
      temp = temp.next;
    }
    T value = temp.next.value;
    temp.next = null;
    tail = temp;
    size--;
    return value;
  }

  public T getFirst() {
    if (Objects.isNull(head) || Objects.isNull(tail)) {
      throw new NoSuchElementException("index at :" + 0);
    }
    return head.value;
  }

  public T getLast() {
    if (Objects.isNull(head) || Objects.isNull(tail)) {
      throw new NoSuchElementException("index at :" + (size - 1));
    }
    return tail.value;
  }

  public T get(int index) {
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp.value;
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
    temp.next = new Node(value, temp.next);
    size++;
  }

  public T remove(int index) {
    if (index == 0) {
      return removeFirst();
    }
    if (index == size) {
      return removeLast();
    }
    Node temp = head;
    for (int i = 1; i < index - 1; i++) {
      temp = temp.next;
    }
    T value = temp.next.value;
    temp.next = temp.next.next;
    size--;
    return value;
  }

  public void addList(List<T> list) {
    for (T item : list) {
      addLast(item);
    }
  }

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSingleLL = new CustomSinglyLinkedList<>();
    customSingleLL.addFirst(1L);
    customSingleLL.addFirst(2L);
    customSingleLL.addFirst(3L);
    customSingleLL.add(6L);
    customSingleLL.addLast(4L);
    customSingleLL.addLast(5L);
    customSingleLL.display();
    System.out.println();
    System.out.println("Removed at first: " + customSingleLL.removeFirst());
    customSingleLL.display();
    System.out.println();
    System.out.println("Removed at last: " + customSingleLL.removeLast());
    customSingleLL.display();
    System.out.println();
    System.out.println("First element is :" + customSingleLL.getFirst());
    System.out.println("Last element is :" + customSingleLL.getLast());
    System.out.println("Element at index 2 is : " + customSingleLL.get(2));
    customSingleLL.add(7L, 2);
    customSingleLL.display();
    System.out.println();
    System.out.println("Removed element at index 2 is : " + customSingleLL.remove(2));
    customSingleLL.display();
    System.out.println();
    System.out.println("size is : " + customSingleLL.size);
    System.out.println("----------------------------------");
    CustomSinglyLinkedList<String> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.add("sid");
    customSinglyLinkedList.add("test");
    customSinglyLinkedList.display();
    System.out.println();
    System.out.println(customSinglyLinkedList.size);
  }
}
