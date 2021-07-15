package leetTests.arrayandstrings;

import java.util.HashMap;

/**
 * With a rate limiter we want to store a user and the number of requests made per user.
 */

public class SampleRateLimiter {

    public HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long initialStart = System.currentTimeMillis();

        SampleRateLimiter ac = new SampleRateLimiter();
        System.out.println("Start service");
        String id = "10.250.20.91";

        boolean isRunning = true;
        while (isRunning) {
            try {
                ac.map.put(id, ac.map.getOrDefault(id, 0) +1);
                Thread.sleep(50);
                System.out.print(ac.map.get(id) + " ");
                if (ac.map.get(id) > 20 && (System.currentTimeMillis() - startTime) > 1000) {
                    System.out.println();
                    System.out.println("You have surpassed the number of requests per seconds please wait for 5 sec");
                    Thread.sleep(5000);
                    startTime = System.currentTimeMillis();
                    ac.map.clear();
                }

                // I needed a stopping condition
                if (System.currentTimeMillis() - initialStart > 100000) {
                    System.out.println();
                    isRunning = false;
                    System.out.println("Shutting down the application...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}




