# caffeine cache

[Resource](https://medium.com/javarevisited/caffeine-cache-f106cee91925)

Caffeine is a high-performance, in-memory caching library for Java. It's designed to store frequently accessed data in memory, allowing applications to quickly retrieve it without needing to access a database or other slower storage. Caching with Caffeine can significantly improve application performance by reducing latency and database load. 

### In-memory caching:
Caffeine stores data in the application's memory (JVM), making it very fast to access.
### High performance:
It's designed for speed and efficiency, often outperforming other caching solutions.
### Key-value store:
Caches data as key-value pairs, where the key identifies the data and the value is the data itself.
### Concurrency support:
Caffeine is designed to handle multiple threads accessing the cache concurrently without issues.
### Eviction policies:
Caffeine offers different strategies for evicting data when the cache reaches its size limit, including size-based, time-based, and reference-based eviction.
### Automatic loading:
Caffeine can automatically load data into the cache when accessed for the first time, and optionally do so asynchronously.
### Refresh:
It can also automatically refresh cached entries when they become stale