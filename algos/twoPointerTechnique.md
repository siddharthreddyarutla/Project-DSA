## Two pointer


The two-pointer technique is not a formal "algorithm" in the strict academic sense like Dijkstra's or Merge Sort, but rather a powerful algorithmic technique or strategy commonly used to solve array and string problems efficiently.

It's a method where you use two indices (pointers) to iterate through data structures like arrays or strings, often moving toward each other or in the same direction to reduce the time complexity of brute-force solutions.


| Problem Type                     | Typical Use                   |
| -------------------------------- | ----------------------------- |
| Finding a pair with a target sum | Sorted arrays                 |
| Reversing an array or string     | Opposite ends inward          |
| Removing duplicates              | Slow and fast pointer         |
| Partitioning data                | Pivoting or sliding           |
| Merging sorted arrays            | Two pointers from both arrays |


***Example: Two-Sum (Sorted Array)***

```java
int[] nums = {1, 2, 4, 6, 10};
int target = 8;

int left = 0, right = nums.length - 1;
while (left < right) {
    int sum = nums[left] + nums[right];
    if (sum == target) {
        System.out.println("Pair: " + nums[left] + ", " + nums[right]);
        break;
    } else if (sum < target) {
        left++;
    } else {
        right--;
    }
}

```
> ✅ Time Complexity: O(n)
> ❌ Brute Force would be O(n²)


### Two Pointer Variants
- Same direction (e.g., slow/fast in cycle detection, linked lists)
- Opposite directions (e.g., left and right for sum/search)
- Fixed vs Moving pointer (e.g., sliding window problems)

