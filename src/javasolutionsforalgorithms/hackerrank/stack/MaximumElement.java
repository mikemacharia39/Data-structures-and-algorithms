package javasolutionsforalgorithms.hackerrank.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://www.hackerrank.com/challenges/maximum-element/problem">...</a>
 *
 * You have an empty sequence, and you will be given N queries. Each query is one of these three types:
 *
 * 1 x  -Push the element x into the stack.
 * 2    -Delete the element present at the top of the stack.
 * 3    -Print the maximum element in the stack.
 * Function Description
 *
 * Complete the getMax function in the editor below.
 *
 * getMax has the following parameters:
 * - string operations[n]: operations as strings
 *
 * Returns
 * - int[]: the answers to each type 3 query
 */
public class MaximumElement {
    public static List<Integer> getMax(List<String> operations) {

        Iterator<String> iterator = operations.iterator();
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStackVal = new Stack<>();

        while (iterator.hasNext()) {
            String currentString = iterator.next();
            char operation = currentString.charAt(0);
            switch (operation) {
                case '1':
                    String[] stringPlusOp = currentString.split(" ");
                    int element = Integer.parseInt(stringPlusOp[1]);
                    stack.push(element);

                    if (maxStackVal.isEmpty()) {
                        maxStackVal.push(element);
                    } else {
                        if (element >= maxStackVal.peek()) {
                            maxStackVal.push(element);
                        }
                    }

                    break;
                case '2':
                    if (!stack.isEmpty()) {
                        int deleted = stack.pop();
                        int maxValPop = maxStackVal.peek();
                        if (deleted == maxValPop) {
                            maxStackVal.pop();
                        }
                    }
                    break;

                case '3':
                    list.add(maxStackVal.peek());
                    break;
                default:
                    break;
            }

        }
        return list;
    }

}
