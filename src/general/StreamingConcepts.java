package general;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void main(String[] args) {
        StreamingConcepts streamingConcepts = new StreamingConcepts();
        streamingConcepts.minAndMaxValueInArray();
    }
}
