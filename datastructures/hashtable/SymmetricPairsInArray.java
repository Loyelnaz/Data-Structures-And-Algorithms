package datastructures.hashtable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Find first occurrences of all the symmetric pairs in the given array.
 * By definition, (a,b) and (c,d) are symmetric pairs if a = d and b = c.
 *
 * Input - {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}}
 * Output - {3, 4}, {5, 9}
 */
public class SymmetricPairsInArray {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};

        ArrayList<ArrayList<Integer>> result = findSymmetric(arr);
        for (ArrayList<Integer> list : result) {
            System.out.println("{" + list.get(0) + ", " + list.get(1) + "}");
        }
    }

    public static ArrayList<ArrayList<Integer>> findSymmetric(int[][] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i][1])) {
                int value = map.get(arr[i][1]);
                if (value == arr[i][0]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i][1]);
                    temp.add(arr[i][0]);
                    result.add(temp);
                }
            } else {
                map.put(arr[i][0], arr[i][1]);
            }
        }

        return result;
    }
}
