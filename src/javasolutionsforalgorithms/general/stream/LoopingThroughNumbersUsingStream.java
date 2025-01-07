package javasolutionsforalgorithms.general.stream;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class LoopingThroughNumbersUsingStream {

    private static final Logger log = Logger.getLogger(LoopingThroughNumbersUsingStream.class.getName());

    public static List<Integer> loopThroughNumbers(int start, int end) {
        // rangeClosed is inclusive of the end value
        // range is exclusive of the end value
        return IntStream.rangeClosed(start, end)
                        .boxed()
                        .toList();
    }

    public static List<Integer> evenNumbersBetweenRange(int start, int end) {
        // rangeClosed is inclusive of the end value
        // range is exclusive of the end value
        return IntStream.rangeClosed(start, end)
                .filter(n -> n % 2 == 0)
                .boxed()
                .toList();
    }


    public static void main(String[] args) {
        List<Integer> numbers = loopThroughNumbers(1, 10);

        log.log(Level.INFO, "Numbers: {0}", numbers);

        log.log(Level.INFO, "Even numbers between 1 and 10: {0}", evenNumbersBetweenRange(1, 10));
    }
}
