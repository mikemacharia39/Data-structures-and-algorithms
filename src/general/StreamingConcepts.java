package general;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamingConcepts {

    public void minAndMaxValueInArray() {
        List<Integer> integerList = Arrays.asList(3,9,1,2,4);

        int largestVal = integerList.stream()
                                        .mapToInt(value -> value)
                                        .max()
                                        .getAsInt();
        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Largest value is: {0}", largestVal);

        int largestVal2 = integerList.stream()
                                    .max(Integer::compare)
                                    .get();
        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Largest value is: {0}", largestVal2);

        int largestVal3 = integerList.stream()
                                     .sorted(Comparator.reverseOrder())
                                     .findFirst()
                                     .get();
        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Largest value is: {0}", largestVal3);


        int smallestVal = integerList.stream()
                .mapToInt(value -> value)
                .min()
                .getAsInt();

        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Smallest value is: {0}", smallestVal);
    }

    public void maxEvenNumberInList() {
        List<Integer> numberList = Arrays.asList(3,9,1,12,17,2,4);

        int maxEvenNum = numberList.stream()
                                   .filter(value -> value%2 == 0)
                                   .max(Integer::compare)
                                   .get();
        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Max even number value is: {0}", maxEvenNum);
    }

    public void evenNumbersInList() {
        List<Integer> numberList = Arrays.asList(3,9,1,12,17,2,4);

        List<Integer> evenNums = numberList.stream()
                                           .filter(n -> n%2 ==0)
                                           .sorted()
                                           .collect(Collectors.toList());
        Logger.getLogger(StreamingConcepts.class.getName()).log(Level.INFO, "Max even number value is: {0}", evenNums);
    }

    public void arrayToSet() {
        int[] nums = new int[5];
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
    }

    public static void main(String[] args) {
        StreamingConcepts streamingConcepts = new StreamingConcepts();
        streamingConcepts.minAndMaxValueInArray();
        streamingConcepts.maxEvenNumberInList();
        streamingConcepts.evenNumbersInList();
    }
}
