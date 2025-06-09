# Set

## 1. HashSet

- Ordering: ❌ No guaranteed order of elements (not sorted, not insertion order).
- Duplicates: ❌ Does not allow duplicates

Underlying Data Structure: Hash table (like HashMap)

> Performance: O(1) average time for add, remove, contains

Example:

```java
Set<Integer> set = new HashSet<>();
set.add(3);
set.add(1);
set.add(2);

System.out.println(set);  // Output can be [1, 2, 3] or [3, 1, 2] or any order
```

Even if you add elements in a sorted order, HashSet will not preserve it.

## 2. TreeSet:

```java
Set<Integer> sortedSet = new TreeSet<>();
sortedSet.add(3);
sortedSet.add(1);
sortedSet.add(2);

System.out.println(sortedSet);  // Output: [1, 2, 3]
```

✅ Sorted (natural or custom comparator)

❌ Slower than HashSet (O(log n) for add/remove)

❌ Does not allow nulls

 ## 3. LinkedHashSet:

```java
Set<Integer> linkedSet = new LinkedHashSet<>();
linkedSet.add(3);
linkedSet.add(1);
linkedSet.add(2);

System.out.println(linkedSet);  // Output: [3, 1, 2]
```

Maintains insertion order

Slight overhead over HashSet


| Set Type        | Order Maintained  | Sorted | Null Allowed | Performance |
| --------------- | ----------------- | ------ | ------------ | ----------- |
| `HashSet`       | ❌ No              | ❌ No   | ✅ Yes        | Fast (O(1)) |
| `LinkedHashSet` | ✅ Insertion order | ❌ No   | ✅ Yes        | O(1)        |
| `TreeSet`       | ✅ Sorted (by key) | ✅ Yes  | ❌ No         | O(log n)    |
