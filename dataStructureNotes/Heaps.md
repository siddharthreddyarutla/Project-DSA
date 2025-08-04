# Heaps

A heap is a specialized binary tree-based data structure that satisfies the heap property. It is widely used in solving Data Structures and Algorithms (DSA) problems involving priority queues, sorting, and efficient minimum/maximum retrieval.


## What Is a Heap?

> A heap is a complete binary tree (all levels are filled except possibly the last, and nodes are as far left as possible), and it follows one of these properties:


### 1. Min-Heap

* **Property**: The value of each node is less than or equal to its children.
* Use **case**: Used when you need to quickly access the smallest element. 
* **Example**
```json
    1
   / \
  3   5
 / \
4   8
```


### 2. Max-Heap

* **Property**: The value of each node is greater than or equal to its children.
* **Use case**: Used when you need to quickly access the largest element.
* Example:
```json
    9
   / \
  7   6
 / \
5   3

```

## 🔹 How Is Heap Implemented?

Though it's a tree conceptually, it’s commonly implemented as an array.

For a node at index i:

1. Left child index: 2*i + 1
2. Right child index: 2*i + 2
3. Parent index: (i - 1) / 2

Example (Min-Heap in Array):

Tree:
```json
     2
    / \
   4   5
  / \
 6   8

```

Array: [2, 4, 5, 6, 8]


## 🛠️ Operations in Heap

| Operation | Time Complexity | Description                            |
| --------- | --------------- | -------------------------------------- |
| Insert    | O(log N)        | Add new node at end and **heapify up** |
| Delete    | O(log N)        | Remove root and **heapify down**       |
| Peek      | O(1)            | Get min (min-heap) or max (max-heap)   |
| Heapify   | O(log N)        | Maintain heap property after changes   |


## ✅ Heap Applications in DSA

1. Priority Queues (e.g., Dijkstra’s algorithm)
2. Heap Sort (Time: O(N log N))
3. Kth Largest/Smallest Element
4. Median of a Stream
5. Top K Elements
6. Merging K Sorted Lists


## 🧠 Solving DSA Problems Using Heap


### 1. Java PriorityQueue (Min-Heap by Default)

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
minHeap.add(5);
minHeap.add(2);
minHeap.add(8);
System.out.println(minHeap.poll()); // 2

```

### 2. Max-Heap in Java

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
maxHeap.add(5);
maxHeap.add(2);
maxHeap.add(8);
System.out.println(maxHeap.poll()); // 8
```

