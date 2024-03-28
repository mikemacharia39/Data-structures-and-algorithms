package tech_stuff.java_concepts.threads;

import java.util.List;
import java.util.stream.IntStream;

/**
 * The main method creates 10 virtual threads.
 *
 * This example show cases how virtual threads are able to switch between OS threads. The switch between OS threads occurred
 * when the virtual thread was sleeping and then the virtual thread was able to continue executing on a different OS thread.
 *
 * Example:
 * Hello from virtual thread: VirtualThread[#22]/runnable@ForkJoinPool-1-worker-1
 * Hello from virtual thread: VirtualThread[#22]/runnable@ForkJoinPool-1-worker-3
 *
 * A fork join pool is used to execute the virtual threads.
 *
 * <a href="https://www.geeksforgeeks.org/forkjoinpool-class-in-java-with-examples/">...</a>
 * The ForkJoinPool class is the center of the fork/join framework, which is an implementation of the ExecutorService interface.
 * ForkJoinPool class is an extension of the AbstractExecutorService class, and it implements the work-stealing algorithm
 * (i.e., worker threads that run out of things to do can steal tasks from other threads that are still busy) of fork/join
 * framework and can execute ForkJoinTask processes.
 *
 */
public class VirtualThreadsSwitchingOsThreads {

    public static void main(String[] args) {
        List<Thread> virtualThreads = IntStream.range(0, 10)
                .mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    if (i == 0) {
                        System.out.println("Hello from virtual thread: " + Thread.currentThread());
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (i == 0) {
                        System.out.println("Hello from virtual thread: " + Thread.currentThread());
                    }
                }))
                .toList();

        virtualThreads.forEach(Thread::start);
        virtualThreads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
