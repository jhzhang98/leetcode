package Medium;

public class ImplementTrie {

}

class Trie {
    Trie[] next;
    boolean isLeaf = true;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        next = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        isLeaf = false;
        char[] chars = word.toCharArray();
        Trie tmp = this;
        for (int i = 0; i < chars.length; i++) {
            char node = chars[i];
            int index = node - 'a';
            if (tmp.next[index] == null) {
                tmp.isLeaf = false;
                tmp.next[index] = new Trie();
            }
            if (i == chars.length - 1)
                tmp.next[index].isLeaf = true;

            tmp = tmp.next[index];
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Trie tmp = this;
        for (char node : chars) {
            int index = node - 'a';
            if (tmp.next[index] == null)
                return false;
            tmp = tmp.next[index];
        }
        return tmp.isLeaf;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Trie tmp = this;
        for (char node : chars) {
            int index = node - 'a';
            if (tmp.next[index] == null)
                return false;
            tmp = tmp.next[index];
        }
        return true;
    }
}