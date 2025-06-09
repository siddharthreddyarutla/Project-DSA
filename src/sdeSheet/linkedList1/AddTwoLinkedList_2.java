package sdeSheet.linkedList1;

import java.util.List;

public class AddTwoLinkedList_2 {

  // https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/

  /**
   * You are given two non-empty linked lists representing two non-negative integers. The digits
   * are stored in reverse order, and each of their nodes contains a single digit. Add the two
   * numbers and return the sum as a linked list.
   * <p>
   * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   * <p>
   * Example 1:
   * <p>
   * Input: l1 = [2,4,3], l2 = [5,6,4]
   * Output: [7,0,8]
   * Explanation: 342 + 465 = 807.
   * Example 2:
   * <p>
   * Input: l1 = [0], l2 = [0]
   * Output: [0]
   * Example 3:
   * <p>
   * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
   * Output: [8,9,9,9,0,0,0,1]
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(2L, 4L, 3L));
    CustomSinglyLinkedList<Long> customSinglyLinkedList2 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList2.addList(List.of(5L, 6L, 4L));
    customSinglyLinkedList1.display(
        addTwoNumbers(customSinglyLinkedList1.head, customSinglyLinkedList2.head));
  }

  /**
   * Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2
   * respectively, the algorithm above iterates at most max(m,n) times.
   * <p>
   * Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.
   *
   * @param l1
   * @param l2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node addTwoNumbers(
      CustomSinglyLinkedList<Long>.Node l1, CustomSinglyLinkedList<Long>.Node l2) {
    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    CustomSinglyLinkedList<Long>.Node current = dummy;
    long carry = 0L;

    while (l1 != null || l2 != null || carry != 0L) {
      long l1val = (l1 != null) ? l1.value : 0;
      long l2val = (l2 != null) ? l2.value : 0;

      long sum = l1val + l2val + carry;
      Long digit = sum % 10;
      carry = sum / 10;

      current.next = new CustomSinglyLinkedList<Long>().new Node(digit);
      current = current.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    return dummy.next;
  }
}