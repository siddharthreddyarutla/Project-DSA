# Greedy

### 🔍 What is a **Greedy Algorithm**?

A **greedy algorithm** is a problem-solving technique that builds up a solution **step-by-step**, always choosing the **best local option** at each step, hoping that this leads to a **globally optimal solution**.

> 💡 In simple terms:
> **Take the best you can right now, and hope it leads to the best overall.**

---

### 🧩 Characteristics of Greedy Algorithms:

1. **Greedy Choice Property**
   You can make a choice that looks best at the moment, and this choice will lead to the overall optimal solution.

2. **Optimal Substructure**
   The optimal solution to the problem contains optimal solutions to subproblems.

3. **No Backtracking**
   Once a choice is made, it is never reconsidered (unlike dynamic programming or backtracking).

---

### 🧠 General Structure of a Greedy Algorithm:

1. **Sort** or preprocess the data if needed.
2. **Iterate** through elements.
3. At each step, make the **greedy choice** (e.g., pick smallest/largest/earliest/latest).
4. Add it to the result if it's valid.
5. Repeat until done.

---

### ✅ Example Problems Solved by Greedy Algorithms:

| Problem Name                          | Greedy Choice                                                           |
| ------------------------------------- | ----------------------------------------------------------------------- |
| **Activity Selection / Max Meetings** | Pick the meeting that ends earliest                                     |
| **Fractional Knapsack**               | Pick item with highest value/weight ratio                               |
| **Huffman Encoding**                  | Merge the two smallest frequency nodes                                  |
| **Minimum Number of Coins**           | Pick the largest coin that fits                                         |
| **Job Sequencing with Deadlines**     | Schedule the highest-profit job as late as possible before its deadline |
| **Prim's / Kruskal's Algorithm**      | In MST, always add the smallest weight edge that doesn't create a cycle |
| **Dijkstra's Algorithm**              | Always visit the closest unvisited node                                 |

---

### ⚠️ When Greedy Works vs When It Doesn't

* ✅ **Greedy works**: when the problem has **greedy-choice property** and **optimal substructure**.
* ❌ **Greedy fails**: when a locally optimal choice doesn't guarantee a globally optimal solution.

    * For example, **0/1 Knapsack** can't be solved greedily — needs dynamic programming.

---

### 📦 Summary:

* Greedy = make the best decision **at each step**.
* Simple and fast (typically **O(n log n)** or **O(n)**).
* Works only when problem allows **greedy correctness**.
* Powerful for **optimization problems**.