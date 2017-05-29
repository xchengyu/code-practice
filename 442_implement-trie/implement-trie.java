/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 17-01-17 06:58
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public Map<Character, TrieNode> children;
    public boolean hasWord;
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.hasWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.hasWord = true;
        return;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        return cur.hasWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!cur.children.containsKey(ch)) {
                return false;
            }
            cur = cur.children.get(ch);
        }
        if (cur.hasWord) {
            return true;
        }
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            TrieNode tmp = queue.poll();
            if (tmp.hasWord) {
                return true;
            } else {
                for (Map.Entry<Character, TrieNode> entry : tmp.children.entrySet()) {
                    queue.offer(entry.getValue());
                }
            }
        }
        return false;
    }
}