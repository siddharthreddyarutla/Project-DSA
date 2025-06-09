# LinkedList

[Resource](https://www.youtube.com/watch?v=58YbpRDc4yw)

### What is LinkedList in Java?

A LinkedList is a linear data structure where each element (node) contains a reference (link) to the next (and possibly previous) node. It is part of Java’s java.util package and implements List, Deque, and Queue interfaces.

```java
import java.util.LinkedList;

LinkedList<Integer> list = new LinkedList<>();
```

### Types of Linked Lists
- Singly Linked List – Node points to next node.
- Doubly Linked List – Node points to both next and previous nodes.
- Circular Linked List – Last node points to the head.

- Java's LinkedList is a Doubly Linked List.


### Why Use LinkedList?

| Feature                   | ArrayList     | LinkedList              |
| ------------------------- | ------------- | ----------------------- |
| Random access             | ✅ Fast (O(1)) | ❌ Slow (O(n))           |
| Insert/Delete (start/mid) | ❌ Slow (O(n)) | ✅ Fast (O(1) at ends)   |
| Memory usage              | ✅ Less        | ❌ More (extra pointers) |


### Use LinkedList when:

1. You need frequent insertion/deletion at the beginning or middle.

2. Random access is not needed.

### Common Operations

```java
LinkedList<String> list = new LinkedList<>();

list.add("A");             // add at end
list.addFirst("B");        // add at beginning
list.addLast("C");         // add at end
list.add(1, "X");          // add at index

list.remove();             // remove head
list.removeFirst();        // remove head
list.removeLast();         // remove tail
list.remove("X");          // remove element by value

list.get(0);               // get element at index
list.getFirst();           // get head
list.getLast();            // get tail
```

### Time Complexity

| Operation                      | Time Complexity |
| ------------------------------ | --------------- |
| `addFirst` / `addLast`         | O(1)            |
| `removeFirst` / `removeLast`   | O(1)            |
| `add(index)` / `remove(index)` | O(n)            |
| `get(index)`                   | O(n)            |
| `contains()`                   | O(n)            |
| `size()`                       | O(1)            |


###  Iterating Through LinkedList

### Using For Loop (by index):
```java
for (int i = 0; i < list.size(); i++) {
  System.out.println(list.get(i));  // Not recommended — O(n) per get!
}
```

### Using Enhanced For Loop:
```java
for (String item : list) {
  System.out.println(item);  // Best for reading
}
```

### Using Iterator:
```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
System.out.println(it.next());
}
```

### Using Descending Iterator:
```java
Iterator<String> it = list.descendingIterator();
while (it.hasNext()) {
System.out.println(it.next()); // Traverses from tail to head
}
```


### LinkedList as Stack & Queue

***Queue (FIFO)***

```java
Queue<Integer> queue = new LinkedList<>();
queue.add(10);
queue.add(20);
queue.poll();      // Removes 10
queue.peek();      // Returns 20
```

***Stack (LIFO)***

```java
Deque<Integer> stack = new LinkedList<>();
stack.push(10);
stack.push(20);
stack.pop();       // Removes 20
stack.peek();      // Returns 10
```

### Internal Structure
**Each node stores:**

- value
- prev reference
- next reference

So more memory is used per element compared to ArrayList.

### When NOT to Use LinkedList
* When you need fast random access (use ArrayList).
* For memory-critical applications (due to node overhead).

### Converting Between ArrayList & LinkedList

```java
// LinkedList to ArrayList
LinkedList<Integer> linked = new LinkedList<>();
ArrayList<Integer> arrayList = new ArrayList<>(linked);

// ArrayList to LinkedList
ArrayList<Integer> arr = new ArrayList<>();
LinkedList<Integer> linkedList = new LinkedList<>(arr);
```