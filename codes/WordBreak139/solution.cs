public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) {
        // f(n) = f(n - word.length) && wordInDict;
        int length = s.Length;
        bool[] check = new bool[length + 1];
        check[0] = true;
        for(int i = 1; i <= length; ++ i){
            for(int j = 0; j < i; ++ j){
                if(check[j] && wordDict.Contains(s.Substring(j, i - j))){
                    check[i] = true;
                    break;
                }
            }
        }
        return check[length];
    }
}