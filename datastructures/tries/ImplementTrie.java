package datastructures.tries;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTrie {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = this.root;

            for (char ch : word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }

                current = current.children.get(ch);
            }

            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            TrieNode current = this.root;

            for (char ch : word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }

                current = current.children.get(ch);
            }

            return current.isEndOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode current = this.root;

            for (char ch : prefix.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }

                current = current.children.get(ch);
            }

            return true;
        }
    }
}
