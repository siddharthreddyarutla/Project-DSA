package sdeSheet.linkedList2;

import sdeSheet.linkedList1.CustomSinglyLinkedList;
import sdeSheet.linkedList1.ReverseLinkedList_206;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList_234 {

  // https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/

  /**
   * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
   * <p>
   * Example 1:
   * <p>
   * <p>
   * Input: head = [1,2,2,1]
   * Output: true
   * Example 2:
   * <p>
   * <p>
   * Input: head = [1,2]
   * Output: false
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 2L, 1L));
    System.out.println(isPalindrome(customSinglyLinkedList.head));
    System.out.println();
    CustomSinglyLinkedList<Long> customSinglyLinkedList1 = new CustomSinglyLinkedList<>();
    customSinglyLinkedList1.addList(List.of(1L, 2L, 2L, 1L));
    System.out.println(isPalindromeOptimized(customSinglyLinkedList1.head));
  }

  /**
   * Time Complexity: O(2 * N) This is because we traverse the linked list twice: once to push
   * the values onto the stack, and once to pop the values and compare with the linked list. Both
   * traversals take O(2*N) ~ O(N) time.
   * <p>
   * Space Complexity: O(N) We use a stack to store the values of the linked list, and in the
   * worst case, the stack will have all N values,  ie. storing the complete linked list.
   *
   * @param head
   *
   * @return
   */
  public static boolean isPalindrome(CustomSinglyLinkedList<Long>.Node head) {
    Stack<Long> stack = new Stack<>();
    CustomSinglyLinkedList<Long>.Node temp = head;
    while (temp != null) {
      stack.push(temp.value);
      temp = temp.next;
    }
    temp = head;
    while (!stack.isEmpty()) {
      Long val = temp.value;
      if (val == stack.pop()) {
        temp = temp.next;
      } else {
        return false;
      }
    }
    return true;
  }

  /**
   * Time Complexity: O (2* N) The algorithm traverses the linked list twice, dividing it into
   * halves. During the first traversal, it reverses one-half of the list, and during the second
   * traversal, it compares the elements of both halves. As each traversal covers N/2 elements,
   * the time complexity is calculated as O(N/2 + N/2 + N/2 + N/2), which simplifies to O(2N),
   * ultimately representing O(N).
   * <p>
   * Space Complexity: O(1) The approach uses a constant amount of additional space regardless of
   * the size of the input linked list. It doesn't allocate any new data structures that depend
   * on the input size, resulting in a space complexity of O(1).
   *
   * @param head
   *
   * @return
   */
  public static boolean isPalindromeOptimized(CustomSinglyLinkedList<Long>.Node head) {
    if (head.next == null || head == null) {
      return true;
    }
    CustomSinglyLinkedList<Long>.Node slow = head;
    CustomSinglyLinkedList<Long>.Node fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    fast = ReverseLinkedList_206.reverseListOptimized(slow.next);
    slow = head;
    while (fast != null) {
      if (slow.value == fast.value) {
        slow = slow.next;
        fast = fast.next;
      } else {
        return false;
      }
    }
    return true;
  }
}

