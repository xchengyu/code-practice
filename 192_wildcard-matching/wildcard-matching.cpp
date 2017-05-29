/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: C++
@Datetime: 16-07-10 09:44
*/

class Solution {
public:
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    bool isMatch(const char *s, const char *p) {
        // write your code here
        const char *presp = NULL, *press = NULL;    //previous starting comparison place after * in s and p.
        bool startFound = false;
        while(*s != '\0'){
            if(*p == '?'){++s; ++p;}
            else if(*p == '*'){
                presp = ++p;
                press = s;
                startFound = true;
            }else{
                if(*p == *s){
                    ++p;
                    ++s;
                }else if(startFound){
                    p = presp;
                    s = (++press);
                }else return false;
            }
        }
        while(*p == '*') ++p;
        return *p == '\0';
    }
};