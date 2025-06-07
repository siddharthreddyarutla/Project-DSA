# Arrays


### What Is an Array?
An array is a fixed-size, ordered collection of elements of the same type, stored contiguously in memory.

```java
int[] arr = new int[5];  // declaration + memory allocation
arr[0] = 10;             // assigning values
```

### Types of Arrays in Java

1. One-Dimensional Array
   ```java 
   int[] arr = {1, 2, 3, 4, 5};
   ```
2. Two-Dimensional Array (Matrix)
   ```java
   int[][] matrix = {
   {1, 2, 3},
   {4, 5, 6}
   };
   ```
3. Jagged Arrays (Array of arrays with varying length)
   ```java
   int[][] jagged = new int[3][];
   jagged[0] = new int[]{1, 2};
   jagged[1] = new int[]{3, 4, 5};
   jagged[2] = new int[]{6};
   ```



### Basic Array Operations

| Operation       | Code Example                    | Time Complexity |
| --------------- | ------------------------------- | --------------- |
| Access by index | `arr[i]`                        | `O(1)`          |
| Update element  | `arr[i] = val;`                 | `O(1)`          |
| Search element  | Linear scan                     | `O(n)`          |
| Loop over array | `for`, `foreach`, `while` loops | `O(n)`          |

### Useful java methods

```java
Arrays.sort(arr);                       // sort array
Arrays.fill(arr, 0);                    // fill with value
Arrays.equals(arr1, arr2);              // compare
int index = Arrays.binarySearch(arr, x); // binary search (sorted only)

```

### Key Concepts You Should Know for DSA

| Concept                     | Why Important                                  |
| --------------------------- | ---------------------------------------------- |
| **Length of array**         | `arr.length` — No `.length()` in arrays        |
| **Iteration**               | Master `for`, `while`, and `foreach`           |
| **Edge cases**              | Empty arrays, out-of-bounds access             |
| **In-place operations**     | Changing elements without extra space          |
| **Prefix sum**              | For range sum problems                         |
| **Sliding window**          | Efficient subarray analysis                    |
| **Two pointers**            | For searching/sorting-related problems         |
| **Sorting + binary search** | Improves performance from `O(n)` to `O(log n)` |


### Example Practice Problems

| Problem                      | Concepts Needed                     |
| ---------------------------- | ----------------------------------- |
| Find max/min in array        | Loop, conditionals                  |
| Reverse an array             | Two pointers                        |
| Check if array is palindrome | Two pointers                        |
| Subarray with given sum      | Prefix sum, hashmap, sliding window |
| Move all zeros to the end    | In-place modification               |
| Merge two sorted arrays      | Two pointers, extra array           |


## What is ArrayList?
An ArrayList is a resizable array that is part of Java's Collection Framework. Unlike arrays, it can grow and shrink dynamically as you add or remove elements.

```java
import java.util.ArrayList;

ArrayList<Integer> list = new ArrayList<>();
```

### Why Use ArrayList Over Arrays?

| Feature          | Array               | ArrayList                    |
| ---------------- | ------------------- | ---------------------------- |
| Size             | Fixed               | Dynamic (resizable)          |
| Type Support     | Primitive & Objects | Objects only (no primitives) |
| Built-in Methods | Limited             | Rich set of methods          |
| Flexibility      | Less flexible       | Very flexible                |



### Common Operations

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);             // Add element
list.add(1, 20);          // Add at index
int val = list.get(0);    // Get element
list.set(1, 25);          // Update element
list.remove(0);           // Remove element
int size = list.size();   // Get current size
list.clear();             // Remove all elements
boolean exists = list.contains(25);  // Check existence

```

### Key Points to Know

- Only supports object types (Integer, String, Double, etc.), not primitives like int, double. But Java auto-boxes int to Integer.

- Internally backed by an array. When capacity is exceeded, it creates a new array with larger size and copies elements → amortized O(1) for add().

- Use Collections.sort(list) to sort it.

### Time Complexity of Operations

| Operation         | Time Complexity     |
| ----------------- | ------------------- |
| `add()`           | O(1) amortized      |
| `get()` / `set()` | O(1)                |
| `remove(index)`   | O(n) (due to shift) |
| `contains()`      | O(n)                |
| `size()`          | O(1)                |



### When to Use ArrayList

#### When you need:

* A dynamic-size array.
* Random access of elements (via index).
* Rich library support (sort, remove, contains, etc.).

#### Avoid when:

* You need frequent insertions/removals at the beginning or middle of the list → consider LinkedList.
* You need to store primitives with high performance → consider arrays or IntStream.


### Convert Between Arrays and ArrayLists

```java
// ArrayList to array
ArrayList<Integer> list = new ArrayList<>();
list.add(1); list.add(2);
Integer[] arr = list.toArray(new Integer[0]);

// Array to ArrayList
Integer[] arr2 = {1, 2, 3};
ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(arr2));

```