```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Markdown
@Datetime: 16-08-16 07:26
```

public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if (postorder.length != inorder.length) {
            return null;
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        int position = find(inorder, instart, inend, postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        root.left = build(postorder, poststart, poststart + position - instart - 1, inorder, instart, position - 1);
        root.right = build(postorder, poststart + position - instart, postend - 1, inorder, position + 1, inend);
        return root;
    }
    public int find(int[] inorder, int instart, int inend, int key){
        int i;
        for (i = instart; i <= inend; i++) {
            if (inorder[i] == key) {
                break;
            }
        }
        return i;
    }