# Java fundamentals

### Mutable

```java
import java.util.*;

class Main {
  public static void main(String[] args) {

    List<Integer> s = new ArrayList(Arrays.asList(10));
    System.out.println(s);
    add(s);
    System.out.println(s);
  }

  private static void add(List<Integer> a) {
    a.add(20);
  }
}
```

- Again, Java passes a copy of the reference to the List.
- But unlike the first case, this time you’re mutating the object (List) that both s and a point to.
- So when a.add(20) is called, the internal state of the same list is changed.
- 📌 Key takeaway: When you mutate a mutable object (like List), the change is reflected outside the
  method.

### Transient

> The transient keyword is used to mark a field to be ignored during serialization.

## Streams

[Medium article](https://medium.com/@gaddamnaveen192/java-8-streams-interview-questions-you-must-know-a5eea2c3e67e)

Question 1: Grouping By Length and Counting
Given a list of strings, write a Java 8 Stream program to group the strings by their length and
count the number of strings in each group.

```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
Map<Integer, Long> groupedByLength =
    words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
```

Question 2: Partitioning By Even and Odd

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
Map<Boolean, List<Integer>> partitioned =
    numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

Question 3: Find Second Largest Number

```java
List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 15);
Integer secondLargest =
    numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
```

Question 4: Custom Collector (Concatenate Strings)

```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
String wordString = words.stream().collect(Collectors.joining(","));
```

Question 5: Find Longest String

```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
String test = words.stream().max(Comparator.comparingInt(String::length)).get();
```


Question 6: Grouping By First Letter

```java
List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
Map<Character, List<String>> groupedWords =
        words.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
```


## Java one line answers

[link](https://www.javaguides.net/2025/04/10-java-one-liners-that-will-make-you-loo-like-pro.html)

## Implement functional interface

Normal implementation

```java
public static void main(String[] args) {
  System.out.println(power(5));
}

public static int power(int a) {
  return a * a;
}
```

Functional interface

```java
public static void main(String[] args) {
  Function<Integer, Integer> power = n -> n * n;
  System.out.println(power.apply(5));
}
```