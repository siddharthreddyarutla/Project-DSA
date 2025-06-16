package sdeSheet.linkedListAndArrays;

import sdeSheet.linkedList1.CustomSinglyLinkedList;

import java.util.HashMap;
import java.util.List;

public class DeepCopyOfLL_138 {

  // https://takeuforward.org/data-structure/clone-linked-list-with-random-and-next-pointer/

  /**
   * A linked list of length n is given such that each node contains an additional random
   * pointer, which could point to any node in the list, or null.
   * <p>
   * Construct a deep copy of the list. The deep copy should consist of exactly n brand new
   * nodes, where each new node has its value set to the value of its corresponding original node
   * . Both the next and random pointer of the new nodes should point to new nodes in the copied
   * list such that the pointers in the original list and copied list represent the same list
   * state. None of the pointers in the new list should point to nodes in the original list.
   * <p>
   * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then
   * for the corresponding two nodes x and y in the copied list, x.random --> y.
   * <p>
   * Return the head of the copied linked list.
   * <p>
   * <p>
   * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
   * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
   */


  public static void main(String[] args) {
    CustomSinglyLinkedList<Long> customSinglyLinkedList = new CustomSinglyLinkedList<>();
    customSinglyLinkedList.addList(List.of(1L, 2L, 3L, 4L, 5L));
    customSinglyLinkedList.display(copyRandomList(customSinglyLinkedList.head));
  }

  /**
   * Time Complexity: O(2N) where N is the number of nodes in the linked list. The linked list is
   * traversed twice, once for creating copies of each node and for the second time to set the
   * next and random pointers for each copied node. The time to access the nodes in the map is O
   * (1) due to hashing.
   * <p>
   * Space Complexity : O(N)+O(N)where N is the number of nodes in the linked list as all nodes
   * are stored in the map to maintain mappings and the copied linked lists takes O(N) space as
   * well.
   *
   * @param head
   *
   * @return
   */
  public static CustomSinglyLinkedList<Long>.Node copyRandomList(
      CustomSinglyLinkedList<Long>.Node head) {
    HashMap<CustomSinglyLinkedList<Long>.Node, CustomSinglyLinkedList<Long>.Node> hash =
        new HashMap<>();
    CustomSinglyLinkedList<Long>.Node temp = head;
    while (temp != null) {
      CustomSinglyLinkedList<Long>.Node copy =
          new CustomSinglyLinkedList<Long>().new Node(temp.value);
      hash.put(temp, copy);
      temp = temp.next;
    }

    temp = head;
    while (temp != null) {
      CustomSinglyLinkedList<Long>.Node copyNode = hash.get(temp);
      copyNode.next = hash.get(temp.next);
      copyNode.bottom = hash.get(temp.bottom);
      temp = temp.next;
    }
    return hash.get(head);
  }
}
