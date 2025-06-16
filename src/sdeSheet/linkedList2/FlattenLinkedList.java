package sdeSheet.linkedList2;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.ArrayList;
import java.util.Collections;

public class FlattenLinkedList {

  // https://takeuforward.org/data-structure/flattening-a-linked-list/

  /**
   * Given a linked list containing n head nodes where every node in the linked list contains two
   * pointers:
   * (i) next points to the next node in the list.
   * (ii) bottom pointer to a sub-linked list where the current node is the head.
   * Each of the sub-linked lists nodes and the head nodes are sorted in ascending order based on
   * their data.
   * Your task is to flatten the linked list such that all the nodes appear in a single level
   * while maintaining the sorted order.
   * <p>
   * Note:
   * 1. ↓ represents the bottom pointer and -> represents the next pointer.
   * 2. The flattened list will be printed using the bottom pointer instead of the next pointer.
   * <p>
   * Examples:
   * <p>
   * Input:
   * <p>
   * Output: 5-> 7-> 8-> 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
   * Explanation:
   * Bottom pointer of 5 is pointing to 7.
   * Bottom pointer of 7 is pointing to 8.
   * Bottom pointer of 8 is pointing to 10 and so on.
   */

  public static void main(String[] args) {

  }


  /**
   * Time Complexity: O(N*M) + O(N*M log(N*M)) + O(N*M)where N is the length of the linked list
   * along the next pointer and M is the length of the linked list along the child pointer.
   * <p>
   * O(N*M) as we traverse through all the elements, iterating through ‘N’ nodes along the next
   * pointer and ‘M’ nodes along the child pointer.
   * O(N*M log(N*M)) as we sort the array containing N*M (total) elements.
   * O(N*M) as we reconstruct the linked list from the sorted array by iterating over the N*M
   * elements of the array.
   * Space Complexity : O(N*M) + O(N*M)where N is the length of the linked list along the next
   * pointer and M is the length of the linked list along the child pointer.
   * <p>
   * O(N*M) for storing all the elements in an additional array for sorting.
   * O(N*M) to reconstruct the linked list from the array after sorting
   *
   * @param root
   *
   * @return
   */
  private static CustomSinglyLinkedList<Long>.Node flatten(CustomSinglyLinkedList<Long>.Node root) {
    ArrayList<Long> list = new ArrayList<>();
    CustomSinglyLinkedList<Long>.Node head = root;

    while (head != null) {
      CustomSinglyLinkedList<Long>.Node child = head;
      while (child != null) {
        list.add(child.value);
        child = child.bottom;
      }
      head = head.next;
    }

    Collections.sort(list);

    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    CustomSinglyLinkedList<Long>.Node current = dummy;
    for (Long val : list) {
      current.bottom = new CustomSinglyLinkedList<Long>().new Node(val);
      current = current.bottom;
    }
    return dummy.bottom;
  }

  /**
   * Time Complexity: O( N*(2M) ) ~ O(2 N*M)where N is the length of the linked list along the
   * next pointer and M is the length of the linked list along the child pointers.
   * <p>
   * The merge operation in each recursive call takes time complexity proportional to the length
   * of the linked lists being merged as they have to iterate over the entire lists. Since the
   * vertical depth of the linked lists is assume to be M, the time complexity for a single merge
   * operation is proportional to O(2*M).
   * This operation operation is performed N number of times (to each and every node along the
   * next pointer list) hence the resultant time complexity becomes: O(N* 2M).
   * Space Complexity : O(1) as this algorithm uses no external space or additional data
   * structures to store values. But a recursive stack uses O(N) space to build the recursive
   * calls for each node along the next pointer list.
   *
   * @param root
   *
   * @return
   */
  private static CustomSinglyLinkedList<Long>.Node flattenOptimized(
      CustomSinglyLinkedList<Long>.Node root) {
    if (root == null || root.next == null) {
      return root;
    }

    root.next = flatten(root.next);
    root = merge(root, root.next);
    return root;
  }

  public static CustomSinglyLinkedList<Long>.Node merge(CustomSinglyLinkedList<Long>.Node l1,
      CustomSinglyLinkedList<Long>.Node l2) {
    CustomSinglyLinkedList<Long>.Node dummy = new CustomSinglyLinkedList<Long>().new Node(-1L);
    CustomSinglyLinkedList<Long>.Node current = dummy;

    while (l1 != null && l2 != null) {
      if (l1.value < l2.value) {
        current.bottom = l1;
        l1 = l1.bottom;
      } else {
        current.bottom = l2;
        l2 = l2.bottom;
      }
      current = current.bottom;
      if (l1 != null) {
        current.bottom = l1;
      }
      if (l2 != null) {
        current.bottom = l2;
      }
    }
    return dummy.bottom;
  }
}
