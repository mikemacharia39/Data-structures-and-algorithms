package javasolutionsforalgorithms.revision_v2.hackerrank.implementation;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=7-day-campaign
 */
public class StrangeAdvertising {
    public static int viralAdvertising(int n) {
        // on the first day, 5 people see the ad
        // half of them like it and share it with 3 friends
        // 5/2 = 2
        // 2 * 3 = 6
        // 6 people see the ad on the second day
        // 6/2 = 3
        // 3 * 3 = 9
        // 9 people see the ad on the third day
        // 9/2 = 4
        // 4 * 3 = 12
        // 12 people see the ad on the fourth day

        // so on the nth day, the number of people who see the ad is
        // 5/2 * 3 + 6/2 * 3 + 9/2 * 3 + 12/2 * 3 + ... + n/2 * 3

        int people = 5;
        int totalPeopleWhoLikeTheVideoOnDayN = 0;
        for (int i = 0; i < n; i++) {
            people = people / 2;
            totalPeopleWhoLikeTheVideoOnDayN += people;
            people *= 3;
        }
        return totalPeopleWhoLikeTheVideoOnDayN;
    }
}
