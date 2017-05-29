/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 17-01-11 08:56
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    private static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
};
// class Solution {
//     /**
//      * @return: The same instance of this class every time
//      */
//     private static Solution instance = null;
//     public static Solution getInstance() {
//         // write your code here
//         if (instance == null) {
//             instance = new Solution();
//         }
//         return instance;
//     }
// };