package tech_stuff.java_concepts.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * How many virtual threads can be created?
 *
 * This is how many I've been able to create and resources used:
 *
 * Time: 13336 ms
 * # Cores: 8
 * # Pools: 1
 * # Platform threads: 8
 * # Virtual threads: 10,000,000
 *
 * Please note you have to use jdk 19 or later to run this code.
 */
public class HowManyVirtualThreadsCanBeSpawned {

    public static void main(String[] args) {
        Set<String> poolNames = ConcurrentHashMap.newKeySet();
        Set<String> platformThreadNames = ConcurrentHashMap.newKeySet();

        List<Thread> virtualThreads = IntStream.range(0, 1000000).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
            String poolName = readPoolName();
            String platformThreadName = readPlatformThreadName();
            poolNames.add(poolName);
            platformThreadNames.add(platformThreadName);
        })).toList();

        Instant start = Instant.now();
        virtualThreads.forEach(Thread::start);
        for (Thread thread : virtualThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Instant end = Instant.now();

        System.out.println("Time: " + Duration.between(start, end).toMillis() + " ms");
        System.out.println("# Cores: " + Runtime.getRuntime().availableProcessors()); // the number of cores on the cpu
        System.out.println("# Pools: " + poolNames.size());
        System.out.println("# Platform threads: " + platformThreadNames.size());
        System.out.println("# Virtual threads: " + virtualThreads.size());
    }

    private static String readPoolName() {
        String name = Thread.currentThread().toString();
        int index1 = name.indexOf("@ForkJoinPool");
        int index2 = name.indexOf("worker");

        return name.substring(index1, index2);
    }

    private static String readPlatformThreadName() {
        String name = Thread.currentThread().toString();
        int index1 = name.indexOf("worker");
        return name.substring(index1);
    }
}
