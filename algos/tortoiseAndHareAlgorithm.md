# Tortoise and Hare algorithm

The Tortoise and Hare algorithm, also known as Floyd's cycle-finding algorithm, is a technique for detecting cycles in linked lists or sequences. It uses two pointers: a slow pointer (the tortoise) and a fast pointer (the hare) that move through the sequence at different speeds. If a cycle exists, the faster pointer will eventually catch up to the slower pointer, indicating the presence of a loop


1. Initialization:
   Start with two pointers, one slow (tortoise) and one fast (hare), both pointing to the beginning of the linked list or sequence.
2. Movement:
   The tortoise moves one step at a time, while the hare moves two steps at a time.
3. Cycle Detection:
   If a cycle exists, the hare will eventually catch up to the tortoise, meaning they will point to the same node.
4. No Cycle:
   If the hare reaches the end of the sequence (a null pointer) without catching up to the tortoise, there is no cycle

**Example:**

Imagine a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (a cycle)

Tortoise: 1 -> 2 -> 3

Hare: 1 -> 3 -> 4

> The hare (moving twice as fast) will catch up to the tortoise at node 3, indicating a cycle.

### Key points:

- The algorithm has a time complexity of O(N).
- It's a space-efficient approach, using only two pointers.
- It's widely used for detecting cycles in linked lists and can also be adapted for other applications like finding the middle of a linked list