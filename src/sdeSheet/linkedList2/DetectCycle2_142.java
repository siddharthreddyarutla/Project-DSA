package sdeSheet.linkedList2;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.HashMap;
import java.util.List;

public class DetectCycle2_142 {

  // https://takeuforward.org/data-structure/starting-point-of-loop-in-a-linked-list/

  /**
   * Given the head of a linked list, return the node where the cycle begins. If there is no
   * cycle, return null.
   * <p>
   * There is a cycle in a linked list if there is some node in the list that can be reached
   * again by continuously following the next pointer. Internally, pos is used to denote the
   * index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is
   * no cycle. Note that pos is not passed as a parameter.
   * <p>
   * Do not modify the linked list.
   * <p>
   * Example 1:
   * <p>
   * Input: head = [3,2,0,-4], pos = 1
   * Output: tail connects to node index 1
   * Explanation: There is a cycle in the linked list, where tail connects to the second node.
   * Example 2:
   * <p>
   * Input: head = [1,2], pos = 0
   * Output: tail connects to node index 0
   * Explanation: There is a cycle in the linked list, where tail connects to the first node.
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    CustomSinglyLinkedList<Long> customSinglyLinkedList2 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(4L, 1L, 8L, 4L, 5L));
    customSinglyLinkedList2.addList(List.of(5L, 6L, 1L, 8L, 4L, 5L));
    customSinglyLinkedList2.display(detectCycle(customSinglyLinkedList1.getHead()));
  }


  /**
   * Time Complexity: O(N) The code traverses the entire linked list once, where 'N' is the
   * number of nodes in the list. Therefore, the time complexity is linear, O(N).
   * <p>
   * Space Complexity : O(N) The code uses a hash map/dictionary to store encountered nodes,
   * which can take up to O(N) additional space, where 'n' is the number of nodes in the list.
   * Hence, the space complexity is O(N) due to the use of the map to track nodes.
   *
   * @param head
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node detectCycle(
      CustomSinglyLinkedList<Long>.Node head) {
    HashMap<CustomSinglyLinkedList<Long>.Node, Integer> hash = new HashMap<>();
    CustomSinglyLinkedList<Long>.Node temp = head;
    while (temp != null) {
      if (hash.containsKey(temp)) {
        return temp;
      }
      hash.put(temp, 1);
      temp = temp.next;
    }
    return null;
  }

  /**
   * Time Complexity: O(N) The code traverses the entire linked list once, where 'n' is the
   * number of nodes in the list. This traversal has a linear time complexity, O(n).
   * <p>
   * Space Complexity : O(1) The code uses only a constant amount of additional space, regardless
   * of the linked list's length. This is achieved by using two pointers (slow and fast) to
   * detect the loop without any significant extra memory usage, resulting in constant space
   * complexity, O(1).
   *
   * @param head
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node detectCycleOptimized(
      CustomSinglyLinkedList<Long>.Node head) {
    CustomSinglyLinkedList<Long>.Node slow = head;
    CustomSinglyLinkedList<Long>.Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
