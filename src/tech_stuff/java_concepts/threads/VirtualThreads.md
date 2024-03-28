# Virtual Threads
- Virtual threads are lightweight threads that are scheduled by the JVM rather than the OS.

To understand virtual threads we need to first understand the difference between OS threads(platform thread) and virtual threads.

The feature of virtual threads is available on java 21 and above.

Further notes can be found here https://youtu.be/CY_6yq11DEM

## OS Threads(Platform Threads)
- OS threads are managed by the OS kernel.
- OS threads are heavyweight threads.
- OS threads are expensive to create and destroy.
- OS threads are scheduled by the OS kernel.
- OS threads are limited by the OS kernel.

## Virtual Threads
- Virtual threads are managed by the JVM and run on OS threads(platform threads).
- A virtual thread can be detached from OS thread as soon as it is is blocking. 
     A new virtual thread can be attached to the same OS thread. 
     Once the previous virtual thread is unblocked, it can be attached to any other OS thread.
- A virtual thread cannot be detached from OS thread if it is running in a synchronized block.
- Virtual threads are lightweight threads.
- Virtual threads are cheap to create and destroy.
- Virtual threads are scheduled by the JVM.
- Virtual threads are not limited by the OS kernel.
- Virtual threads are not bound to any particular OS thread.

## Why Virtual Threads?
- Virtual threads are lightweight and cheap to create and destroy.

## How to create Virtual Threads?
- We can create virtual threads using the `Thread.ofVirtual()` method.

```java
Thread virtualThread = Thread.ofVirtual().start(() -> {
    System.out.println("Hello from virtual thread");
});
virtualThread.join();
```

## How to create a OS thread?
- We can create OS threads using the `Thread` class.

```java
Thread osThread = Thread.ofPlatform(() -> {
    System.out.println("Hello from OS thread");
});
osThread.start();
```