package javasolutionsforalgorithms.revision_v2.hackerrank.collection;

import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * You are given logs in the structure:
 * [["user1", "19:00:00", "2019-10-01"], ["user1", "21:00:59", ""2019-10-01"],
 * ["user2", "19:89:00", "2019-10-01"], ["user3", "21:00:59", ""2019-13-01"],
 * ["user4", "19:89:00", "2029-10-34"], ["user5", "21:00:59", ""2019-13-01"]]
 *<p>
 * Requirement:
 * Group the logs by user and date, for example [["user1", "2019-10-01", 2]]
 * The users should be sorted in asc order based on the user id, and the date should be sorted in ascending order.
 * The dates should be validated
 * Valid dates belonging to the same userId should be grouped and the count of logs shown against the date
 *
 */
public class UserLogs {

    public static List<List<String>> userLogs(List<List<String>> rawUserLogs) {
        // sort the userIds in ascending order
        Map<String, Map<String, Integer>> userLogMap = new TreeMap<>((a, b) -> {
            int userId1 = Integer.parseInt(a.replaceAll("\\D", ""));
            int userId2 = Integer.parseInt(b.replaceAll("\\D", ""));
            return Integer.compare(userId1, userId2);
        });

        for (List<String> log : rawUserLogs) {
            String userId = log.get(0);
            String timeString = log.get(1);
            String dateString = log.get(2);

            if (hasValidDateTime(dateString, timeString)) {
                // Initialize the userId map if it doesn't exist
                userLogMap.putIfAbsent(userId, new TreeMap<>());
                // If the dateMap by userId
                Map<String, Integer> dateMap = userLogMap.get(userId);
                // Increment the count for the date
                dateMap.put(dateString, dateMap.getOrDefault(dateString, 0) + 1);
            }
        }

        // Convert the userLogMap to the required output format
        // we are using a linked list to maintain the order of insertion
        List<List<String>> result = new LinkedList<>();

        for (Map.Entry<String, Map<String, Integer>> userEntry : userLogMap.entrySet()) {
            String userId = userEntry.getKey();
            Map<String, Integer> dateMap = userEntry.getValue();

            for (Map.Entry<String, Integer> dateEntry : dateMap.entrySet()) {
                String date = dateEntry.getKey();
                int count = dateEntry.getValue();
                result.add(List.of(userId, date, String.valueOf(count)));
            }
        }

        return result;
    }

    private static boolean hasValidDateTime(final String dateString, final String timeString) {
        try {
            Instant.parse(dateString + "T" + timeString + "Z");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        List<List<String>> testUserLogs = List.of(
                List.of("user1", "19:00:00", "2019-10-01"),
                List.of("user1", "11:00:00", "2019-10-01"),
                List.of("user1", "25:00:00", "2019-10-01"),
                List.of("user100", "19:00:00", "2019-10-01"),
                List.of("user69", "11:00:00", "2098-11-01"),
                List.of("user12", "19:00:00", "2019-23-01"),
                List.of("user11", "19:00:00", "2019-10-01"),
                List.of("user13", "11:00:00", "2019-10-01"),
                List.of("user2", "19:00:00", "2019-10-01")
        );
        List<List<String>> result = userLogs(testUserLogs);
        System.out.println(result);
    }
}
