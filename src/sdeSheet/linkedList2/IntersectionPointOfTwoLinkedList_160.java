package sdeSheet.linkedList2;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.HashSet;
import java.util.List;

public class IntersectionPointOfTwoLinkedList_160 {

  // https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/

  /**
   * Given the heads of two singly linked-lists headA and headB, return the node at which the two
   * lists intersect. If the two linked lists have no intersection at all, return null.
   * <p>
   * For example, the following two linked lists begin to intersect at node c1:
   * <p>
   * The test cases are generated such that there are no cycles anywhere in the entire linked
   * structure.
   * <p>
   * Note that the linked lists must retain their original structure after the function returns.
   * <p>
   * Example 1:
   * <p>
   * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
   * Output: Intersected at '8'
   * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two
   * lists intersect).
   * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
   * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected
   * node in B.
   * - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B
   * (2nd node in A and 3rd node in B) are different node references. In other words, they point
   * to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A
   * and 4th node in B) point to the same location in memory.
   * Example 2:
   * <p>
   * <p>
   * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
   * Output: Intersected at '2'
   * Explanation: The intersected node's value is 2 (note that this must not be 0 if the two
   * lists intersect).
   * From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There
   * are 3 nodes before the intersected node in A; There are 1 node before the intersected node
   * in B.
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    CustomSinglyLinkedList<Long> customSinglyLinkedList2 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(4L, 1L, 8L, 4L, 5L));
    customSinglyLinkedList2.addList(List.of(5L, 6L, 1L, 8L, 4L, 5L));
    customSinglyLinkedList2.display(
        getIntersectionNode(customSinglyLinkedList1.head, customSinglyLinkedList2.head));
  }

  /**
   * Time Complexity: O(m*n)
   * <p>
   * Reason: For each node in list 2 entire lists 1 are iterated.
   * <p>
   * Space Complexity: O(1)
   *
   * @param headA
   * @param headB
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node getIntersectionNode(
      CustomSinglyLinkedList<Long>.Node headA, CustomSinglyLinkedList<Long>.Node headB) {
    CustomSinglyLinkedList<Long>.Node temp1 = headA;
    CustomSinglyLinkedList<Long>.Node temp2;
    while (temp1 != null) {
      temp2 = headB;
      while (temp2 != null) {
        if (temp1 == temp2) {
          return temp1;
        }
        temp2 = temp2.next;
      }
      temp1 = temp1.next;
    }
    return null;
  }

  /**
   * Time Complexity: O(n+m)
   * <p>
   * Reason: Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m).
   * <p>
   * Space Complexity: O(n)
   * <p>
   * Reason: Storing list 1 node address in HashSet.
   *
   * @param head1
   * @param head2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node intersectionPresentBetter(
      CustomSinglyLinkedList<Long>.Node head1, CustomSinglyLinkedList<Long>.Node head2) {
    HashSet<CustomSinglyLinkedList<Long>.Node> st = new HashSet<>();
    while (head1 != null) {
      st.add(head1);
      head1 = head1.next;
    }
    while (head2 != null) {
      if (st.contains(head2)) {
        return head2;
      }
      head2 = head2.next;
    }
    return null;
  }

  /**
   * Time Complexity: O(2*max(length of list1,length of list2))
   * <p>
   * Reason: Uses the same concept of the difference of lengths of two lists.
   * <p>
   * Space Complexity: O(1)
   *
   * @param head1
   * @param head2
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node intersectionPresentOptimal(
      CustomSinglyLinkedList<Long>.Node head1, CustomSinglyLinkedList<Long>.Node head2) {
    CustomSinglyLinkedList<Long>.Node temp1 = head1;
    CustomSinglyLinkedList<Long>.Node temp2 = head2;
    while (temp1 != temp2) {
      temp1 = temp1 == null ? head2 : temp1.next;
      temp2 = temp2 == null ? head1 : temp2.next;
    }
    return temp1;
  }
}
