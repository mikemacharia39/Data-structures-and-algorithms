package javasolutionsforalgorithms.revision_v2.leetcode.google.unstructured;

import java.util.HashMap;

/**
 * Implement a SnapshotArray that supports the following interface:
 * SnapshotArray(int length) initializes an array-like data structure with the given length.
 * Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 *
 * ------------------- EXPLANATION ----------------------
 *
 * The concept behind snapshot array uses the concept of snapshots
 * A snapshot takes record of the current state of the setup
 * -----------------------
 * In our scenario we are using a 2d hashmap, the index in the outer hashmap represents
 * some sort of concept like ec2 or database
 * The inner hashmap contains the snap id and contents as at the time of taking the
 * snapshot
 * -----------------------
 * Everytime we take a snapshot we return the current state and increment the snap id
 * Everytime we set data, we set the value against a snapshot
 *
 * It is not always that all snap and there record/value will be recorded
 * What this means is that the initial record/value has not changed. But the snap has
 * incremented.
 * That's the reason we have a loop that checks previous snaps as it
 * gets the value of the last recorded snap and its value
 *
 * It's pretty complicated
 */
class SnapshotArray {

    int snap = 0;
    HashMap<Integer, HashMap<Integer, Integer>> snapMap;

    public SnapshotArray(int length) {
        snapMap = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            snapMap.put(i, new HashMap<>());
        }
    }

    public void set(int index, int val) {
        snapMap.get(index).put(snap, val);
    }

    public int snap() {
        snap = snap + 1;
        return snap - 1;
    }

    public int get(int index, int snap_id) {
        if (!snapMap.containsKey(index)) {
            return -1;
        }

        HashMap<Integer, Integer> innerMap = snapMap.get(index);
        while (snap_id >= 0) {

            if (innerMap.containsKey(snap_id)) {
                return innerMap.get(snap_id);
            }

            snap_id--;
        }

        return -1;
    }
}

