package sdeSheet.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStreams_295 {

  /**
   * The median is the middle value in an ordered integer list. If the size of the list is even,
   * there is no middle value, and the median is the mean of the two middle values.
   * <p>
   * For example, for arr = [2,3,4], the median is 3.
   * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
   * Implement the MedianFinder class:
   * <p>
   * MedianFinder() initializes the MedianFinder object.
   * void addNum(int num) adds the integer num from the data stream to the data structure.
   * double findMedian() returns the median of all elements so far. Answers within 10-5 of the
   * actual answer will be accepted.
   */

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    obj.addNum(3);
    obj.addNum(4);
    System.out.println(obj.findMedian());
  }

  public static class MedianFinder {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
      minHeap = new PriorityQueue<>();
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
      maxHeap.offer(num);
      // Step 2: Balance - move the largest of maxHeap to minHeap
      minHeap.offer(maxHeap.poll());

      // Step 3: If minHeap has more elements, rebalance by moving its smallest to maxHeap
      if (minHeap.size() > maxHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
      if (maxHeap.size() == minHeap.size()) {
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
      } else {
        return maxHeap.peek();
      }
    }
  }

  /**
   * Your MedianFinder object will be instantiated and called as such:
   * MedianFinder obj = new MedianFinder();
   * obj.addNum(num);
   * double param_2 = obj.findMedian();
   */
}
