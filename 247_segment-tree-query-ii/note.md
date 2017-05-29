```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-query-ii
@Language: Markdown
@Datetime: 17-05-25 08:39
```

if(start > end || root==null)
            return 0;
        if(start <= root.start && root.end <= end) { // 相等 这个地方不同于query 1那道题，这很关键,因为这个地方是值域搜素，而之前那道题是index范围搜索，值域搜索的范围可能超过【start，end】，但是index范围搜索它的搜索范围是不会超出【start，end】范围
            return root.count;
        }
        
        int mid = (root.start + root.end)/2;
        int leftsum = 0, rightsum = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂 
                leftsum =  query(root.left, start, mid);
            } else { // 包含 
                leftsum = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightsum = query(root.right, mid+1, end);
            } else { //  包含 
                rightsum = query(root.right, start, end);
            } 
        }  
        // else 就是不相交
        return leftsum + rightsum;