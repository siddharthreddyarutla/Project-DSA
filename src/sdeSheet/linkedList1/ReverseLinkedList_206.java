package sdeSheet.linkedList1;


import java.util.List;
import java.util.Stack;

public class ReverseLinkedList_206 {

  // https://takeuforward.org/data-structure/reverse-a-linked-list/

  /**
   * Given the head of a singly linked list, reverse the list, and return the reversed list.
   * <p>
   * https://leetcode.com/problems/reverse-linked-list/description/
   */


  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 3L, 4L, 5L));
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(1L, 2L, 3L, 4L, 5L));
    customSinglyLinkedList.display(reverseList(customSinglyLinkedList.getHead()));
    System.out.println();
    customSinglyLinkedList.display(reverseListOptimized(customSinglyLinkedList1.getHead()));
  }

  /**
   * Time Complexity: O(2N) This is because we traverse the linked list twice: once to push the
   * values onto the stack, and once to pop the values and update the linked list. Both
   * traversals take O(N) time, hence time complexity  O(2N) ~ O(N).
   * <p>
   * Space Complexity: O(N) We use a stack to store the values of the linked list, and in the
   * worst case, the stack will have all N values,  ie. storing the complete linked lis
   *
   * @param head
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node reverseList(
      CustomSinglyLinkedList<Long>.Node head) {
    CustomSinglyLinkedList<Long>.Node temp = head;
    Stack<Long> stack = new Stack<>();
    while (null != temp) {
      stack.push(temp.value);
      temp = temp.next;
    }
    temp = head;
    while (!stack.empty()) {
      temp.value = stack.pop();
      temp = temp.next;
    }
    return head;
  }

  /*
  Other way of doing this

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    Stack<Integer> stack = new Stack<>();
    ListNode temp = head;
    while (temp != null) {
      stack.push(temp.val);
      temp = temp.next;
    }

    ListNode reversedLL = new ListNode(stack.pop());
    temp = reversedLL;
    while (!stack.isEmpty()) {
      ListNode newNode = new ListNode(stack.pop());
      temp.next = newNode;
      temp = temp.next;
    }
    return reversedLL;
  }
  */

  public static CustomSinglyLinkedList<Long>.Node reverseListOptimized(
      CustomSinglyLinkedList<Long>.Node head) {
    CustomSinglyLinkedList<Long>.Node prev = null;
    CustomSinglyLinkedList<Long>.Node temp = head;
    while (null != temp) {
      CustomSinglyLinkedList<Long>.Node next = temp.next;
      temp.next = prev;
      prev = temp;
      temp = next;
    }
    return prev;
  }
}
