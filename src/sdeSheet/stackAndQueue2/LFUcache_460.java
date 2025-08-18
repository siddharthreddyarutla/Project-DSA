package sdeSheet.stackAndQueue2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUcache_460 {

  /**
   * Design and implement a data structure for a Least Frequently Used (LFU) cache.
   * <p>
   * Implement the LFUCache class:
   * <p>
   * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
   * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise,
   * returns -1.
   * void put(int key, int value) Update the value of the key if present, or inserts the key if
   * not already present. When the cache reaches its capacity, it should invalidate and remove
   * the least frequently used key before inserting a new item. For this problem, when there is a
   * tie (i.e., two or more keys with the same frequency), the least recently used key would be
   * invalidated.
   * To determine the least frequently used key, a use counter is maintained for each key in the
   * cache. The key with the smallest use counter is the least frequently used key.
   * <p>
   * When a key is first inserted into the cache, its use counter is set to 1 (due to the put
   * operation). The use counter for a key in the cache is incremented either a get or put
   * operation is called on it.
   * <p>
   * The functions get and put must each run in O(1) average time complexity.
   * <p>
   * Example 1:
   * <p>
   * Input
   * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
   * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
   * Output
   * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
   * <p>
   * Explanation
   * // cnt(x) = the use counter for key x
   * // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
   * LFUCache lfu = new LFUCache(2);
   * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
   * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
   * lfu.get(1);      // return 1
   * // cache=[1,2], cnt(2)=1, cnt(1)=2
   * lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
   * // cache=[3,1], cnt(3)=1, cnt(1)=2
   * lfu.get(2);      // return -1 (not found)
   * lfu.get(3);      // return 3
   * // cache=[3,1], cnt(3)=2, cnt(1)=2
   * lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
   * // cache=[4,3], cnt(4)=1, cnt(3)=2
   * lfu.get(1);      // return -1 (not found)
   * lfu.get(3);      // return 3
   * // cache=[3,4], cnt(4)=1, cnt(3)=3
   * lfu.get(4);      // return 4
   * // cache=[4,3], cnt(4)=2, cnt(3)=3
   */


  public static void main(String[] args) {

  }

  static class LFUCache {

    PriorityQueue<Node> queue;
    Map<Integer, Node> cache;
    Integer time;

    int _capacity;

    public LFUCache(int capacity) {
      this._capacity = capacity;
      cache = new HashMap<>(capacity);
      this.time = 0;
      queue = new PriorityQueue<>((a, b) -> {
        if (a.freq != b.freq) {
          return a.freq - b.freq;
        } else {
          return a.time - b.time;
        }
      });
    }

    public int get(int key) {
      if (!cache.containsKey(key)) {
        return -1;
      }
      Node node = cache.get(key);
      queue.remove(node);
      node.freq++;
      node.time = ++time;
      queue.offer(node);
      return node.value;
    }

    public void put(int key, int value) {
      if (this._capacity == 0) {
        return;
      }
      if (cache.containsKey(key)) {
        Node node = cache.get(key);
        queue.remove(node);
        node.value = value;
        node.freq++;
        node.time = ++time;
        queue.offer(node);
      } else {
        if (this._capacity == cache.size()) {
          Node node = queue.poll();
          cache.remove(node.key);
        }
        Node node = new Node(key, value, 1, ++time);
        cache.put(key, node);
        queue.offer(node);
      }
    }
  }


  static class Node {

    Integer key;
    Integer value;
    Integer freq;
    Integer time;

    public Node(Integer key, Integer value, Integer freq, Integer time) {
      this.key = key;
      this.value = value;
      this.freq = freq;
      this.time = time;
    }
  }
}
