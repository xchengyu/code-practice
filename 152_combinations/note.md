```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Markdown
@Datetime: 17-01-20 08:57
```

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (n == 0 || k == 0) {
		    return res;
		}
		if (k >= n) {
		    List<Integer> ans = new ArrayList<Integer>();
		    for (int i = 1; i <= n; i++) {
		        ans.add(i);
		    }
		    res.add(ans);
		    return res;
		}
		helper(1, n, k, new ArrayList<Integer>(), res);
		return res;
    }
    public void helper(int start, int end, int k, List<Integer> ans, List<List<Integer>> res) {
        if (k == 0){
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        if (end - start + 1 < k) {
            return;
        }
        for (int i = start; i <= end; i++) {
            ans.add(i);
            helper(i + 1, end, k - 1, ans, res);
            ans.remove(ans.size() - 1);
        }
        return;
    }
        // public List<List<Integer>> combine(int n, int k) {
        //     List<List<Integer>>res=new ArrayList<List<Integer>>();
        //     helper(n,k,1,res,new ArrayList<Integer>());
        //     return res;
        // }
        // private void helper(int n,int k,int start,List<List<Integer>>res,List<Integer> tmp)
        // {
        //     if(tmp.size()==k)
        //     {
        //         res.add(new ArrayList(tmp));
        //         return;
        //     }
        //     for(int i=start;i<=n;i++)
        //     {
        //         tmp.add(i);
        //         helper(n,k,i+1,res,tmp);
        //         tmp.remove(tmp.size()-1);
        //     }
        //     return;
        // }
}