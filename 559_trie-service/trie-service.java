/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trie-service
@Language: Java
@Datetime: 16-08-14 23:23
*/

/**
 * Definition of TrieNode:
 * public class TrieNode {
 *     public NavigableMap<Character, TrieNode> children;
 *     public List<Integer> top10;
 *     public TrieNode() {
 *         children = new TreeMap<Character, TrieNode>();
 *         List<Integer> top10 = new ArrayList<Integer>();
 *     }
 * }
 */
class Order implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        if (a > b) {
            return -1;
        } else {
            return 1;
        }
    }
}
public class TrieService {

    private TrieNode root = null;

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and 
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        char[] character = word.toCharArray();
        TrieNode head = root;
        for (int i = 0; i < character.length; i++) {
            if (head.children.containsKey(character[i])) {
                TrieNode child = head.children.get(character[i]);
                insertList(child.top10, frequency);
                head = child;
            } else {
                head.children.put(character[i], new TrieNode());
                TrieNode child = head.children.get(character[i]);
                insertList(child.top10, frequency);
                head = child;
            }
        }
    }
    
    public void insertList(List<Integer> top10, int frequency) {
        if (top10.size() < 10) {
            top10.add(frequency);
            Collections.sort(top10, new Order());
            return;
        } else {
            int last = top10.get(top10.size() - 1);
            if (frequency < last) {
                return;
            } else {
                top10.remove(top10.size() - 1);
                top10.add(frequency);
                Collections.sort(top10, new Order());
                return;
            }
        }
    }
 }