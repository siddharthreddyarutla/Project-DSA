package sdeSheet.heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomHeap {

  public final List<Integer> heap = new ArrayList<>();

  public Integer length() {
    return heap.size();
  }

  public Integer parent(Integer index) {
    return (index - 1) / 2;
  }

  public Integer leftChild(Integer index) {
    return 2 * index + 1;
  }

  public Integer rightChild(Integer index) {
    return 2 * index + 2;
  }

  /**
   * For insert we add end of the list and heapifyUp
   * Add at end and traverse form bottom to top and compare the smallest and swap
   *
   * @param value
   */
  public void insert(Integer value) {
    if (Objects.isNull(value)) {
      return;
    }
    heap.add(value);
    heapifyUp(length() - 1);
  }

  public void heapifyUp(Integer index) {
    while (index > 0) {
      int parent = parent(index);
      if (heap.get(index) >= heap.get(parent)) {
        break;
      }
      swap(index, parent);
      index = parent;
    }
  }

  /**
   * remove element at top by updating it with the last element
   * and sort it from top to bottom
   *
   * @return
   */
  public Integer poll() {
    if (heap.isEmpty()) {
      throw new IllegalStateException("Heap is empty, cannot remove");
    }
    Integer root = heap.get(0);
    Integer lastChild = heap.remove(length() - 1);
    heap.set(0, lastChild);
    heapifyDown(0);
    return root;
  }

  public void heapifyDown(Integer index) {
    while (index < length()) {
      int leftChild = leftChild(index);
      int rightChild = rightChild(index);
      int minIndex = index;

      if (leftChild < length() && heap.get(leftChild) < heap.get(minIndex)) {
        minIndex = leftChild;
      }
      if (rightChild < length() && heap.get(rightChild) < heap.get(minIndex)) {
        minIndex = rightChild;
      }

      if (minIndex == index) {
        return;
      }
      swap(index, minIndex);
      index = minIndex;
    }
  }

  public void swap(int i, int j) {
    Integer temp = heap.get(i);
    heap.set(i, heap.get(j));
    heap.set(j, temp);
  }

  public static void main(String[] args) {
    CustomHeap customHeap = new CustomHeap();
    customHeap.insert(2);
    customHeap.insert(8);
    customHeap.insert(5);
    customHeap.insert(6);
    customHeap.insert(4);
    System.out.println(customHeap.heap);

    System.out.println(customHeap.poll());
    System.out.println(customHeap.heap);

    customHeap.insert(10);
    System.out.println(customHeap.heap);
  }
}
