```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Markdown
@Datetime: 16-09-02 08:16
```

class SegmentTreeNode {
    public int count;
    public SegmentTreeNode left, right;
    public int start, end;
    public SegmentTreeNode (int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.left = this.right = null;
        this.count = count;
    }
}
public class Solution {
    public SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = (start + end) / 2;
            SegmentTreeNode left = build(start, mid);
            SegmentTreeNode right = build(mid + 1, end);
            root.left = left;
            root.right = right;
        } else {
            root.count = 0;
        }
        return root;
    }
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.count;
        }
        int mid = (root.start + root.end) / 2;
        int leftcount = 0;
        int rightcount = 0;
        if (start <= mid) {
            if (end <= mid) {
                leftcount = query(root.left, start, end);
            } else {
                leftcount = query(root.left, start, mid);
            }
        }
        if (mid < end) {
            if (start <= mid) {
                rightcount = query(root.right, mid + 1, end);
            } else {
                rightcount = query(root.right, start, end);
            }
        }
        return leftcount + rightcount;
    }
    public void modify(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index) { // 查找到
            root.count += value;
            return;
        }
        
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modify(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        //更新
        root.count = root.left.count + root.right.count;
    }
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return res;
        }
        root = build(0, 10000);//用值域建SegmentTree
        for (int i = 0; i < A.length; i++) {
            int ans = 0;
            if (A[i] > 0) {
                ans = query(root, 0, A[i] - 1);
            }
            res.add(ans);
            modify(root, A[i], 1);//按顺序加入值，所以之前一步求出的ans就是到当前位置时，之前位置中比当前位置的值小的个数
        }
        return res;
    }
}