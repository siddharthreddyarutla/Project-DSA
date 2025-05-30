# Map

## 1. Map (Interface)

- Type: Interface

- Purpose: Defines the contract for all map types — it cannot be instantiated directly.

Key Methods:

    put(K key, V value)
    
    get(Object key)
    
    containsKey(Object key)
    
    entrySet(), keySet(), values(), etc.

Implementations: HashMap, LinkedHashMap, TreeMap, etc.

Think of Map as the blueprint; HashMap, LinkedHashMap, and TreeMap are the buildings made from it.

## 2. HashMap

- Order: ❌ No ordering guarantee (keys can appear in any order)

- Nulls: ✅ Allows one null key and many null values

Performance:
    
    put/get/remove in O(1) average time
    
    Backed by hash table
    
    Usage: When you need fast access and don’t care about order

```java
Map<String, Integer> map = new HashMap<>();
```

## 3. LinkedHashMap

- Order: ✅ Maintains insertion order
- Nulls: ✅ Allows one null key and many null values

Performance:

    put/get/remove in O(1) average time
    
    Slightly slower than HashMap due to linked list overhead
    
    Usage: When you want predictable insertion order

```java
Map<String, Integer> map = new LinkedHashMap<>();
```

## 4. TreeMap

- Order: ✅ Maintains sorted order of keys (natural or custom Comparator)
- Nulls: ❌ Does not allow null keys (throws NullPointerException), but allows null values

Performance:

    put/get/remove in O(log n)
    
    Backed by a Red-Black Tree
    
    Usage: When you need a sorted map

```java
Map<String, Integer> map = new TreeMap<>();
```

| Feature         | `HashMap`     | `LinkedHashMap`   | `TreeMap`       |
| --------------- | ------------- | ----------------- | --------------- |
| Maintains order | ❌ No          | ✅ Insertion order | ✅ Sorted by key |
| Time complexity | O(1) avg      | O(1) avg          | O(log n)        |
| Null keys       | ✅ One allowed | ✅ One allowed     | ❌ Not allowed   |
| Null values     | ✅ Allowed     | ✅ Allowed         | ✅ Allowed       |
| Thread-safe     | ❌ No          | ❌ No              | ❌ No            |
