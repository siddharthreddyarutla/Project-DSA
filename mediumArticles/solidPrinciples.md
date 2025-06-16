# SOLID principle

[Medium article](https://medium.com/@javatechie/solid-design-principle-java-ae96a48db97)

**SOLID is an acronym for five object-oriented design principles that, when applied, make code more maintainable, flexible, and scalable. These principles are: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, and Dependency Inversion.
Here's a breakdown of each principle:**

1. **Single Responsibility Principle (SRP):**
Each class should have one specific reason to change, meaning it should focus on a single, well-defined task or responsibility.

2. **Open/Closed Principle (OCP):**
Software entities (like classes) should be open for extension but closed for modification. This means you should be able to add new functionality without altering existing code.

3. **Liskov Substitution Principle (LSP):**
Derived classes should be able to substitute for their base classes without altering the correctness of the program. In simpler terms, if a class is a subclass of another, it should behave as a valid replacement for the parent class.

4. **Interface Segregation Principle (ISP):**
Clients should not be forced to depend on methods they don't use. Interfaces should be broken down into smaller, more specific interfaces to avoid forcing unnecessary implementations.

5. **Dependency Inversion Principle (DIP):**
High-level modules should not depend on low-level modules. Both should depend on abstractions (like interfaces). Abstractions should not depend on details; details should depend on abstractions. 