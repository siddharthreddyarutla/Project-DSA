package sdeSheet.linkedList1;

import java.util.List;
import java.util.NavigableMap;
import java.util.Objects;

public class MergeTwoSortedLinkedList_21 {

  // https://takeuforward.org/data-structure/merge-two-sorted-linked-lists/

  /**
   * You are given the heads of two sorted linked lists list1 and list2.
   * <p>
   * Merge the two lists into one sorted list. The list should be made by splicing together the
   * nodes of the first two lists.
   * Return the head of the merged linked list.
   * <p>
   * Example 1:
   * <p>
   * Input: list1 = [1,2,4], list2 = [1,3,4]
   * Output: [1,1,2,3,4,4]
   * <p>
   * Example 2:
   * Input: list1 = [], list2 = []
   * Output: []
   * <p>
   * Example 3:
   * Input: list1 = [], list2 = [0]
   * Output: [0]
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(1L, 2L, 4L));
    CustomSinglyLinkedList<Long> customSinglyLinkedList2 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList2.addList(List.of(1L, 3L, 4L));
    customSinglyLinkedList1.display(
        mergeTwoLists(customSinglyLinkedList1.head, customSinglyLinkedList2.head));
    System.out.println();
    customSinglyLinkedList1.display(
        mergeTwoListsSame(customSinglyLinkedList1.head, customSinglyLinkedList2.head));
    System.out.println();
    customSinglyLinkedList1.display(
        mergeTwoListsOptimized(customSinglyLinkedList1.head, customSinglyLinkedList2.head));
  }

  /**
   * Time Complexity: O(N1+N2) where N1 is the number of nodes in the first linked list and N1 in
   * the second linked list as we traverse both linked lists in a single pass for merging without
   * any additional loops or nested iterations.
   * <p>
   * Space Complexity : O(1) as no additional data structures or space is allocated for storing
   * data, only a constant space for pointers to maintain for traversing the linked list.
   *
   * @param list1
   * @param list2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node mergeTwoLists(
      CustomSinglyLinkedList<Long>.Node list1, CustomSinglyLinkedList<Long>.Node list2) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    while (list1 != null && list2 != null) {
      if (list1.value > list2.value) {
        customSinglyLinkedList.addLast(list2.value);
        list2 = list2.next;
      } else if (list1.value < list2.value) {
        customSinglyLinkedList.addLast(list1.value);
        list1 = list1.next;
      } else {
        customSinglyLinkedList.addLast(list1.value);
        customSinglyLinkedList.addLast(list2.value);
        list1 = list1.next;
        list2 = list2.next;
      }
    }

    while (list1 != null) {
      customSinglyLinkedList.addLast(list1.value);
      list1 = list1.next;
    }
    while (list2 != null) {
      customSinglyLinkedList.addLast(list2.value);
      list2 = list2.next;
    }
    return customSinglyLinkedList.head;
  }

  /**
   * Same but without the global variable created a dummy and used
   *
   * @param list1
   * @param list2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node mergeTwoListsSame(
      CustomSinglyLinkedList<Long>.Node list1, CustomSinglyLinkedList<Long>.Node list2) {
    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    CustomSinglyLinkedList<Long>.Node tail = dummy;
    while (list1 != null && list2 != null) {
      if (list1.value < list2.value) {
        tail.next = new CustomSinglyLinkedList<Long>().new Node(list1.value);
        list1 = list1.next;
      } else {
        tail.next = new CustomSinglyLinkedList<Long>().new Node(list2.value);
        list2 = list2.next;
      }
      tail = tail.next;
    }

    while (list1 != null) {
      tail.next = new CustomSinglyLinkedList<Long>().new Node(list1.value);
      list1 = list1.next;
      tail = tail.next;
    }
    while (list2 != null) {
      tail.next = new CustomSinglyLinkedList<Long>().new Node(list2.value);
      list2 = list2.next;
      tail = tail.next;
    }
    return dummy.next;
  }

  /**
   * If modifying the original lists is allowed, you can reuse the existing nodes instead of
   * creating new ones:
   *
   * @param list1
   * @param list2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node mergeTwoListsOptimized(
      CustomSinglyLinkedList<Long>.Node list1, CustomSinglyLinkedList<Long>.Node list2) {
    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    CustomSinglyLinkedList<Long>.Node tail = dummy;
    while (list1 != null && list2 != null) {
      if (list1.value < list2.value) {
        tail.next = new CustomSinglyLinkedList<Long>().new Node(list1.value);
        list1 = list1.next;
      } else {
        tail.next = new CustomSinglyLinkedList<Long>().new Node(list2.value);
        list2 = list2.next;
      }
      tail = tail.next;
    }
    tail.next = Objects.isNull(list1) ? list2 : list1;
    return dummy.next;
  }
}
