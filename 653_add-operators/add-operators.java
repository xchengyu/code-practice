/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-operators
@Language: Java
@Datetime: 17-05-19 08:01
*/

public class Solution {
    /**
     * @param num a string contains only digits 0-9
     * @param target an integer
     * @return return all possibilities
     */
    public List<String> addOperators(String num, int target) {
        // Write your code here
        List<String> results = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return results;
        }
        helper(results, "", num, target, 0, 0, 0);
        return results;
    }
    public void helper(List<String> results, String path, String num, int target, int pos, long eval, long multed){
        if (pos == num.length()){
            if(target == eval)
                results.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(results, path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(results, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                helper(results, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                helper(results, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}