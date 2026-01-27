# 🧠 COMPLETE DSA PATTERN IDENTIFICATION NOTES

*(Amazon OA + Interviews Focused)*

---

## 🔰 HOW TO USE THESE NOTES (IMPORTANT)

For **every problem**, do this in order:

1. Read the problem **once**
2. Ignore solution ideas
3. Ask the **identification questions below**
4. Match → pattern → code

If you do this, panic disappears.

---

# 🧩 CORE IDENTIFICATION FLOW (MASTER THIS)

## STEP 1️⃣ — What is the DATA TYPE?

This immediately narrows patterns.

| Data Type        | Possible Patterns                     |
| ---------------- | ------------------------------------- |
| Array / String   | Sliding Window, Two Pointers, HashMap |
| Sorted Array     | Binary Search, Two Pointers           |
| Tree             | DFS / BFS                             |
| Graph / Grid     | BFS / DFS                             |
| Stream           | Queue / Heap                          |
| Multiple Queries | Prefix Sum                            |

---

## STEP 2️⃣ — KEYWORD → PATTERN MAPPING (MOST IMPORTANT)

### 🔹 Subarray / Substring / Continuous?

Keywords:

* subarray
* substring
* contiguous
* consecutive

👉 **Sliding Window / Prefix Sum**

Rule:

* Fixed size → Sliding Window
* Variable size → Sliding Window + while
* Sum/count → Prefix Sum + HashMap

---

### 🔹 Sorted Array?

Keywords:

* sorted
* increasing
* decreasing

👉 **Two Pointers / Binary Search**

Rule:

* One pass → Two pointers
* Find position / boundary → Binary search

---

### 🔹 Find pairs / frequency / duplicates?

Keywords:

* pairs
* frequency
* count
* anagram
* occurrences

👉 **HashMap / HashSet**

Rule:
If brute force = O(n²), HashMap almost always helps.

---

### 🔹 Maximum / Minimum / Longest / Shortest?

Keywords:

* max / min
* longest
* shortest
* optimal

👉 Ask one question:

> Is there a choice that affects future results?

| Case             | Pattern             |
| ---------------- | ------------------- |
| Local best works | Greedy              |
| Choices overlap  | Dynamic Programming |

---

### 🔹 Tree?

Keywords:

* root
* left / right
* parent / child

👉 Choose based on question:

| Question           | Pattern |
| ------------------ | ------- |
| Depth / path / sum | DFS     |
| Level / distance   | BFS     |

---

### 🔹 Grid / Matrix?

Keywords:

* matrix
* grid
* 2D array
* directions

👉 **Graph BFS / DFS**

Rule:

* Shortest path → BFS
* Just explore → DFS

---

### 🔹 Shortest path / minimum steps?

Keywords:

* minimum steps
* shortest distance
* least moves

👉 **BFS (unweighted)**

> Amazon OA is almost always **unweighted** → BFS.

---

### 🔹 Dependencies / Ordering?

Keywords:

* prerequisite
* dependency
* before / after
* schedule

👉 **Topological Sort**

---

### 🔹 All combinations / ways?

Keywords:

* all possible
* combinations
* subsets
* permutations

👉 **Backtracking**

Rule:
If output size explodes → recursion.

---

## 🧠 ADVANCED BUT HIGH-VALUE AMAZON PATTERNS

### 🔹 Stream / Real-time data?

Keywords:

* stream
* online
* running
* recent

👉 **Queue / Heap / Deque**

Examples:

* Moving average
* Last K elements

---

### 🔹 Top K / Kth element?

Keywords:

* top K
* K largest
* K smallest

👉 **Heap (PriorityQueue)**

Rule:

* K small, N large → Heap

---

### 🔹 Multiple Range Queries?

Keywords:

* range sum
* many queries

👉 **Prefix Sum**

---

### 🔹 Repeated Subproblems?

Ask:

> Am I solving the same thing again and again?

👉 **DP / Memoization**

---

### 🔹 Rule-based processing?

Keywords:

* simulate
* follow rules
* step by step

👉 **Simulation (loops + data structures)**

🧠 Amazon LOVES simulation problems.

---

## 🔍 BRUTE FORCE CHECK (CRITICAL STEP)

Ask:

> Can brute force solve this?

| Brute Force | Optimization             |
| ----------- | ------------------------ |
| O(n²)       | HashMap / Sliding Window |
| O(2ⁿ)       | DP / Backtracking        |

If brute force is slow → optimize.

---

### 🔹 **Stack identification keywords**

* nested
* valid / balanced
* recent / previous
* undo
* matching brackets
* next greater / smaller element

That’s it.
Now your checklist is **complete and interview-ready**.


A monotonic stack is a specialized data structure (a stack) that maintains its elements in a strictly increasing or decreasing order. It is used to efficiently solve "next greater element" or "previous smaller element" problems

* Key Characteristics and Usage:
    * Monotonic Increasing Stack: Elements are kept in ascending order from bottom to top. When a new element is smaller than the top, it is pushed; if larger, the top is popped until the order is restored. Used to find the next smaller element.
    * Monotonic Decreasing Stack: Elements are kept in descending order from bottom to top. When a new element is larger than the top, it is pushed; if smaller, the top is popped. Used to find the next greater element.


# 🧠 FINAL MASTER CHECKLIST (MEMORIZE THIS)

```
Subarray / substring?        → Sliding Window
Sorted array?               → Two Pointers / Binary Search
Pairs / frequency?          → HashMap
Max / Min?                  → Greedy or DP
Tree?                       → DFS / BFS
Grid / Matrix?              → BFS / DFS
Shortest path?              → BFS
Dependencies?               → Topological Sort
All combinations?           → Backtracking
Stream data?                → Queue / Heap
Top K / Kth?                → Heap
Range queries?              → Prefix Sum
Repeated work?              → DP / Memo
Rule-based?                 → Simulation
Nested / recent / matching? → Stack
```

---

## ❌ WHAT YOU CAN IGNORE (FOR AMAZON OA)

Do **NOT** waste time on:

* Segment Tree
* Fenwick Tree
* Advanced Graph Algorithms
* Heavy DP with states

Not worth it for OA.

---

## 🏁 FINAL TRUTH (IMPORTANT FOR CONFIDENCE)

You don’t fail Amazon OA because you don’t know DSA.

You fail because:
❌ Panic
❌ Wrong pattern
❌ Overthinking

With these notes:
✅ Pattern is clear
✅ Decisions are fast
✅ Confidence is stable

---

## ✅ NEXT (STRONGLY RECOMMENDED)

To make this **permanent**, we should:
1️⃣ Practice **10 mixed problems** → you identify pattern
2️⃣ Do **Amazon OA-style mock** and pause at identification
3️⃣ Convert this into a **1-page printable PDF**

Reply **1, 2, or 3** — this is the final stretch 🚀
