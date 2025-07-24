# Binary Search

Binary search is an efficient search algorithm used to find the position of a target value within a sorted array. It's a fundamental algorithm in computer science and is significantly faster than a linear search, especially for large datasets.

Here's how it works step-by-step:

1. Requirement: Sorted Data: 
The first and most crucial condition for using binary search is that the array or list you're searching must be sorted (either in ascending or descending order).


2. Initialize Search Space: You start by defining a search interval. This is done by setting two pointers: low (or start) to the first index of the array and high (or end) to the last index of the array.


3. Find the Middle Element: Calculate the middle index of the current search space using the formula: mid = (low + high) / 2.


4. Compare and Conquer:
Compare the target value you're looking for with the element at the mid index.
If array[mid] equals the target: The search is successful, and the index mid is returned.
If array[mid] is less than the target: The target element must be in the right half of the array. So, you discard the left half and update low = mid + 1 to continue the search in the right portion.
If array[mid] is greater than the target: The target element must be in the left half of the array. Discard the right half and update high = mid - 1 to continue the search in the left portion.


5. Repeat or Terminate: Repeat steps 3 and 4 until the target element is found or the search space becomes empty (i.e., low becomes greater than high). If the search space is exhausted and the element isn't found, the algorithm returns a value like -1 to indicate its absence.


### Example

Let's say you have a sorted array: [2, 4, 6, 8, 10, 12, 14] and you want to find the number 10.
1. Initial Step: low = 0, high = 6. Calculate mid = (0 + 6) / 2 = 3. The middle element array[3] is 8.
2. Comparison 1: Since 8 < 10, the target is in the right half. Update low = mid + 1 = 4.
3. Next Iteration: Now, low = 4, high = 6. Calculate mid = (4 + 6) / 2 = 5. The middle element array[5] is 12.
4. Comparison 2: Since 12 > 10, the target is in the left half of the current search space. Update high = mid - 1 = 4.
5. Final Step: Now low = 4, high = 4. Calculate mid = (4 + 4) / 2 = 4. The middle element array[4] is 10.
6. Target Found: Since array[mid] is equal to the target 10, the algorithm returns the index 4, indicating that the element is found at that position.


### Advantages of binary search

1. Efficiency: Significantly faster for large datasets than linear search, with a time complexity of O(log n), where 'n' is the number of elements in the array.
2. Works on Sorted Data: Optimized for sorted data, which means it can quickly pinpoint the location of an element if the data is already organized.
3. Memory Efficiency: The iterative implementation of binary search has a space complexity of O(1), meaning it requires a constant amount of extra space regardless of the input size, making it memory-efficient.
4. Versatility: Can be used on various data structures that support efficient random access, such as arrays.

### Disadvantages of binary search

1. Requires Sorted Data: If the data is unsorted, it must be sorted first, adding extra time complexity (typically O(n log n) for sorting algorithms).
2. Inefficient for Small Datasets: For very small datasets, the overhead of performing binary search might outweigh the benefits, and linear search could potentially be faster.
3. Not Suitable for Linked Lists: Due to the nature of linked lists (which don't allow for efficient random access to elements), binary search is not ideal for them.
4. Implementation Complexity: While the concept is straightforward, implementing binary search correctly can be tricky, leading to potential bugs like off-by-one errors. 