public class Solution {
    public int NumDecodings(string s) {
        int length = s.Length;
        int pre2 = 0, pre1 = 1;
        int res = 0;
        for(int i = 1; i <= length; ++ i){
            // 一定要记得归零res，因为每次的res都是根据前两个值加起来，而非所有的状态累加。
            res = 0;
            if(s[i - 1] != '0'){
                res += pre1;
            }
            if(i > 1 && s[i - 2] != '0' && (s[i - 2] - '0') * 10 + (s[i - 1] - '0') <= 26){
                res += pre2;
            }
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }
}