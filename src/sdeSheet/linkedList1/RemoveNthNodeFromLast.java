package sdeSheet.linkedList1;

import java.util.List;

public class RemoveNthNodeFromLast {

  // https://takeuforward.org/data-structure/remove-n-th-node-from-the-end-of-a-linked-list/

  /**
   * Given the head of a linked list, remove the nth node from the end of the list and return its
   * head.
   * <p>
   * Example 1:
   * <p>
   * Input: head = [1,2,3,4,5], n = 2
   * Output: [1,2,3,5]
   * Example 2:
   * <p>
   * Input: head = [1], n = 1
   * Output: []
   * Example 3:
   * <p>
   * Input: head = [1,2], n = 1
   * Output: [1]
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L));
    customSinglyLinkedList.display(removeNthFromEnd(customSinglyLinkedList.head, 2));
    System.out.println();
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(1L, 2L));
    customSinglyLinkedList.display(removeNthFromEndOptimized(customSinglyLinkedList1.head, 2));
  }

  /**
   * Time & Space Complexity:
   * Time: O(N)
   * Space: O(1)
   *
   * @param head
   * @param n
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node removeNthFromEnd(
      CustomSinglyLinkedList<Long>.Node head, int n) {
    int count = 0;
    CustomSinglyLinkedList<Long>.Node temp = head;
    CustomSinglyLinkedList<Long>.Node result = temp;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    if (count == n) {
      return head.next;
    }
    n = count - n - 1;
    temp = head;
    while (n > 0) {
      temp = temp.next;
      n--;
    }
    temp.next = temp.next.next;
    return result;
  }

  public static CustomSinglyLinkedList<Long>.Node removeNthFromEndOptimized(
      CustomSinglyLinkedList<Long>.Node head, int n) {
    CustomSinglyLinkedList<Long>.Node slow = head;
    CustomSinglyLinkedList<Long>.Node fast = head;
    while (n > 0) {
      fast = fast.next;
      n--;
    }
    if (fast == null) {
      return head.next;
    }
    while(fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }
    slow.next = slow.next.next;
    return head;
  }
}
