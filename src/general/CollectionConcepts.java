package general;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

/**
 * Java Collection Framework Hierarchy
 *
 *                      Iterable
 *                         |
 *                     Collection
 *   ---------------------|-------------------------
 *  |                     |                        |
 * List                 Queue                     Set
 *  |                    | |-PriorityQueue        | |-HashSet
 *  |- Arraylist         |                        | |-LinkedHashSet
 *  |- Linked list ----->|-Deque                  |
 *  |- Vector            |                        |-SortedSer
 *  |    |               |-ArrayDeque             |-TreeSet
 *       |-Stack
 */
public class CollectionConcepts {

    /**
     * Vector implements a dynamic array which means it can grow or shrink as required.
     * Like an array, it contains components that can be accessed using an integer index.
     * They are very similar to ArrayList, but Vector is synchronized
     *
     * Vector is synchronized, which means only one thread at a time can access the code,
     * while ArrayList is not synchronized, which means multiple threads can work on ArrayList at the same time
     *
     * Both ArrayList and Vector are implemented internally as arrays,
     * both are dynamically resized but Vector is has a capacityIncrement of double the current array size where for
     * ArrayList it is half the current size.
     */
    public static void vectors() {
        Vector<String> vector = new Vector<>();
    }

    /**
     * The SortedSet interface extends Set and declares the behavior of a set sorted in ascending order.
     * The SortedSet provides the additional methods that inhibit the natural ordering of the elements.
     */
    public static void sortedSets() {
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(23);
        sortedSet.add(12);
        sortedSet.add(16);
        sortedSet.add(5);
        System.out.println(sortedSet.toString());

        // reverse sorted set
        SortedSet<Integer> reversed = new TreeSet<>(Collections.reverseOrder());
        reversed.addAll(sortedSet);
        System.out.println(reversed);
    }

    public static void main(String[] args) {
        CollectionConcepts.sortedSets();
    }
}
