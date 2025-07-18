package datastructures.graphs;

import com.sun.tools.javac.util.List;

import java.util.HashSet;
import java.util.Set;

/**
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. When you visit a room, you may find a set of distinct keys in it.
 * Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 *
 * https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * Time Complexity - O(n + e), as we visit each node once and the for loops inside each visit will iterate up to "e" times
     *                             total across the entire algorithm.
     * Space Complexity - O(n)
     */
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>(); // O(n) as only nodes are stored
        visited.add(0);
        dfs(rooms, visited, 0);

        return visited.size() == rooms.size();
    }

    private static void dfs(List<List<Integer>> rooms, Set<Integer> visited, int node) {
        for (Integer room : rooms.get(node)) { // O(n)
            if (!visited.contains(room)) {
                visited.add(room);
                dfs(rooms, visited, room);
            }
        }
    }
}
