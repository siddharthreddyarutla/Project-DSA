package neetCode_150.heapOrQueue;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {

  /**
   * Implement the KthLargest class:
   * <p>
   * KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of
   * test scores nums.
   * int add(int val) Adds a new test score val to the stream and returns the element
   * representing the kth largest element in the pool of test scores so far.
   * <p>
   * <p>
   * Example 1:
   * <p>
   * Input:
   * ["KthLargest", "add", "add", "add", "add", "add"]
   * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
   * <p>
   * Output: [null, 4, 5, 5, 8, 8]
   * <p>
   * Explanation:
   * <p>
   * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
   * kthLargest.add(3); // return 4
   * kthLargest.add(5); // return 5
   * kthLargest.add(10); // return 5
   * kthLargest.add(9); // return 8
   * kthLargest.add(4); // return 8
   * <p>
   * Example 2:
   * <p>
   * Input:
   * ["KthLargest", "add", "add", "add", "add"]
   * [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
   * <p>
   * Output: [null, 7, 7, 7, 8]
   * <p>
   * Explanation:
   * <p>
   * KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
   * kthLargest.add(2); // return 7
   * kthLargest.add(10); // return 7
   * kthLargest.add(9); // return 7
   * kthLargest.add(9); // return 8
   */

  public static void main(String[] args) {

  }

  class KthLargest {
    // List<Integer> elements = new ArrayList<>();
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
    int k;

    public KthLargest(int k, int[] nums) {
      this.k = k;
      for (int num : nums) {
        queue.add(num);
        if (queue.size() > k) {
          queue.poll();
        }
      }
    }

    public int add(int val) {
      queue.add(val);
      if (queue.size() > k) {
        queue.poll();
      }
      return queue.peek();
    }
  }
}
