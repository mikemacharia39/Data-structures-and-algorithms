package javasolutionsforalgorithms.general;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    List<Integer> list = new ArrayList<>();

    public void generateNums(int start, int end) {
        if (start > end) {
            throw new RuntimeException("End must be greater than start");
        }

        for (int i = start; i <= end; i++) {
            list.add(i);
        }
    }

    public int getUniqueRandomNum() {
        if (!list.isEmpty()) {
            int randPicker = (int) System.currentTimeMillis() % list.size();

            int val = list.get(randPicker);

            list.remove(list.get(randPicker));

            return val;
        }

        return -1;
    }

    public static void main(String[] args) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        randomNumberGenerator.generateNums(23, 38);

        int i = 20;
        while (i >= 0) {
            System.out.println(randomNumberGenerator.getUniqueRandomNum());
            i--;
        }
    }
}
