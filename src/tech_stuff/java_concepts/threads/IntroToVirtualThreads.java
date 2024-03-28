package tech_stuff.java_concepts.threads;

public class IntroToVirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        Thread platformThread = Thread.ofPlatform().unstarted(() -> System.out.println("Hello from platform thread: " + Thread.currentThread().getName()));
        platformThread.start();

        Thread virtualThread = Thread.ofVirtual().unstarted(() -> System.out.println("Hello from virtual thread: " + Thread.currentThread().getName()));
        virtualThread.start();

        platformThread.join(); // wait for the platform thread to finish

        virtualThread.join(); // wait for the virtual thread to finish

        System.out.println("Virtual thread: " + virtualThread.getClass());
    }
}
