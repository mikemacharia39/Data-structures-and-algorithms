package leetTests.string_manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * pattern - [orange, apple apple, orange, banana apple banana]
 *
 * purchase - [orange, apple, apple, orange, banana, apple banana]
 * purchase - [apple, orange, apple, apple, orange, banana, orange ,apple, banana]
 */

public class AmazonGoodsPattern {

    public int goodsPattern(List<String> pattern, List<String> purchase) {

        Iterator<String> iteratorPattern = pattern.iterator();

        int count = 0;

        int start = 0;

        while (iteratorPattern.hasNext()) {

            String aPattern = iteratorPattern.next();
            String[] subPattern = aPattern.split(" ");

            int miniPatternSize = subPattern.length;

            for (String miniPattern :subPattern) {
                int internalCount = 0;
                int matches = 0;
                for (int i = start; i < purchase.size(); i++) {

                    String product = purchase.get(i);

                    System.out.println("comparing " + miniPattern + ", ");

                    if (miniPattern.equals(product)) {
                        System.out.print(product + " = " + miniPattern);
                        matches++;
                    } else {
                        continue;
                    }

                    start++;

                    internalCount++;

                    if (miniPatternSize == internalCount) {
                        break;
                    }
                }



                if (matches == miniPatternSize) {
                    System.out.println("Found match");
                    count++;
                }

                System.out.println();
            }
        }

        System.out.println();


        return count == pattern.size() ? 1 : 0;
    }



    public static void main(String[] args) {

        List<String> pattern = Arrays.asList("orange", "apple apple", "orange", "banana apple banana");
        List<String> product = Arrays.asList("orange", "apple", "apple", "orange", "banana", "apple", "banana");

        AmazonGoodsPattern patterns = new AmazonGoodsPattern();

        Logger.getLogger("Patters").
                log(Level.INFO, "{0}", patterns.goodsPattern(pattern, product));
    }
}
