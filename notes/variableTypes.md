# Variable types

In Java, variables are categorized into three main types based on their declaration and scope:

##  Local Variables:
1. Declared inside a method, constructor, or block.
2. Their scope is limited to the block in which they are declared, meaning they are only accessible within that specific block.
3. They are created when the block is entered and destroyed when the block is exited.
4. Local variables must be initialized before use; they do not have a default value.

```java
    public class Example {
        public void myMethod() {
            int localVariable = 10; // local variable
            System.out.println("Local variable: " + localVariable);
        } // localVariable is destroyed here
    }
```

##  Instance Variables (Non-Static Fields):

1. Declared inside a class but outside any method, constructor, or block.   
2. They belong to an instance (object) of the class. Each object has its own copy of the instance variables.
3. They are created when an object of the class is instantiated and destroyed when the object is garbage collected.
4. Instance variables are automatically initialized to default values (e.g., 0 for numeric types, false for boolean, null for reference types) if not explicitly initialized.

```java
    public class Person {
        String name; // instance variable
        int age;     // instance variable

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
```

## Static Variables (Class Variables):

1. Declared inside a class but outside any method, constructor, or block, and marked with the static keyword.
2. They belong to the class itself, not to any specific object. All instances of the class share the same copy of a static variable. [4]  
3. They are created when the class is loaded into memory and exist as long as the class remains loaded.
4. Static variables are automatically initialized to default values if not explicitly initialized.

```java
  public class Counter {
        static int count = 0; // static variable

        public Counter() {
            count++;
        }
    }
```
