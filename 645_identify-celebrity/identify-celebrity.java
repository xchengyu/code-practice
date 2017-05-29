/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/identify-celebrity
@Language: Java
@Datetime: 17-05-08 09:04
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here
        // if (n <= 0) {
        //     return -1;
        // }
        // if (n == 1) {
        //     return 0;
        // }
        // int[] people = new int[n];
        // for (int i = 0; i < n; i++) {
        //     if (people[i] == 1) {
        //         continue;
        //     } else {
        //         boolean isCelebrity = true;
        //         for (int j = 0; j < n; j++) {
        //             if ((j < i && people[j] == 0) || j == i) {
        //                 continue;
        //             } else {
        //                 if (knows(i, j)) {
        //                     people[i] = 1;
        //                     isCelebrity = false;
        //                 }
        //                 if (knows(j, i)) {
        //                     people[j] = 1;
        //                 }
        //                 if (!isCelebrity) {
        //                     break;
        //                 }
        //             }
        //         }
        //         people[i] = isCelebrity? 0 : 1;
        //     }
        // }
        // int index = -1;
        // for (int i = 0; i < n; i++) {
        //     if (people[i] == 0) {
        //         index = i;
        //         break;
        //     }
        // }
        // if (index == -1) {
        //     return -1;
        // } else {
        //     for (int i = 0; i < n; i++) {
        //         if (i != index && !knows(i, index)) {
        //             return -1;
        //         }
        //     }
        // }
        // return index;
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for(int i = 0; i < candidate; i++) {
            if(knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }
        for(int i = candidate + 1; i < n; i++) {
            if(!knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;
    }
}