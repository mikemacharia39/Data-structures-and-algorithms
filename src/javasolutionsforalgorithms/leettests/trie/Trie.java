package javasolutionsforalgorithms.leettests.trie;

/**
 * A trie, also called digital tree or prefix tree, is a type of k-ary search tree,
 * a tree data structure used for locating specific keys from within a set.
 * These keys are most often strings, with links between nodes defined not by the entire key, but by individual characters.
 *
 * A trie would be thought of as the combination of a hashtable and a tree
 *
 * A tree is a general structure of recursive nodes.
 * There are many types of trees. Popular ones are binary tree and balanced tree.
 * A Trie is a kind of tree, known by many names including prefix tree, digital search tree, and retrieval tree
 * (hence the name 'trie').
 *
 * Advantages
 * Trie allows us to input and finds strings in O(l) time, where l is the length of a single word.
 * It is faster as compared to both hash tables and binary search trees.
 * It provides alphabetical filtering of entries by the key of the node and hence makes it easier to print all words in
 * alphabetical order
 */
public class Trie {

    private TrieNode root;                                // the start of a trie is always the root node

    public Trie () {
        this.root = new TrieNode();
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];     // size 26 for only english words a -> z
            this.isWord = false;                  // if is a complete word then is true
        }
    }

    public static void main(String[] args) {

    }
}
