# What is Reflection in Java

Reflection is a powerful feature in Java that allows you to inspect and manipulate classes, methods, fields, and constructors at runtime — even if you don’t know their names at compile time.

It’s part of the java.lang.reflect package and is often used in frameworks, libraries, and tools that need to interact dynamically with objects.

✅ Use Cases of Reflection
Use Case	Example
Frameworks	Spring, Hibernate use reflection to inject dependencies, map fields
Testing	JUnit and Mockito use it to access private methods or mock classes
Serialization libraries	Jackson, Gson use it to read/write object fields dynamically
Object Inspectors/Debuggers	Tools that inspect class structure at runtime
Dependency Injection (DI)	Load classes dynamically without hard-coding types
Plugin architectures	Load external plugins via .class names at runtime

✅ How to Use Reflection
You typically use these main classes:

* Class<?>
* Method
* Field
* Constructor

✅ Example: Using Reflection to Access Class Info

```java
import java.lang.reflect.*;

public class ReflectionExample {
public static void main(String[] args) throws Exception {
Class<?> clazz = Class.forName("com.example.MyClass");

        // Print class name
        System.out.println("Class: " + clazz.getName());

        // Print all fields
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("Field: " + field.getName());
        }

        // Print all methods
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("Method: " + method.getName());
        }

        // Create instance using default constructor
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // Call method using reflection
        Method m = clazz.getDeclaredMethod("sayHello");
        m.setAccessible(true);  // if it's private
        m.invoke(obj);
    }
}
```

✅ Example Class

```java
package com.example;

public class MyClass {
private String message = "Hello Reflection!";

    private void sayHello() {
        System.out.println(message);
    }
}
```

✅ Accessing and Modifying Private Fields

```java
Field field = clazz.getDeclaredField("message");
field.setAccessible(true);
field.set(obj, "New Message via Reflection!");
```


⚠️ Disadvantages / Cautions

| Issue                        | Description                                             |
| ---------------------------- | ------------------------------------------------------- |
| **Performance**              | Reflection is slower due to runtime type resolution     |
| **Security**                 | Can break encapsulation (access private fields/methods) |
| **Compile-time safety lost** | Errors show up only at runtime                          |
| **Complex debugging**        | Reflection stack traces can be hard to follow           |


✅ Summary

| Feature              | Example                                    |
| -------------------- | ------------------------------------------ |
| Get class object     | `Class<?> c = Class.forName("MyClass");`   |
| Get fields/methods   | `c.getDeclaredFields()`                    |
| Create instance      | `c.getDeclaredConstructor().newInstance()` |
| Invoke method        | `method.invoke(obj, args...)`              |
| Access private field | `field.setAccessible(true)`                |
