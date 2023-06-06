package javasolutionsforalgorithms.revision_v2.leetcode.google;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://aaronice.gitbook.io/lintcode/hash-table/logger-rate-limiter">...</a>
 * ---
 * Design a logger system that receive stream of messages along with its timestamps,
 * each message should be printed if and only if it is not printed in the last 10 seconds.
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed
 * in the given timestamp, otherwise returns false.
 * It is possible that several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter {
    public final Map<String, Integer> map;
    int lastSecond = 0;

    /**
     * Initialize your data structure here.
     */
    public LoggerRateLimiter() {
        // Create a LinkedHashMap with initial capacity 100, load factor 0.75, and access order enabled
        // Time complexity: O(1)
        map = new LinkedHashMap<String, Integer>(100, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                // Override removeEldestEntry to remove entries older than 10 seconds
                // Time complexity: O(1)
                // last second is the most recent timestamp
                // the difference between the last second and the eldest entry's value is the time difference and
                // this indicates whether we should remove the eldest entry or not
                return lastSecond - eldest.getValue() > 10;
            }
        };
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        // Update the lastSecond with the provided timestamp
        // Time complexity: O(1)
        lastSecond = timestamp;

        if (!map.containsKey(message)) {
            map.put(message, timestamp);
        } else {
            // If the message is already in the map, check if the last printed time is more than 10 seconds ago
            // Time complexity: O(1)
            if (timestamp - map.get(message) >= 10) {
                // If the last printed time is more than 10 seconds ago, update the map with the new timestamp
                // Time complexity: O(1)
                map.put(message, timestamp);
            } else {
                // If the last printed time is less than 10 seconds ago, return false
                // Time complexity: O(1)
                return false;
            }
        }

        // Return false as the message should not be printed within the last 10 seconds
        // Time complexity: O(1)
        return true;
    }

    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true;

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3,"food")); //returns false;

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8,"bars")); //returns false;

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10,"foods")); //returns false;

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;

        // logging string "foo" at timestamp 12
        System.out.println(logger.shouldPrintMessage(12,"barred")); //returns true;

        // logging string "foo" at timestamp 13
        System.out.println(logger.shouldPrintMessage(13,"fooder")); //returns false;

        // logging string "bar" at timestamp 14
        System.out.println(logger.shouldPrintMessage(14,"barz")); //returns false;

        // logging string "foo" at timestamp 15
        System.out.println(logger.shouldPrintMessage(15,"fooders")); //returns false;


        System.out.println(logger.map);
    }
}



