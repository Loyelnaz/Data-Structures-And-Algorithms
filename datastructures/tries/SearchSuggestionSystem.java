package datastructures.tries;

import java.util.*;

/**
 * https://leetcode.com/problems/search-suggestions-system/description/
 */
public class SearchSuggestionSystem {
    static class TrieNode {
        Map<Character, TrieNode> children;
        // sort suggestions for each of search word characters
        List<String> suggestions;

        TrieNode() {
            children = new HashMap<>();
            suggestions = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";

        System.out.println(Arrays.asList(suggestedProducts(products, searchWord)));
    }

    /**
     * Time Complexity - O(n.k + m)
     */
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();

        // construct a Trie
        TrieNode current = buildTrie(products);

        // time - O(m), where m is the length of the search word
        for (char ch : searchWord.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
                result.add(current.suggestions);
            } else {
                current.children = new HashMap<>();
                result.add(new ArrayList<>());
            }
        }

        return result;
    }

    // Time complexity - O(n.k)
    private static TrieNode buildTrie(String[] products) {
        TrieNode root = new TrieNode();

        for (String product : products) {
            TrieNode current = root;

            for (char letter : product.toCharArray()) {
                if (!current.children.containsKey(letter)) {
                    current.children.put(letter, new TrieNode());
                }
                current = current.children.get(letter);

                current.suggestions.add(product);
                // Here sorting the list isn't expensive as there would be at max only 4 elements
                Collections.sort(current.suggestions);

                if (current.suggestions.size() > 3) {
                    current.suggestions.remove(current.suggestions.size() - 1);
                }
            }
        }

        return root;
    }
}
