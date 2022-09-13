package javasolutionsforalgorithms.general;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Algorithms : Soldier Report
 *
 * Goal
 * In the army, each soldier has an assigned rank.
 * A soldier of rank X has to report to (any) soldier of rank X + 1. Many soldiers can report to the same superior.
 * Given an array ranks consisting of soldiers ranks, returns the number of soldiers who can report to some superior.
 *
 * Test Cases
 *
 * Case 1
 * Given ranks[3,4,3,0,2,2,3,0,0], your function should return 5, because
 *
 * Three soldiers of rank 3 (ranks[0], ranks[2], ranks[6]) may report to a soldier of rank 4 (ranks[1])
 * Two soldiers of rank 2 may report to any soldier of rank 3
 *
 * Case 2
 * Given ranks[4,2,0], your function should return 0.
 *
 * Case 3
 *
 * Given ranks[4,4,3,3,1,0], your function should return 3, because
 *
 * A soldier of rank 0 can report to a soldier of rank 1
 * Two soldiers of rank 3 can report to any soldier of rank 4
 *
 * Task
 * Write an efficient algorithm.
 */
public class SoldierReportRank {

    /**
     * Also use a map to store rank and frequency in a sorted order
     * [4,4,3,3,1,0]
     * [0,1,3,4]
     *
     * @param ranks array
     * @return reporters
     */
    public int soldierReport(int[] ranks) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int rank : ranks) {
            treeMap.put(rank, treeMap.getOrDefault(rank, 0)+1);
        }

        int count = 0;
        List<Integer> list = treeMap.keySet().stream().collect(Collectors.toList());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) + 1 == list.get(i)) {
                count += treeMap.get(list.get(i-1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SoldierReportRank reportRank = new SoldierReportRank();

        int[] ranks1 = {4,4,3,3,1,0};
        System.out.println("Reports: " + reportRank.soldierReport(ranks1) + " | Expected: 3");

        int[] ranks2 = {4,2,0};
        System.out.println("Reports: " + reportRank.soldierReport(ranks2) + " | Expected: 0");

        int[] ranks3 = {3,4,3,0,2,2,3,0,0};
        System.out.println("Reports: " + reportRank.soldierReport(ranks3) + " | Expected: 3");
    }

}
