# ReentrantLock


## What is ReentrantLock?
A ReentrantLock is a synchronization mechanism that allows threads to have more control over locks. Unlike the synchronized keyword, ReentrantLock provides a variety of features, such as:

1. **Explicit Locking**: You can explicitly acquire and release the lock.
2. **Fairness Policy**: Allows threads to acquire locks in the order they request them.
3. **Interruptible Locking**: Threads can interrupt waiting threads.
4. **TryLock**: Attempts to acquire a lock without blocking indefinitely.
Reentrant Behavior: A thread that holds the lock can reacquire it without deadlocking itself.

## Key Features of ReentrantLock
### 1.Reentrancy
A thread holding a ReentrantLock can reacquire it without blocking

```java
ReentrantLock lock = new ReentrantLock();

lock.lock();
try {
    // Critical section
    lock.lock(); // Reacquiring the lock
    try {
        // Nested critical section
    } finally {
        lock.unlock();
    }
} finally {
    lock.unlock();
}
```

Here’s why ReentrantLock was introduced and the problems it solves compared to synchronized


## 1. Fairness Policy:
**Problem with synchronized:**
The synchronized keyword does not provide a fairness mechanism. Threads waiting for a lock may not acquire it in the order they requested it, leading to thread starvation.


### Thread Starvation in synchronized and the Role of Fairness in ReentrantLock
Thread starvation occurs when threads waiting for a lock are unable to acquire it for a long time because other threads keep acquiring and releasing the lock unfairly. This can happen when:

1. There is no mechanism to ensure that waiting threads get the lock in the order they requested it.
2. High-priority threads continuously dominate the lock acquisition, preventing lower-priority threads from accessing shared resources.


The synchronized keyword in Java does not include a fairness policy, meaning that there is no guarantee regarding the order in which threads will acquire the lock. The JVM decides which thread to allow access, and it may prioritize threads arbitrarily, leading to potential starvation for some threads.



## Comparison with Other Locking Mechanisms
In addition to ReentrantLock, there are other locking mechanisms in Java, such as ReadWriteLock and StampedLock, which are designed for specific use cases.

### ReadWriteLock: 
Provides separate locks for reading and writing, allowing multiple threads to read concurrently while ensuring that only one thread can write at a time. This is useful in scenarios where read operations dominate.

### StampedLock: 
Introduces optimistic locking, allowing threads to perform reads without acquiring a lock initially and only acquiring the lock if the data is modified. This can provide better performance in cases where writes are infrequent.

