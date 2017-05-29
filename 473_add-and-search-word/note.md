```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Markdown
@Datetime: 17-01-16 09:04
```

class TrieNode {
    public HashMap<Character, TrieNode> children;
    public boolean hasWord;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        hasWord = false;
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
        TrieNode now = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!now.children.containsKey(c)) {
                now.children.put(c, new TrieNode());
            }
            now = now.children.get(c);
        }
        now.hasWord = true;
        return;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
    
    public boolean find(String word, int index, TrieNode now) {
        if (index == word.length()) {
            return now.hasWord;
        }
        char c = word.charAt(index);
        if (now.children.containsKey(c)) {
            if (index == word.length() - 1 && now.children.get(c).hasWord) {
                return true;
            } else {
                return find(word, index + 1, now.children.get(c));
            }
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> child: now.children.entrySet()){
                if (index == word.length() - 1 && child.getValue().hasWord){
                    return true;
                } 
 
                //if any path is true, set result to be true; 
                if (find(word, index + 1, child.getValue())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}