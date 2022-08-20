package javasolutionsforalgorithms.leettests.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingLists {

    public void sortList() {

        List<String> stringList = Arrays.asList("physics", "maths", "biology", "chemistry");
        System.out.println("Original: " + stringList);

        Collections.sort(stringList);
        System.out.println("Sort in Asc: " + stringList);

        Collections.sort(stringList, Collections.reverseOrder());
        System.out.println("Sort in Desc: " + stringList);
    }

    public static void main(String[] args) {
        SortingLists sortingLists = new SortingLists();

        sortingLists.sortList();
    }
}
