package javasolutionsforalgorithms.revision_v2.hackerrank.math;

/**
 * <a href="https://www.hackerrank.com/challenges/drawing-book/problem">...</a>
 * -----------------
 * A teacher asks the class to open their books to a page number.
 * A student can either start turning pages from the front of the book or from the back of the book.
 * They always turn pages one at a time. When they open the book, page 1 is always on the right side:
 *
 * Visit site for example
 */
public class DrawingBook {

    public static int pageCount(int n, int p) {
        // p = page
        // n = number of pages in book
        // res = minimum number of turns

        double front = (double) p / 2; // divide by 2 because we are turning 2 pages at a time
        double back =  (n / 2) - front; // subtract front from total pages to get back
        return (int)Math.min(front,back);
    }
}
