package javasolutionsforalgorithms.revision_v2.hackerrank.sorting;

/**
 * In the previous challenge, you wrote code to perform an Insertion Sort on an unsorted array.
 * But how would you prove that the code is correct? I.e. how do you show that for any input your code will provide the right output?
 *
 * Loop Invariant
 * In computer science, you could prove it formally with a loop invariant, where you state that a desired property is maintained in your loop. Such a proof is broken down into the following parts:
 *
 * Initialization: It is true (in a limited sense) before the loop runs.
 * Maintenance: If it's true before an iteration of a loop, it remains true before the next iteration.
 * Termination: It will terminate in a useful way once it is finished.
 * Insertion Sort's Invariant
 *
 * Say, you have some InsertionSort code, where the outer loop goes through the whole array :
 *
 * for(int i = 1; i < A.length; i++){
 * //insertion sort code
 *
 * To prove Insertion Sort is correct, you will then demonstrate it for the three stages:
 *
 * 1. Initialization - The subarray starts with the first element of the array, and it is (obviously) sorted to begin with.
 *
 * 2. Maintenance - Each iteration of the loop expands the subarray, but keeps the sorted property. An element V gets
 * inserted into the array only when it is greater than the element to its left.
 * Since the elements to its left have already been sorted, it means V is greater than all the elements to its left,
 * so the array remains sorted. (In Insertion Sort 2 we saw this by printing the array each time an element was properly
 * inserted.)
 *
 * 3. Termination - The code will terminate after  has reached the last element in the array, which means the sorted
 * subarray has expanded to encompass the entire array. The array is now fully sorted.
 */
public class CorrectnessAndTheLoopInvariant {

    public static void insertionSort(int[] A){

        for (int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > value) {
                A[j + 1] = A[j];
                j = j - 1;
            }

            A[j + 1] = value;

            if (i == A.length - 1) {
                printArray(A);
            }
        }
    }

    private static void printArray(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
