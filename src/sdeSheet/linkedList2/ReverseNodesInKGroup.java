package sdeSheet.linkedList2;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.List;

public class ReverseNodesInKGroup {

  // https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/

  /**
   * Given the head of a linked list, reverse the nodes of the list k at a time, and return the
   * modified list.
   * <p>
   * k is a positive integer and is less than or equal to the length of the linked list. If the
   * number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
   * <p>
   * You may not alter the values in the list's nodes, only nodes themselves may be changed.
   * <p>
   * Example 1:
   * <p>
   * Input: head = [1,2,3,4,5], k = 2
   * Output: [2,1,4,3,5]
   * Example 2:
   * <p>
   * Input: head = [1,2,3,4,5], k = 3
   * Output: [3,2,1,4,5]
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 3L, 4L, 5L));
    customSinglyLinkedList.display(reverseKGroup(customSinglyLinkedList.head, 2));
    System.out.println();
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    customSinglyLinkedList.display(reverseKGroup(customSinglyLinkedList1.head, 3));
  }


  /**
   * Time Complexity: O(2N) The time complexity consists of actions of reversing segments of K
   * and finding the Kth node which operates in linear time. Thus, O(N) + O(N) = O(2N), which
   * simplifies to O(N).
   * <p>
   * Space Complexity: O(1) The space complexity is O(1) as the algorithm operates in place
   * without any additional space requirements.
   *
   * @param head
   * @param k
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node reverseKGroup(
      CustomSinglyLinkedList<Long>.Node head, int k) {

    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    dummy.next = head;
    CustomSinglyLinkedList<Long>.Node groupPrev = dummy;

    while (true) {
      CustomSinglyLinkedList<Long>.Node kthNode = findKthNode(groupPrev, k);
      if (kthNode == null) {
        break;
      }

      CustomSinglyLinkedList<Long>.Node groupNext = kthNode.next;
      CustomSinglyLinkedList<Long>.Node current = groupPrev.next;
      CustomSinglyLinkedList<Long>.Node prev = groupNext;

      while (current != groupNext) {
        CustomSinglyLinkedList<Long>.Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }

      CustomSinglyLinkedList<Long>.Node temp = groupPrev.next;
      groupPrev.next = kthNode;
      groupPrev = temp;
    }
    return dummy.next;
  }

  private static CustomSinglyLinkedList<Long>.Node findKthNode(
      CustomSinglyLinkedList<Long>.Node head, int k) {
    while (k > 0 && head != null) {
      head = head.next;
      k--;
    }
    return head;
  }

  /*
  Explanation:
  Input Linked List:

  LL: 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10
  k = 3
  We'll process and reverse every group of 3 nodes.

  🔁 Step-by-step Breakdown
  Initial Setup:
  dummy = -1 → 1 → 2 → 3 → 4 → 5 → 6 → 7 → 8 → 9 → 10

  groupPrev = dummy

  ✅ First Group (1 → 2 → 3)
  1. Find the kthNode:
  kthNode = 3 (the 3rd node from groupPrev = dummy)

  2. Set:
  groupNext = 4 (the node after kthNode)

  3. Reverse from 1 to 3:
  Before:
  groupPrev → 1 → 2 → 3 → groupNext (4)

  After reversal:
  groupPrev → 3 → 2 → 1 → groupNext (4)

  4. Key part:

  ListNode temp = groupPrev.next;   // temp = 1 (start of group, now tail after reverse)
  groupPrev.next = kthNode;         // dummy.next = 3
  groupPrev = temp;
            // groupPrev = 1
  Now list looks like:

  dummy → 3 → 2 → 1 → 4 → 5 → 6 → 7 → 8 → 9 → 10
  groupPrev = 1 (end of reversed group)

  ✅ Second Group (4 → 5 → 6)
  groupPrev = 1

  1. Find kthNode = 6, groupNext = 7

  2. Reverse:

  Before:
  1 → 4 → 5 → 6 → 7

  After:
  1 → 6 → 5 → 4 → 7

  3. Key part:
  temp = groupPrev.next;       // temp = 4
  groupPrev.next = kthNode;    // 1.next = 6
  groupPrev = temp;            // groupPrev = 4

  Now:

  dummy → 3 → 2 → 1 → 6 → 5 → 4 → 7 → 8 → 9 → 10
  groupPrev = 4

  ✅ Third Group (7 → 8 → 9)
  groupPrev = 4

  1. kthNode = 9, groupNext = 10

  2. Reverse:

  Before:
  4 → 7 → 8 → 9 → 10

  After:
  4 → 9 → 8 → 7 → 10

  3. Key part:

  temp = groupPrev.next;       // temp = 7
  groupPrev.next = kthNode;    // 4.next = 9
  groupPrev = temp;            // groupPrev = 7
  Now:

  dummy → 3 → 2 → 1 → 6 → 5 → 4 → 9 → 8 → 7 → 10
  groupPrev = 7

  🚫 Last Group (Only 10)
  Less than k=3 nodes left

  Stop the loop

  ✅ Final Output:
  Copy
  Edit
  3 → 2 → 1 → 6 → 5 → 4 → 9 → 8 → 7 → 10

  🧷 Now Let’s Focus on These Three Lines Again:

  ListNode temp = groupPrev.next;
  groupPrev.next = kthNode;
  groupPrev = temp;

  Explanation:
  Line	What it Does	Why It’s Important
  temp = groupPrev.next;	Stores the start of current group (before reverse)	Because this node
  becomes tail of the reversed group
  groupPrev.next = kthNode;	Connects previous group's tail to new head after reversal	So the
  reversed portion is linked correctly
  groupPrev = temp;	Moves the pointer to the end of the current group	Prepares for reversing the
  next group

  */
}
