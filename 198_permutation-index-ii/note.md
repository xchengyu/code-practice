```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutation-index-ii
@Language: Markdown
@Datetime: 16-08-21 06:56
```

完全是数学问题。
简单的，现在有m个数，里面有1个数重复了n次，求全排列。
答：从m个位置中选n个位置放置这n个重复的数，选法有Cnm（n是上标，m是下标），这个值是m! / ( (m - n)! * n!)。对于剩下的m - n个空，我们要放置m - n个不重复的数，放置方案的总数有 （m - n）！个，所以总的排列个数有m ！/ n ！个。
推广到这道题， M个元素中含有相同的元素，如何得到他们的全排列（不重复排列）？ 

元素表述：   a1,a1,...a1,   a2,a2,...a2,.......,an,an,...an 
  其中，a1的个数为N1,   a2的个数为N2,以此类推，总个数为M。 

则可以证明不重复的排列种类的数目:   M!/(N1!*N2!*...*Nn!) 
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long fac(int numerator) {
			
		long now = 1;
		for (int i = 1; i <= numerator; i++) {
			now *= (long) i;
		}
		return now;
	}
	
	public long generateNum(HashMap<Integer, Integer> hash) {
		long denominator = 1;
		int sum = 0;
		for (int val : hash.values()) {
			if(val == 0 )	
				continue;
			denominator *= fac(val);//see Notes
			sum += val;//total number we can use in combination
		}
		if(sum == 0) {//no number available in combination.If total number is n and we have know where n - 1 are located, then the nth number has no choice but the remains position, so the combination is 0
			return sum;
		}
		return fac(sum) / denominator;
	}

	public long permutationIndexII(int[] A) {
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();//find out how many times every number appears in A[]
		
		for (int i = 0; i < A.length; i++) {
			if (hash.containsKey(A[i]))
				hash.put(A[i], hash.get(A[i]) + 1);
			else {
				hash.put(A[i], 1);
			}
		}
		long ans = 0;
		for (int i = 0; i < A.length; i++) {
			HashMap<Integer, Integer> flag = new HashMap<Integer, Integer>();
			
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[i] && !flag.containsKey(A[j])) {
				// A[j] < A[i] is reverse pair we are looking for. If flag.containsKey(A[j]) == true, this means A[j] has appeared before, so we shouldn't calculate again.
				    flag.put(A[j], 1);
				
					hash.put(A[j], hash.get(A[j]) - 1);//use A[j] at postion i
					ans += generateNum(hash);// how many no repeating combinations after position i
					hash.put(A[j], hash.get(A[j]) + 1);// maybe use again in the following position
					
				}
			
			}
			hash.put(A[i], hash.get(A[i]) - 1);//use A[i] at postion i
		}
		
		return ans + 1;//based on 1 not 0

	}
}