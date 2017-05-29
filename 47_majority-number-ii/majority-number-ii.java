/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/majority-number-ii
@Language: Java
@Datetime: 16-08-16 05:19
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        // int elem1 = 0;
        // int elem2 = 0;
        // int count1 = 0;
        // int count2 = 0;
        // for (int i = 0; i < nums.size(); i++) {
        //     if (elem1 == nums.get(i)) {
        //         count1++;
        //     } else if (elem2 == nums.get(i)) {
        //         count2++;
        //     } else if (count1 == 0) {
        //         elem1 = nums.get(i);
        //         count1 = 1;
        //     } else if (count2 == 0) {
        //         elem2 = nums.get(i);
        //         count2 = 1;
        //     } else {
        //         count1--;
        //         count2--;
        //     }
        // }
        // count1 = count2 = 0;
        // for (int i = 0; i < nums.size(); i++) {
        //     if (nums.get(i) == elem1) {
        //         count1++;
        //     } else if (nums.get(i) == elem2) {
        //         count2++;
        //     }
        // }    
        // return count1 > count2 ? elem1 : elem2;
        int elem1 = 0;
        int elem2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (Integer num : nums) {
            if (num == elem1 || num == elem2) {
                if (num == elem1) {
                    count1++;
                } else {
                    count2++;
                } 
            }else {
                if (count1 == 0) {
                    elem1 = num;
                    count1 = 1;
                } else if (count2 == 0) {
                    elem2 = num;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer num : nums) {
            if (num == elem1) {
                count1++;
            } else if (num == elem2) {
                count2++;
            } else {
                continue;
            }
        }
        return count1 > count2 ? elem1 : elem2;
    }
}
