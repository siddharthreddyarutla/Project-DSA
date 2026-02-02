package sdeSheet.stackAndQueue2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUcache_146 {

  // https://takeuforward.org/data-structure/implement-lru-cache/

  /**
   * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
   * <p>
   * Implement the LRUCache class:
   * <p>
   * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
   * int get(int key) Return the value of the key if the key exists, otherwise return -1.
   * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add
   * the key-value pair to the cache. If the number of keys exceeds the capacity from this
   * operation, evict the least recently used key.
   * The functions get and put must each run in O(1) average time complexity.
   * <p>
   * Example 1:
   * <p>
   * Input
   * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
   * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
   * Output
   * [null, null, null, 1, null, -1, null, -1, 3, 4]
   * <p>
   * Explanation
   * LRUCache lRUCache = new LRUCache(2);
   * lRUCache.put(1, 1); // cache is {1=1}
   * lRUCache.put(2, 2); // cache is {1=1, 2=2}
   * lRUCache.get(1);    // return 1
   * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
   * lRUCache.get(2);    // returns -1 (not found)
   * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
   * lRUCache.get(1);    // return -1 (not found)
   * lRUCache.get(3);    // return 3
   * lRUCache.get(4);    // return 4
   */

  public static void main(String[] args) {
    LRUCache obj = new LRUCache(2);
    obj.put(1, 1);
    obj.put(2, 2);
    obj.get(1);
    obj.put(3, 3);
    obj.get(2);
    obj.put(4, 4);
    obj.get(1);
    obj.get(3);
    obj.get(4);

    LRUCacheUsingLL lruCacheUsingLL = new LRUCacheUsingLL(1);
    lruCacheUsingLL.put(1, 1);
    lruCacheUsingLL.put(2, 2);
    lruCacheUsingLL.get(1);
    lruCacheUsingLL.put(3,3);
    lruCacheUsingLL.get(2);
    lruCacheUsingLL.put(4, 4);
    lruCacheUsingLL.get(1);
    lruCacheUsingLL.get(3);
    lruCacheUsingLL.get(4);
  }

  /**
   * Time Complexity:O(N)
   * <p>
   * Space Complexity:O(1)
   */
  static class LRUCache {

    Map<Integer, Integer> cache;
    int cap;
    Queue<Integer> queue;

    public LRUCache(int capacity) {
      cache = new HashMap<>(capacity);
      queue = new LinkedList<>();
      cap = capacity;
    }

    public int get(int key) {
      if (!cache.containsKey(key)) {
        return -1;
      }
      queue.remove(key);
      queue.offer(key);
      return cache.get(key);
    }

    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        queue.remove(key);
      } else if (cap == cache.size()) {
        cache.remove(queue.poll());
      }
      cache.put(key, value);
      queue.offer(key);
    }
  }


  /**
   * Time Complexity:O(1)
   * <p>
   * Space Complexity:O(N)
   */
  static class LRUCacheUsingLL {

    Map<Integer, Node> cache;
    int _capacity;
    Node head, tail;

    public LRUCacheUsingLL(int capacity) {
      cache = new HashMap<>(capacity);
      this._capacity = capacity;
      head = new Node(0, 0);
      tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key) {
      if (!cache.containsKey(key)) {
        return -1;
      }
      Node node = cache.get(key);
      removeNodeAtEnd(node);
      addNodeAtStart(node);
      return node.value;
    }

    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        Node node = cache.get(key);
        node.value = value;
        removeNodeAtEnd(node);
        addNodeAtStart(node);
      } else {
        if (this._capacity == cache.size()) {
          removeNodeAtEnd(tail.prev);
        }
        addNodeAtStart(new Node(key, value));
      }
    }

    public void addNodeAtStart(Node newNode) {
      cache.put(newNode.key, newNode);
      Node nodeAfterHead = head.next;
      head.next = newNode;
      newNode.next = nodeAfterHead;
      newNode.prev = head;
      nodeAfterHead.prev = newNode;
    }

    public void removeNodeAtEnd(Node node) {
      cache.remove(node.key);
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
  }


  static class Node {

    Integer key;
    Integer value;

    Node prev;
    Node next;

    public Node(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }

    public Node(Integer key, Integer value, Node prev, Node next) {
      this.key = key;
      this.value = value;
      this.prev = prev;
      this.next = next;
    }
  }
}
