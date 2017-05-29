```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Markdown
@Datetime: 17-05-26 01:53
```

public class Solution {
    class SegmentTreeNode {
        public int start;
        public int end;
        public int count;
        public SegmentTreeNode left;
        public SegmentTreeNode right;
        public SegmentTreeNode(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }
    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        if(start > end) {  // check core case
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        
        if(start != end) {
            int mid = (start + end) / 2;
            root.left = build(start, mid);
            root.right = build(mid+1, end);
        } else {
            root.count =  0;
        }
        return root;
    }
    public int query(SegmentTreeNode root, int start, int end) {
        if(start == root.start && root.end == end) { // 相等 
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        int leftcount = 0;
        int rightcount = 0;
        // 左子区
        if(start <= mid) {
            if( mid < end) { // 分裂 
                leftcount =  query(root.left, start, mid);
            } else { // 包含 
                leftcount = query(root.left, start, end);
            }
        }
        // 右子区
        if(mid < end) { // 分裂 3
            if(start <= mid) {
                rightcount = query(root.right, mid+1, end);
            } else { //  包含 
                rightcount = query(root.right, start, end);
            } 
        }  
        return leftcount + rightcount;
    }
    public void modify(SegmentTreeNode root, int index, int val) {
        if (root.start == index && root.end == index) {
            root.count += val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (root.start <= index && index <= mid) {
            modify(root.left, index, val);
        } 
        if(mid < index && index <= root.end) {
            modify(root.right, index, val);
        }
        root.count = root.left.count + root.right.count;
        return;
    }
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        //SegmentTree
        ArrayList<Integer> res = new ArrayList<Integer>();
        root = build(0, 10000);
        for (int num : A) {
            modify(root, num, 1);
        }
        for (int num : queries) {
            int tmp = 0;
            if (num >= 0) {
                tmp = query(root, 0, num - 1);
            }
            res.add(tmp);
        }
        //quick sort
        // for (int pivot : queries) {
        //     int left = -1;
        //     int right = A.length;
        //     int index = 0;
        //     while (index < right) {
        //         if (A[index] < pivot) {
        //             left++;
        //             int tmp = A[left];
        //             A[left] = A[index];
        //             A[index] = tmp;
        //             index++;
        //         } else if (A[index] == pivot) {
        //             index++;
        //         } else {
        //             right--;
        //             int tmp = A[right];
        //             A[right] = A[index];
        //             A[index] = tmp;
        //         }
        //     }
        //     res.add(left - 0 + 1);
        // }
        
        //binary search
        // Arrays.sort(A);
        // for (int pivot : queries) {
        //     int left = 0;
        //     int right = A.length - 1;
        //     int mid = 0;
        //     boolean flag = false;
        //     boolean aNull = true;
        //     while (left <= right) {
        //         aNull = false;
        //         mid = left + (right - left) / 2;
        //         if (A[mid] > pivot) {
        //             right = mid - 1;
        //         } else if (A[mid] == pivot){
        //             flag = true;
        //             while (mid >= 0 && A[mid] == pivot) {
        //                 mid--;
        //             }
        //             break;
        //         } else {
        //             left = mid + 1;
        //         }
        //     }
        //     if (aNull) {
        //         res.add(mid);
        //     } else if (flag) {
        //         res.add(mid + 1);
        //     }else {
        //         int tmp = A[mid] > pivot ? mid : mid + 1;
        //         res.add(tmp);
        //     }
        // }
        return res;
    }
}
