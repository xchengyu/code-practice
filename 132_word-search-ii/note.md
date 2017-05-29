```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Markdown
@Datetime: 16-08-29 22:23
```

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.size() == 0) {
            return res;
        }
        for (String str : words) {
            if (exist(board, str)) {
                res.add(str);
            }
        }
        return res;
    }
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
                return true;
        }
        if (board[0].length == 0) 
        {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        if (row * col < word.length()) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(helper(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int x, int y, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt(index)) {
            return false;
        }
        board[x][y] = '#';
        boolean result = (helper(board, x + 1, y, index + 1, word) || helper(board, x - 1, y, index + 1, word) || helper(board, x, y + 1, index + 1, word) || helper(board, x, y - 1, index + 1, word));
        board[x][y] = word.charAt(index);
        return result;
    }
}
class TrieNode {
    public HashMap<Character, TrieNode> subtree;
    public boolean isString;
    public String str;
    public TrieNode() {
        isString = false;
        subtree = new HashMap<Character, TrieNode>();
        str = "";
    }
}
class TrieTree {
    public TrieNode root;
    public TrieTree(TrieNode root) {
        this.root = root;
    }
    public void insert(String s) {
        TrieNode now = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!now.subtree.containsKey(c)) {
                now.subtree.put(c, new TrieNode());
            }
            now = now.subtree.get(c);
        }
        now.str = s;
        now.isString = true;
    }
    public boolean find(String s) {
        TrieNode now = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!now.subtree.containsKey(c)) {
                return false;
            }
            now = now.subtree.get(c);
        }
        return now.isString;
    }
}


public class Solution {
    public int []dx = {1, 0, -1, 0};
    public int []dy = {0, 1, 0, -1};
    
    public void search(char[][] board, int x, int y, TrieNode root, ArrayList<String> res) {    
        if(root.isString == true)
        {
            if(!res.contains(root.str)){
                res.add(root.str);
            }
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y]==0 || root == null)
            return ;
        if(root.subtree.containsKey(board[x][y])){
            for(int i = 0; i < 4; i++){
                char now = board[x][y];
                board[x][y] = 0;
                search(board, x+dx[i], y+dy[i], root.subtree.get(now), res);
                board[x][y] = now;
            }
        }
        
    }
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, tree.root, res);
            }
        }
        return res;
    }
}