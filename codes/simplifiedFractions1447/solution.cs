public class Solution {
    public IList<string> SimplifiedFractions(int n) {
        IList<string> res = new List<string>();
        for(int i = 2; i <= n; ++ i){
            for(int j = 1; j < i; ++ j){
                if( GCD(j, i) == 1 || j == 1){
                    res.Add(j + "/" + i);
                }
            }
        }
        return res;
    }

    // 查找最大公约数
    public int GCD(int a, int b) {
        return b != 0 ? GCD(b, a % b) : a;
    }
}