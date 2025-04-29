# How Garbage Collection Works in Java
https://blog.bytebytego.com/p/ep125-how-does-garbage-collection?ref=dailydev

Garbage collection is an automatic memory management feature used in programming languages to reclaim memory no longer used by the program.
It helps in preventing memory leaks and optimizing memory usage by automatically identifying and freeing up memory occupied by objects that are no longer reachable or needed by the program.

## Memory Leak
A memory leak occurs when a program uses more memory than it needs and doesn't release the unused memory back to the system. This can lead to a slow decline in system performance, especially in long-running applications. Over time, the memory can become so full that the application crashes or experiences other issues.

### What causes memory leaks?
1. Failure to deallocate memory:
In languages like C and C++, developers must manually free memory that's no longer needed. If they forget to do so, the memory remains allocated and unavailable for other programs.
2. Persistent references:
Even in garbage-collected languages, objects can be kept alive by persistent references within the application's code, preventing the garbage collector from reclaiming the memory.
3. Circular dependencies:
Objects that are part of a circular dependency can also prevent garbage collection, as the garbage collector cannot determine which object is truly no longer needed.

### Types of Garbage Collectors in Java
1. Serial Garbage Collector: Best for single-threaded environments or small applications.
2. Parallel Garbage Collector: Also known as the "Throughput Collector."
3. CMS (Concurrent Mark-Sweep) Garbage Collector: Low-latency collector aiming to minimize pause times.
4. G1 (Garbage-First) Garbage Collector: Aims to balance throughput and latency.
5. Z Garbage Collector (ZGC): A low-latency garbage collector designed for applications that require large heap sizes and minimal pause times.


Designing fault-tolerant systems is crucial for ensuring high availability and reliability in various applications. 
## Here are six top principles of designing fault-tolerant systems:

1. Replication: Replication involves creating multiple copies of data or services across different nodes or locations.

2. Redundancy: Redundancy refers to having additional components or systems that can take over in case of a failure.

3. Load Balancing: Load balancing distributes incoming network traffic across multiple servers to ensure no single server becomes a point of failure.

4. Fail-over Mechanisms: Fail over mechanisms automatically switch to a standby system or component when the primary one fails.

5. Graceful Degradation: Graceful degradation ensures that a system continues to operate at reduced functionality rather than completely failing when some components fail.

6. Monitoring and Alerting: Continuously monitor the system's health and performance, and set up alerts for any anomalies or failures.