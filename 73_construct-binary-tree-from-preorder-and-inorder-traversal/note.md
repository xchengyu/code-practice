```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Markdown
@Datetime: 17-01-28 08:15
```

public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        int position = find(inorder, instart, inend, preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = build(preorder, prestart + 1, prestart + position - instart, inorder, instart, position - 1);
        root.right = build(preorder, prestart + position - instart + 1, preend, inorder, position + 1, inend);
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