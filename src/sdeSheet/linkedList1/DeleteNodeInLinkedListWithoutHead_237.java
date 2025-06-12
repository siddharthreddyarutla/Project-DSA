package sdeSheet.linkedList1;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeInLinkedListWithoutHead_237 {

  //  https://takeuforward.org/data-structure/delete-given-node-in-a-linked-list-o1-approach/

  /**
   * There is a singly-linked list head and we want to delete a node node in it.
   * <p>
   * You are given the node to be deleted node. You will not be given access to the first node of
   * head.
   * <p>
   * All the values of the linked list are unique, and it is guaranteed that the given node node
   * is not the last node in the linked list.
   * <p>
   * Delete the given node. Note that by deleting the node, we do not mean removing it from
   * memory. We mean:
   * <p>
   * The value of the given node should not exist in the linked list.
   * The number of nodes in the linked list should decrease by one.
   * All the values before node should be in the same order.
   * All the values after node should be in the same order.
   * Custom testing:
   * <p>
   * For the input, you should provide the entire linked list head and the node to be given node.
   * node should not be the last node of the list and should be an actual node in the list.
   * We will build the linked list and pass the node to your function.
   * The output will be the entire list after calling your function.
   * <p>
   * Example 1:
   * <p>
   * Input: head = [4,5,1,9], node = 5
   * Output: [4,1,9]
   * Explanation: You are given the second node with value 5, the linked list should become 4 ->
   * 1 -> 9 after calling your function.
   * Example 2:
   * <p>
   * Input: head = [4,5,1,9], node = 1
   * Output: [4,5,9]
   * Explanation: You are given the third node with value 1, the linked list should become 4 -> 5
   * -> 9 after calling your function.
   */

  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(4L, 5L, 1L, 9L));
    deleteNode(customSinglyLinkedList.head.next);
    customSinglyLinkedList.display();
  }

  /**
   * will give reference to what node needs to be deleted, and it won't be last node
   * <p>
   * So just copy next value and delete next node, a dumb solution
   * <p>
   * T.C = O(1)
   *
   * @param node
   */
  public static void deleteNode(CustomSinglyLinkedList<Long>.Node node) {
    node.value = node.next.value;
    node.next = node.next.next;
  }
}
