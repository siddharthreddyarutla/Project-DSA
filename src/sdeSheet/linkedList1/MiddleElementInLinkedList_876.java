package sdeSheet.linkedList1;

import java.util.List;

public class MiddleElementInLinkedList_876 {

  // https://takeuforward.org/data-structure/find-middle-element-in-a-linked-list/

  /**
   * Given the head of a linked list, the task is to find the middle. For example, the middle of
   * 1-> 2->3->4->5 is 3. If there are two middle nodes (even count), return the second middle.
   * For example, middle of 1->2->3->4->5->6 is 4.
   * <p>
   * Examples:
   * <p>
   * Input: Linked list: 1->2->3->4->5
   * Output: 3
   * <p>
   * Explanation: The given linked list is 1->2->3->4->5 and its middle is 3.
   * Input: Linked list: 2->4->6->7->5->1
   * Output: 7
   * <p>
   * Explanation: The given linked list is 2->4->6->7->5->1 and its middle is 7.
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 3L, 4L, 5L));
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(2L, 4L, 6L, 7L, 5L, 1L));
    System.out.println(getMiddle(customSinglyLinkedList.head));
    System.out.println(getMiddleOptimized(customSinglyLinkedList1.head));
  }

  /***
   * Time Complexity: O(N+N/2) The code traverses the entire linked list once and half times and
   * then only half in the second iteration, first to count the number of nodes then then again
   * to get to the middle node. Therefore, the time complexity is linear, O(N + N/2) ~ O(N).
   *
   * Space Complexity : O(1) There is constant space complexity because it uses a constant amount
   * of extra space regardless of the size of the linked list. We only use a few variables to
   * keep track of the middle position and traverse the list, and the memory required for these
   * variables does not depend on the size of the list.
   * @param head
   * @return
   */
  public static Long getMiddle(CustomSinglyLinkedList<Long>.Node head) {
    CustomSinglyLinkedList<Long>.Node temp = head;
    int count = 0;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    int mid = (count / 2);
    temp = head;
    while (mid > 0) {
      temp = temp.next;
      mid--;
    }
    return temp.value;
  }

  /**
   * Time Complexity: O(N/2) The algorithm requires the 'fast' pointer to reach the end of the
   * list which it does after approximately N/2 iterations (where N is the total number of nodes)
   * . Therefore, the maximum number of iterations needed to find the middle node is proportional
   * to the number of nodes in the list, making the time complexity linear, or O(N/2) ~ O(N).
   * <p>
   * Space Complexity : O(1) There is constant space complexity because it uses a constant amount
   * of extra space regardless of the size of the linked list. We only use a few variables to
   * keep track of the middle position and traverse the list, and the memory required for these
   * variables does not depend on the size of the list.
   *
   * @param head
   *
   * @return
   */
  public static Long getMiddleOptimized(CustomSinglyLinkedList<Long>.Node head) {
    CustomSinglyLinkedList<Long>.Node slow = head;
    CustomSinglyLinkedList<Long>.Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.value;
  }
}
