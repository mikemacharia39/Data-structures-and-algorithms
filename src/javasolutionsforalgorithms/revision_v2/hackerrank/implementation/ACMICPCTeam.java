package javasolutionsforalgorithms.revision_v2.hackerrank.implementation;

import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://www.hackerrank.com/challenges/acm-icpc-team/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign">...</a>
 *
 * There are a number of people who will be attending ACM-ICPC World Finals.
 * Each of them may be well versed in a number of topics. Given a list of topics known by each attendee,
 * presented as binary strings, determine the maximum number of topics a 2-person team can know.
 * Each subject has a column in the binary string, and a '1' means the subject is known while '0' means it is not.
 * Also determine the number of teams that know the maximum number of topics. Return an integer array with two elements.
 * The first is the maximum number of topics known, and the second is the number of teams that know that number of topics.
 *
 * The attendee data is aligned for clarity below:
 * Example: topic = ["10101", "11110", "00010""]
 * 10101
 * 11110
 * 00010
 *
 * These are all possible teams that can be formed:
 *
 * Members | Subjects
 * (1,2)     [1,2,3,4,5]
 * (1,3)     [1,3,4,5]
 * (2,3)    [1,2,3,4]
 * In this case, the first team will know all 5 subjects. They are the only team that can be created that knows that
 * many subjects, so [5,1]  is returned.
 */
public class ACMICPCTeam {

    public static List<Integer> acmTeam(List<String> topic) {
        HashMap<Integer, Integer> teams = new HashMap<>();
        int largestSoFar = Integer.MIN_VALUE;
        int teamsSize = topic.size();
        for (int i = 0; i < teamsSize; i++) {
            for (int j = i + 1; j < teamsSize; j++) {
                int knownTopics = countTeams(topic.get(i), topic.get(j));
                teams.put(knownTopics, teams.getOrDefault(knownTopics, 0) + 1);

                largestSoFar = Math.max(largestSoFar, knownTopics);
            }
        }

        return List.of(largestSoFar, teams.get(largestSoFar));
    }

    private static int countTeams(String team1, String team2) {
        int knownTopics = 0;
        int teamSize = team1.length();

        for (int i = 0; i < teamSize; i++) {
            if (team1.charAt(i) == '1' || team2.charAt(i) == '1') {
                knownTopics++;
            }
        }

        return knownTopics;
    }

    public static void main(String[] args) {
        List<String> topic = List.of("10101", "11110", "00010");
        System.out.println(acmTeam(topic));
    }
}
