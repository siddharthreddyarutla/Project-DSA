# Queue

![img.png](../images/queue.png)

   
1. Definition: A queue is a linear data structure that follows the FIFO principle (First In, First Out). 
2. Analogy: Like a line at a ticket counter — first person in line gets served first.
3. Java Interface: java.util.Queue<E>


## operations

| Method       | Description                                                                                   |
| ------------ | --------------------------------------------------------------------------------------------- |
| `offer(E e)` | Inserts an element at the end (returns `true`/`false` instead of throwing exception if fails) |
| `add(E e)`   | Inserts element at the end (throws exception if capacity full)                                |
| `poll()`     | Retrieves and removes head (returns `null` if empty)                                          |
| `remove()`   | Retrieves and removes head (throws exception if empty)                                        |
| `peek()`     | Retrieves but does not remove head (returns `null` if empty)                                  |
| `element()`  | Retrieves but does not remove head (throws exception if empty)                                |


## Common Implementations

### A. LinkedList as Queue

* Class: java.util.LinkedList
* Implementation: Doubly-linked list
* Features:
   - Supports Queue and Deque (double-ended queue) operations. 
   - Allows null elements. 
   - No capacity limit (grows dynamically).
* Performance:
  - Insert/remove at head or tail: O(1)
  - Remove arbitrary element: O(n)

ex:
```java
Queue<Integer> q = new LinkedList<>();
q.offer(10);
q.offer(20);
System.out.println(q.poll()); // 10
```


### B. PriorityQueue

* Class: java.util.PriorityQueue
* Implementation: Binary Heap (min-heap by default)
* Features:
  - Elements are ordered by natural ordering or a custom comparator.
  - Not FIFO — priority decides order.
  - Does not allow null elements.
* Performance:
* Insert (offer) and remove (poll) O(log n)
* Peek O(1)

Example:
```java
Queue<Integer> pq = new PriorityQueue<>();
pq.offer(30);
pq.offer(10);
pq.offer(20);
System.out.println(pq.poll()); // 10 (smallest element first)
```


### C. Deque (Double-Ended Queue)

* Interface: java.util.Deque<E>
* Operations:
* Add/remove from both ends.
* Can be used as Queue (FIFO) or Stack (LIFO).
* Methods:
* offerFirst(), offerLast()
* pollFirst(), pollLast()
* peekFirst(), peekLast()

### D. ArrayDeque

* Class: java.util.ArrayDeque
* Implementation: Resizable circular array
* Features:
* Faster than LinkedList for queue operations (better cache locality).
* No null elements allowed.
* Can be used as stack or queue.
* Performance:
* Add/remove at ends: O(1) amortized.

Example:
```java
Deque<Integer> dq = new ArrayDeque<>();
dq.offerFirst(1);
dq.offerLast(2);
System.out.println(dq.pollFirst()); // 1
```

## Queue vs Deque vs PriorityQueue

| Feature        | Queue                              | Deque                   | PriorityQueue                    |
| -------------- | ---------------------------------- | ----------------------- | -------------------------------- |
| Ends supported | One (rear insert, front remove)    | Both                    | One (but priority decides order) |
| Ordering       | FIFO                               | FIFO / LIFO             | Priority order                   |
| Null allowed?  | Yes (LinkedList) / No (ArrayDeque) | Yes/No depends on impl. | No                               |
| Typical impl.  | LinkedList, ArrayDeque             | LinkedList, ArrayDeque  | Binary Heap                      |


## When to Use What

1. LinkedList → When you need frequent insert/remove at both ends, with no capacity limit, and allow nulls.
2. ArrayDeque → When you need high-performance queue/deque without nulls.
3. PriorityQueue → When elements must be processed based on priority instead of FIFO.
4. BlockingQueue (e.g., LinkedBlockingQueue, ArrayBlockingQueue) → For thread-safe producer-consumer use cases.