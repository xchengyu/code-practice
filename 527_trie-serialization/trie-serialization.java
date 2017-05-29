/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trie-serialization
@Language: Java
@Datetime: 16-07-26 10:30
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *     }
 * }
 */
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a trie which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TrieNode root) {
        // Write your code here
        if (root == null) {
            return "";
        }
        StringBuilder  sb = new StringBuilder();
        sb.append("<");
        for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
            sb.append(entry.getKey());
            sb.append(serialize(entry.getValue()));
        }
        sb.append(">");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TrieNode deserialize(String data) {
        // Write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        TrieNode root = new TrieNode();
        Stack<TrieNode> stack = new Stack<TrieNode>();
        TrieNode current = root;
        for (Character ch : data.toCharArray()) {
            if (ch == '<') {
                stack.push(current);
            } else if (ch == '>') {
                stack.pop();
            } else {
                current = new TrieNode();
                stack.peek().children.put(ch, current);
            }
        }
        return root;
    }
}
