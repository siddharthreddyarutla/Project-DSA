## Dynamic Programming

### What is Dynamic Programming (DP)?
- Dynamic Programming is an algorithmic technique, not a data structure. It's used to solve problems by breaking them into **smaller overlapping subproblems**, solving each subproblem only once, and storing the result to avoid recomputation.


### Is DP a Data Structure or an Algorithm?
- Not a data structure
- It's an optimization technique (algorithmic paradigm)
- Often used in problems that exhibit:
  - Overlapping sub problems
  - Optimal substructure

### Key Idea Behind Dynamic Programming
- Instead of solving the same subproblem multiple times (as in naive recursion), DP stores the result of each subproblem the first time it’s solved and reuses it later. This is called memoization (top-down) or tabulation (bottom-up).

###  Example Problem: Fibonacci Numbers

Recursive (inefficient):

```java
int fib(int n) {
  if (n <= 1) {
    return n;
  }
  return fib(n - 1) + fib(n - 2);
}
```
> Time complexity: O(2ⁿ) → due to repeated recomputation.


DP with Memoization (Top-down):

```java
int[] memo = new int[n + 1];
Arrays.fill(memo, -1);

int fib(int n) {
  if (n <= 1) {
    return n;
  }
  if (memo[n] != -1) {
    return memo[n];
  }
  memo[n] = fib(n - 1) + fib(n - 2);
  return memo[n];
}
```

>Time complexity: O(n)
>Each fib(i) is calculated once and stored.


### When to Use DP?
**Use DP if:**

- The problem can be broken into smaller subproblems.
- The subproblems overlap.
- You can define a recursive relation (formula).
- The problem has optimal substructure (the best solution can be built from best solutions to subproblems).


