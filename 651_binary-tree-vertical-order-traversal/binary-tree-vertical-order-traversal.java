/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-vertical-order-traversal
@Language: Java
@Datetime: 17-05-14 11:15
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Node {
    public int col;
    public TreeNode node;
    public Node (TreeNode node, int col) {
        this.node = node;
        this.col = col;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the vertical order traversal
     */
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(new Node(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (!map.containsKey(cur.col)) {
                    map.put(cur.col, new ArrayList<Integer>());
                }
                map.get(cur.col).add(cur.node.val);
                if (cur.node.left != null) {
                    queue.offer(new Node(cur.node.left, cur.col - 1));
                }
                if (cur.node.right != null) {
                    queue.offer(new Node(cur.node.right, cur.col + 1));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            min = Math.min(min, entry.getKey());
            max = Math.max(max, entry.getKey());
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}