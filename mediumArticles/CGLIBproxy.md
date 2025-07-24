# CGLIB

[Medium article](https://medium.com/@gaddamnaveen192/cglib-proxies-in-spring-boot-the-hidden-engine-behind-transactional-and-aop-a7f9243add5d)

CGLIB Proxy is a class-based proxy created using the CGLIB (Code Generation Library). It allows you to dynamically create a subclass of a given class at runtime, and intercept method calls.


### In Simple Terms:
A CGLIB proxy is a runtime-generated subclass of your class that overrides your methods to add extra behavior (like logging, transactions, security, etc.) before/after the original method runs


### When is CGLIB Proxy Used in Spring?
Your class does not implement any interface
You are using annotations like:
1. @Transactional
2. @Async
3. @Cacheable
4. Custom AOP (@Aspect)
5. You enable proxying with @EnableAspectJAutoProxy(proxyTargetClass = true)

### There is already another proxy (JDK Dynamic Proxy), so why do we need CGLIB proxy?


![img.png](../images/proxyComp.png)


## How CGLIB Proxy Works Internally in Spring — Step by Step


### Step 1: Spring Container Creates a Bean
You declare a class like

```java
@Service
public class MyService {
    @Transactional
    public void performAction() { ... }
}
```

Spring scans this bean and sees the @Transactional annotation. It needs to wrap this method with transaction logic.


### Step 2: Spring Checks for Interfaces
If MyService implements an interface, Spring uses a JDK dynamic proxy
If not, or if proxyTargetClass=true, it decides to use CGLIB

### Step 3: Spring Uses CGLIB to Create a Proxy Subclass

A subclass of MyService is created dynamically (like MyService$$EnhancerByCGLIB)
This subclass overrides your methods (e.g., performAction())

### Step 4: Method Interceptor is Registered
The MethodInterceptor (e.g., Spring’s TransactionInterceptor) is passed as a callback:

This is where Spring adds cross-cutting logic:

* Open/commit/rollback transactions
* Logging
* Security checks
* Retry, cache, etc.


### Step 5: Proxy is Registered as the Bean

Spring stores the CGLIB-generated proxy in the application context, not the original MyService class.


```
Original class: MyService
               |
               v
CGLIB Enhancer creates: MyService$$EnhancerByCGLIB extends MyService
               |
               v
Method: performAction()
        |
        +--> Intercepted by: TransactionInterceptor
                 |
                 v
            Begin Transaction
            Actual performAction() runs
            Commit/Rollback
 ```

### Limitations of CGLIB Proxies
1. Cannot proxy final classes or final methods
2. Cannot proxy private methods
3. Slower than JDK proxies (due to bytecode generation)
4. More complex stack traces (due to subclasses)