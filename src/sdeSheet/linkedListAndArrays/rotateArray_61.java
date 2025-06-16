package sdeSheet.linkedListAndArrays;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.List;

public class rotateArray_61 {

  // https://takeuforward.org/data-structure/rotate-a-linked-list/

  /**
   * Given the head of a linked list, rotate the list to the right by k places.
   * <p>
   * Example 1:
   * Input: head = [1,2,3,4,5], k = 2
   * Output: [4,5,1,2,3]
   * <p>
   * Example 2:
   * Input: head = [0,1,2], k = 4
   * Output: [2,0,1]
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 3L, 4L, 5L));
    customSinglyLinkedList.display(rotateRight(customSinglyLinkedList.head, 2));
    System.out.println();
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(0L, 1L, 2L));
    customSinglyLinkedList.display(rotateRightSlightBetter(customSinglyLinkedList1.head, 4));
  }

  /**
   * Time Complexity: O(2 length of the linked list)
   * <p>
   * Space Complexity: O(1)
   * <p>
   * Reason: No extra data structure is used for computation.
   *
   * @param head
   * @param k
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node rotateRight(
      CustomSinglyLinkedList<Long>.Node head, int k) {
    // Edge cases
    if (head == null) {
      return null;
    }
    if (k == 0) {
      return head;
    }

    // Finding the length of the list
    int cnt = 0;
    CustomSinglyLinkedList<Long>.Node temp = head;
    while (temp != null) {
      temp = temp.next;
      cnt++;
    }

    // if k is more than cnt
    k = k % cnt;

    // find new tail index
    int newTailIndex = cnt - k;

    // navigate till new tail
    temp = head;
    for (int i = 1; i < newTailIndex; i++) {
      temp = temp.next;
    }

    // remove the link and make a new tail before that store next head
    CustomSinglyLinkedList<Long>.Node newHead = temp.next;
    temp.next = null;

    // navigate till end and link to head
    temp = newHead;
    while (temp.next != null) {
      temp = temp.next;
    }

    temp.next = head;
    return newHead;
  }

  /**
   * Time Complexity: O(length of list) + O(length of list - (length of list%k))
   * <p>
   * Reason: O(length of the list) for calculating the length of the list. O(length of the list -
   * (length of list%k)) for breaking link.
   * <p>
   * Space Complexity: O(1)
   * <p>
   * Reason: No extra data structure is used for computation.
   *
   * @param head
   * @param k
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node rotateRightSlightBetter(
      CustomSinglyLinkedList<Long>.Node head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }
    //calculating length
    CustomSinglyLinkedList<Long>.Node temp = head;
    int length = 1;
    while (temp.next != null) {
      ++length;
      temp = temp.next;
    }
    //link last node to first node
    temp.next = head;
    k = k % length; //when k is more than length of list
    int end = length - k; //to get end of the list
    while (end-- != 0) {
      temp = temp.next;
    }
    //breaking last node link and pointing to NULL
    head = temp.next;
    temp.next = null;

    return head;
  }
}
