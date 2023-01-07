package datastructures.arraysandstrings.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeSimilarItems {
    public static void main(String[] args) {
        int[][] items1 = {{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};

        System.out.println(mergeSimilarItems(items1, items2));
    }

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(items2, Comparator.comparingInt(a -> a[0]));

        int len1 = items1.length, len2 = items2.length;
        int i = 0, j = 0;
        List<List<Integer>> result = new ArrayList<>();

        while (i < len1 && j < len2) {
            List<Integer> items = new ArrayList<>();
            if (items1[i][0] == items2[j][0]) {
                items.add(items1[i][0]);
                items.add(items1[i][1] + items2[j][1]);
                i++;
                j++;
            } else if (items1[i][0] < items2[j][0]) {
                items.add(items1[i][0]);
                items.add(items1[i][1]);
                i++;
            } else {
                items.add(items2[j][0]);
                items.add(items2[j][1]);
                j++;
            }
            result.add(items);
        }

        while (i < len1) {
            List<Integer> items = new ArrayList<>();
            items.add(items1[i][0]);
            items.add(items1[i][1]);
            result.add(items);
            i++;
        }

        while (j < len2) {
            List<Integer> items = new ArrayList<>();
            items.add(items2[j][0]);
            items.add(items2[j][1]);
            result.add(items);
            j++;
        }

        return result;
    }
}
