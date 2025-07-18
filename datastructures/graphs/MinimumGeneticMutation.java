package datastructures.graphs;

import java.util.*;

/**
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene
 * where one mutation is defined as one single character changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 *
 * There is also a gene bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank,
 * return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 *
 * https://leetcode.com/problems/minimum-genetic-mutation/description/
 */
public class MinimumGeneticMutation {

    public static void main(String[] args) {
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        System.out.print(minMutation("AACCGGTT", "AAACGGTA", bank));
    }

    static class Pair {
        String gene;
        int steps;

        Pair (String gene, int steps) {
            this.gene = gene;
            this.steps = steps;
        }
    }

    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (!bankContains(bank, endGene)) {
            return -1;
        }

        Set<String> seen = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        seen.add(startGene);
        queue.add(new Pair(startGene, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            String gene = pair.gene;
            int steps = pair.steps;

            if (gene.equals(endGene)) {
                return steps;
            }

            for (String neighbor : neighbors(gene)) {
                if (!seen.contains(neighbor) && bankContains(bank, neighbor)) {
                    seen.add(neighbor);
                    queue.add(new Pair(neighbor, steps + 1));
                }
            }
        }

        return -1;
    }

    private static List<String> neighbors(String gene) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (char choice : new char[]{'A', 'C', 'G', 'T'}) {
                if (gene.charAt(i) != choice) {
                    result.add(gene.substring(0, i) + choice + gene.substring(i + 1));
                }
            }
        }
        return result;
    }

    private static boolean bankContains(String[] bank, String target) {
        for (String str : bank) {
            if (str.equals(target)) {
                return true;
            }
        }
        return false;
    }
}
