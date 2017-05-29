/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Java
@Datetime: 16-08-29 22:23
*/

class TrieNode {
    public boolean isString;
    public String str;
    public Map<Character, TrieNode> children;
    public TrieNode() {
        this.children = new HashMap<Character, TrieNode>();
        this.isString = false;
        this.str = "";
    }
}

class TrieTree {
    public TrieNode root;
    public TrieTree() {
        this.root = new TrieNode();
    }
        
    public void add(String word) {
        TrieNode head = root;
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];
            if (!head.children.containsKey(ch)) {
                head.children.put(ch, new TrieNode());
            }
            head = head.children.get(ch);
        }
        head.isString = true;
        head.str = word;
        return;
    }
    
    public boolean search(String word) {
        TrieNode head = root;
        char[] characters = word.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            char ch = characters[i];
            if (!head.children.containsKey(ch)) {
                head.children.put(ch, new TrieNode());
            }
            head = head.children.get(ch);
        }
        return head.isString && head.str.equals(word);
    }
}
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        TrieTree tree = new TrieTree();
        for (String word : words) {
            tree.add(word);
        }
        TrieNode root = tree.root;
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    dfs(res, root, board, i, j);
                }
            }
        }
        return res;
    }
    
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    
    public void dfs(ArrayList<String> res, TrieNode root, char[][] board, int x, int y) {
        if (root.isString) {
            if(!res.contains(root.str)){
                res.add(new String(root.str));
            }
        }
        int row = board.length;
        int col = board[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] == '#' || !root.children.containsKey(board[x][y])) {
            return;
        }
        char cur = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(res, root.children.get(cur), board, newX, newY);
        }
        board[x][y] = cur;
        return;
    }
}