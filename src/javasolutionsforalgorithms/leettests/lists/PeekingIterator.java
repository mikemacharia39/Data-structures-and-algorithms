package javasolutionsforalgorithms.leettests.lists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class PeekingIterator implements Iterator<Integer> {
    Queue<Integer> queue;
    public PeekingIterator(Iterator<Integer> iterator) {
        queue = new LinkedList<>();

        while (iterator.hasNext()) {
            queue.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return queue.peek();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return !queue.isEmpty() ? queue.poll() : null;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
