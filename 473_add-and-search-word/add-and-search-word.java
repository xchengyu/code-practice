/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Java
@Datetime: 17-01-16 09:04
*/

class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isWord = false;
    }
}
public class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
        return;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
    public boolean find(String word, int start, TrieNode cur) {
        if (cur == null) {
            return false;
        }
        if (start == word.length()) {
            return cur.isWord;
        }
        char ch = word.charAt(start);
        if (ch != '.') {
            return find(word, start + 1, cur.children.get(ch));
        } else {
            boolean hasWord = false;
            for (Map.Entry<Character, TrieNode> entry : cur.children.entrySet()) {
                hasWord = find(word, start + 1, entry.getValue());
                if (hasWord) {
                    break;
                }
            }
            return hasWord;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");