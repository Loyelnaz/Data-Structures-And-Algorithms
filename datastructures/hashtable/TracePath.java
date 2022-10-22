package datastructures.hashtable;

import java.util.HashMap;

/**
 * Find the starting point of a journey and print out the complete path from start to end
 */
public class TracePath {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("Bangalore", "Delhi");
        map.put("Mumbai", "Chennai");
        map.put("Kolkata", "Bangalore");
        map.put("Chennai", "Kolkata");
        map.put("Kerala", "Chennai");

        String result = tracePath(map);
        System.out.println(result);
    }

    public static String tracePath(HashMap<String,String> map) {
        String startingPoint = null;
        // We would first need to figure out the starting point
        // The key that is not present as the value in the map is considered to be our starting point
        for (String key : map.keySet()) {
            if (!map.containsValue(key)) {
                startingPoint = key;
            }
        }

        String source = startingPoint;
        StringBuilder result = new StringBuilder();
        while (map.containsKey(source)) {
            String value = map.get(source);
            result.append(source);
            result.append("->");
            result.append(value);
            result.append(", ");

            // update the source
            source = value;
        }

        return result.toString();
    }
}
