# Aspect-Oriented Programming

[Medium article](https://medium.com/@sharmapraveen91/mastering-spring-aop-the-ultimate-guide-for-2025-55a146c8204c)

(AOP) is a programming paradigm that aims to improve modularity by separating cross-cutting concerns from the main business logic.
Here's how AOP works:

1. Cross-cutting concerns: These are functionalities or tasks that affect multiple parts of a system but don't fit neatly into any specific module or class, e.g., logging, security, error handling, and transaction management.
2. Aspects: AOP encapsulates these cross-cutting concerns into modular units called aspects.
3. Advice: These are the actions or behaviors defined within an aspect that get executed at specific points in the program's execution.
4. Join points: These are specific points in the program's execution where an aspect can be applied, such as method executions, exception handling, or field access.
5. Pointcuts: These are expressions that define where and when an aspect's advice should be applied to specific join points.
6. Weaving: This is the process of integrating aspects into the main program at the specified join points. Weaving can occur at compile time, load time, or runtime.


## CGLIB proxy and AOP in Spring
Spring AOP implements AOP functionalities using proxies. When a bean needs to be advised by an aspect (e.g., for transaction management with @Transactional), Spring creates a proxy object that wraps the original bean.

Spring uses two primary types of proxies:

1. JDK Dynamic Proxy: This is the default mechanism used when the target bean implements one or more interfaces.
2. CGLIB Proxy: This mechanism is used when the target bean does not implement any interfaces. CGLIB dynamically generates a subclass of the target class at runtime to intercept method calls.

Spring will automatically choose between these two proxy mechanisms based on whether the target bean implements interfaces or not.
In summary
AOP helps in modularizing cross-cutting concerns, making code cleaner and more maintainable. Spring AOP achieves this by using proxy objects, generated either via JDK Dynamic Proxy (for interface-based beans) or CGLIB Proxy (for class-based beans), to weave aspects into the application's core logic