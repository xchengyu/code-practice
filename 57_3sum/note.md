```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Markdown
@Datetime: 17-01-28 08:33
```

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            } else {
                int left = i + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    int sum = numbers[i] + numbers[left] + numbers[right];
                    if (sum == 0) {
                        ArrayList<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(numbers[i]);
                        tmp.add(numbers[left]);
                        tmp.add(numbers[right]);
                        res.add(tmp);
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
// public class Solution {
//     /**
//      * @param numbers : Give an array numbers of n integer
//      * @return : Find all unique triplets in the array which gives the sum of zero.
//      */
//     public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
//         // write your code here
//         if (numbers == null || numbers.length == 0) {
//             return new ArrayList<ArrayList<Integer>>();
//         }
//         ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//         Arrays.sort(numbers);
//         for (int i = 0; i < numbers.length - 2; i++) {
//             if (i != 0 && numbers[i] == numbers[i - 1]) {
//                 continue;
//             }
//             int left = i + 1;
//             int right = numbers.length - 1;
//             while (left < right) {
//                 int sum = numbers[left] + numbers[right] + numbers[i];
//                 if (sum == 0) {
//                     ArrayList<Integer> tmp = new ArrayList<Integer>();
//                     tmp.add(numbers[i]);
//                     tmp.add(numbers[left]);
//                     tmp.add(numbers[right]);
//                     res.add(tmp);
//                     left++;
//                     right--;
//                     while (left < right && numbers[left] == numbers[left - 1]) {
//                         left++;
//                     }
//                     while (left < right && numbers[right] == numbers[right + 1]) {
//                         right--;
//                     }
//                 } else if (sum < 0) {
//                     left++;
//                 } else {
//                     right--;
//                 }
//             }
//         }
//         return res;
//     }
// }