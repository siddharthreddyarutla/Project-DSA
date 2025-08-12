# Stack

> LIFO – Last In, First Out

## 📌 Use Cases / Patterns:

1. Reversing data (strings, numbers)
2. Balancing symbols (parentheses, brackets)
3. Backtracking (undo operations, recursion simulation)
4. Monotonic Stack: Maintain increasing or decreasing order for next/previous greater/smaller problems.
5. Function call stack simulation (iterative recursion)

## 🧠 Key Operations:

1. push(x): Add element
2. pop(): Remove top
3. peek() / top(): View top
4. isEmpty(): Check if empty



# Queues

> FIFO – First In, First Out

📌 Use Cases / Patterns:

1. Level-order traversal (BFS in trees/graphs)
2. Producer-consumer problems
3. Sliding window problems (with Deque)
4. Task scheduling
5. Implementing cache or buffer systems

## 🧠 Key Operations:

1. offer(x): Enqueue
2. poll(): Dequeue
3. peek(): Front element
4. isEmpty(): Check if empty


#  Deque (Double-Ended Queue)

Used in both stack and queue scenarios. Supports:

1. addFirst, addLast
2. removeFirst, removeLast
3. peekFirst, peekLast


## 📌 Use Cases:

1. Sliding window max/min
2. Palindrome checking
3. Monotonic Queue problems


##  Monostack (monotonic stack)


> A monotonic stack (often called mono stack) is a stack data structure that maintains its elements in a monotonic order — either increasing or decreasing.


### Monotonic Increasing Stack: 
Elements in the stack are in increasing order from bottom to top.
Used to find next smaller elements.


### Monotonic Decreasing Stack: 
Elements are in decreasing order from bottom to top.
Used to find next greater elements.


###  Why use a monotonic stack?

It helps you efficiently solve problems like:

1. Next Greater Element
2. Next Smaller Element
3. Largest Rectangle in Histogram
4. Stock Span
5. Daily Temperatures