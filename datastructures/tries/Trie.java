package datastructures.tries;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TrieNode {
        // we can store data at each node based on the problem requirement
        // the data can be of any type
        int data;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
        }
    }

    /**
     * Time complexity - O(n.k), where 'n' is the length of the words array,
     *                           and 'k' is the length of each word in the array
     */
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }

                current = current.children.get(ch);
            }
        }

        return root;
    }
}
