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


### When to use what

Great question 👌 — this is a key interview insight.

---

### 🔑 Why **min-heap of size k** is preferred for *Top K Frequent*:

1. **Max-heap approach (naïve)**

    * Build a max-heap of all `n` unique words.
    * Pop `k` times.
    * Time: **O(n log n + k log n)** (building + popping).
    * Space: **O(n)**.

2. **Min-heap of size k approach (optimized)**

    * Keep a heap of size `k`.
    * For each word:

        * Push into heap.
        * If heap size > `k`, pop the *smallest* (least frequent).
    * End: heap contains exactly the **k most frequent** words.
    * Time: **O(n log k)** (since each push/pop is `log k`, not `log n`).
    * Space: **O(k)** for the heap.

---

### ✅ Example to make it clear

Suppose we want **top 3 frequent words**.

Frequencies:

```
a → 100
b → 50
c → 10
d → 9
e → 1
```

* **Max-heap**:

    * Insert all 5 → O(5 log 5).
    * Pop 3 → O(3 log 5).
    * Heap stored all 5, even though we only needed top 3.

* **Min-heap of size 3**:

    * Insert `a, b, c` → heap = {a=100, b=50, c=10}.
    * See `d=9` → smaller than heap min (`10`), so ignore.
    * See `e=1` → smaller than heap min, ignore.
    * Done → heap has {a, b, c}, the correct top 3.
    * Never wasted time storing `d` or `e`.

👉 Much more efficient when `n` (unique words) is large and `k` is small.

---

### 🔎 Rule of Thumb

* Use **max-heap** if you want *all sorted results*.
* Use **min-heap of size k** if you want *just the top k* efficiently.

---

⚡ Interviewers love when you say:

> “I’ll use a **min-heap of size k** because it gives me O(n log k), which is faster than a full max-heap O(n log n) when k is much smaller than n.”

---

Would you like me to also show how this differs from the **Top K Frequent Elements** problem (numbers instead of words), where we don’t need lexicographic tie-breaking?
