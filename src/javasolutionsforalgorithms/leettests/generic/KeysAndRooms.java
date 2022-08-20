package javasolutionsforalgorithms.leettests.generic;

import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/keys-and-rooms/">...</a>
 *
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 *
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 *
 * Example 1:
 *
 * Input: rooms = [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We visit room 0 and pick up key 1.
 * We then visit room 1 and pick up key 2.
 * We then visit room 2 and pick up key 3.
 * We then visit room 3.
 * Since we were able to visit every room, we return true.
 *
 * Example 2:
 *
 * Input: rooms = [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */
public class KeysAndRooms {

    /**
     * The approach for this solution is:
     * When you enter a room, add the room key to a stack
     * using the key in the stack, visit the room and while adding the keys.
     *
     * In simple terms navigate the ability to navigate to a room is based on keys present in previous rooms
     * By the end of it all if you are unable to visit all rooms using the keys then return false otherwise true
     *
     * @param rooms rooms
     * @return true|false
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> roomKey = new Stack<>();

        visited[0] = true;
        roomKey.push(0);
        while (!roomKey.isEmpty()) {
            int key = roomKey.pop();
            List<Integer> room = rooms.get(key);
            for (int j = 0; j < room.size(); j++) {
                if (!visited[room.get(j)]) {
                    visited[room.get(j)] = true;
                    roomKey.push(room.get(j));
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}
