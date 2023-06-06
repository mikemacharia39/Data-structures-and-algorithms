package javasolutionsforalgorithms.revision_v2.leetcode.google.unstructured;

import java.util.HashMap;

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

