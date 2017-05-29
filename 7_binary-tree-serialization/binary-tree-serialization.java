/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 16-12-30 09:22
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    public String serialize(TreeNode root) {
        // write your code here
        String tree = "";
        if (root == null) {
            return tree + "#";
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    tree += "#,";
                } else {
                    tree += cur.val + ",";
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
        }
        tree = tree.substring(0, tree.length() - 1);
        return tree;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] values = data.split(",");
        if (values[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        int index = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                } else {
                    String left = "#";
                    String right = "#";
                    if (index < values.length) {
                        left = values[index++];
                    }
                    if (index < values.length) {
                        right = values[index++];
                    }
                    if (left.equals("#")) {
                        cur.left = null;
                    } else {
                        cur.left = new TreeNode(Integer.parseInt(left));
                        queue.offer(cur.left);
                    }
                    if (right.equals("#")) {
                        cur.right = null;
                    } else {
                        cur.right = new TreeNode(Integer.parseInt(right));
                        queue.offer(cur.right);
                    }
                }
            }
        }
        return root;
    }
}
// /**
//  * Definition of TreeNode:
//  * public class TreeNode {
//  *     public int val;
//  *     public TreeNode left, right;
//  *     public TreeNode(int val) {
//  *         this.val = val;
//  *         this.left = this.right = null;
//  *     }
//  * }
//  */
// class Solution {
//     private String s = "";
//     Queue<TreeNode> queue = new LinkedList<TreeNode>();
//     /**
//      * This method will be invoked first, you should design your own algorithm 
//      * to serialize a binary tree which denote by a root node to a string which
//      * can be easily deserialized by your own "deserialize" method later.
//      */
//     public String serialize(TreeNode root) {
//         // write your code here
//         if (root == null) {
//             return s + "#";
//         }
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (cur == null) {
//                     s += "#,";
//                 } else {
//                     s += cur.val + ",";
//                     queue.offer(cur.left);
//                     queue.offer(cur.right);
//                 }
//             }
//         }
//         return s.substring(0, s.length() - 1);
//         // Queue<TreeNode> q = new LinkedList<TreeNode>();
//         // String res = "";
//         // int count = root == null ? 0 : 1;
//         // q.offer(root);
//         // while (!q.isEmpty()) {
//         //     if (count == 0) {
//         //         break;
//         //     } else {
//         //         count = 0;
//         //         int size = q.size();
//         //         for (int i = 0; i < size; i++) {
//         //             TreeNode node = q.poll();
//         //             if (node == null) {
//         //                 res += "#,";
//         //             } else {
//         //                 res += node.val + ",";
//         //                 if (node.left != null) {
//         //                     q.offer(node.left);
//         //                     count++;
//         //                 } else {
//         //                     q.offer(null);
//         //                 }
//         //                 if (node.right != null) {
//         //                     q.offer(node.right);
//         //                     count++;
//         //                 } else {
//         //                     q.offer(null);
//         //                 }
//         //             }
//         //         }
//         //     }
//         // }
//         // return res.length() > 0 ? res.substring(0, res.length() - 1) : res;
//     }
    
//     /**
//      * This method will be invoked second, the argument data is what exactly
//      * you serialized at method "serialize", that means the data is not given by
//      * system, it's given by your own serialize method. So the format of data is
//      * designed by yourself, and deserialize it here as you serialize it in 
//      * "serialize" method.
//      */
//     public TreeNode deserialize(String data) {
//         // write your code here
//         // if (data == null || data.length() == 0) {
//         //     return null;
//         // }
//         // String[] elements = data.split(",");
//         // int index = 0;
//         // TreeNode root = new TreeNode(Integer.parseInt(elements[index]));
//         // index++;
//         // Queue<TreeNode> q = new LinkedList<TreeNode>();
//         // q.offer(root);
//         // while (!q.isEmpty()) {
//         //     TreeNode node = q.poll();
//         //     if (index < elements.length) {
//         //         if (elements[index].equals("#")) {
//         //             node.left = null;
//         //         } else {
//         //             TreeNode left = new TreeNode(Integer.parseInt(elements[index]));
//         //             node.left = left;
//         //             q.offer(left);
//         //         }
//         //         index++;
//         //     }
//         //     if (index < elements.length) {
//         //         if (elements[index].equals("#")) {
//         //             node.right = null;
//         //         } else {
//         //             TreeNode right = new TreeNode(Integer.parseInt(elements[index]));
//         //             node.right = right;
//         //             q.offer(right);
//         //         }
//         //         index++;
//         //     }
//         // }
//         // return root;
//         String[] values = data.split(",");
//         TreeNode root = null;
//         if (!values[0].equals("#")) {
//             root = new TreeNode(Integer.parseInt(values[0]));
//         } else {
//             return root;
//         }
//         queue.offer(root);
//         int index = 1;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (cur == null) {
//                     continue;
//                 } else {
//                     String left = "#";
//                     String right = "#";
//                     if (index < values.length) {
//                         left = values[index++];
//                     }
//                     if (index < values.length) {
//                         right = values[index++];
//                     }
//                     if (left.equals("#")) {
//                         cur.left = null;
//                     } else {
//                         cur.left = new TreeNode(Integer.parseInt(left));
//                         queue.offer(cur.left);
//                     }
//                     if (right.equals("#")) {
//                         cur.right = null;
//                     } else {
//                         cur.right = new TreeNode(Integer.parseInt(right));
//                         queue.offer(cur.right);
//                     }
//                 }
//             }
//         }
//         return root;
//     }
// }
