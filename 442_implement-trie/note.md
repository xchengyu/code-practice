```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Markdown
@Datetime: 17-01-17 06:58
```

class TrieNode {
    // Initialize your data structure here.
    public boolean isString;
    public String str;
    public Map<Character, TrieNode> map;
    public TrieNode() {
        this.isString = false;
        this.str = null;
        map = new HashMap<Character, TrieNode>();
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode head = root;
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!head.map.containsKey(ch[i])) {
                head.map.put(ch[i], new TrieNode());
            }
            head = head.map.get(ch[i]);
        }
        head.str = word;
        head.isString = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode head = root;
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!head.map.containsKey(ch[i])) {
                return false;
            }
            head = head.map.get(ch[i]);
        }
        return head.isString;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        char[] ch = prefix.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (!head.map.containsKey(ch[i])) {
                return false;
            }
            head = head.map.get(ch[i]);
        }
        Queue<TrieNode> queue = new LinkedList<TrieNode>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            TrieNode cur = queue.poll();
            if (cur.isString) {
                return true;
            }
            for (Map.Entry<Character, TrieNode> entry : cur.map.entrySet()) {
                char key = entry.getKey();
                queue.offer(cur.map.get(key));
            }
        }
        return false;
    }
}