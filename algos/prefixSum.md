# Prefix sum


The Prefix Sum Algorithm is a technique used to compute the cumulative sum of an array in such a way that each element at index i in the result represents the sum of all elements from the start of the array up to index i.


***Basic Idea:***
```java
arr = [a0, a1, a2, ..., an]
```


***The prefix sum array prefix is:***
```java
prefix[0] = arr[0]
prefix[1] = arr[0] + arr[1]
prefix[2] = arr[0] + arr[1] + arr[2]
...
prefix[i] = arr[0] + arr[1] + ... + arr[i]
```

***So the formula becomes:***
```java
prefix[i] = prefix[i - 1] + arr[i]
```


### Applications:
Efficient range sum queries: You can find the sum of elements between indices i and j in O(1) using:

swift
Copy
Edit
sum(i, j) = prefix[j] - prefix[i-1]
Subarray problems in competitive programming

Dynamic programming

Histogram or 2D matrix problems

## Problems

> sdeSheet.arrays4.longestSubArrayWithZeroSum
> sdeSheet.arrays4.countSubArrayWithSumK_560
> sdeSheet.arrays4.longestSubArrayWithSumK