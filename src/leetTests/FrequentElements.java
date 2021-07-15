package leetTests;

import java.util.*;

public class FrequentElements {

    public static void main(String[] args) {

        int[] x = {2,1,1,1,3,1,2,8,8,8,8};
        FrequentElements fe = new FrequentElements();
        System.out.println(Arrays.toString(fe.topKFrequent(x, 4)));
    }

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}
