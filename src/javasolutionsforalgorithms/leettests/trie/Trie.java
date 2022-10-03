package javasolutionsforalgorithms.leettests.trie;

public class Trie {

    private static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
