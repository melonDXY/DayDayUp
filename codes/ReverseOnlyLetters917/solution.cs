public class Solution {
    public string ReverseOnlyLetters(string s) {
        // 双指针 easy
        int length = s.Length;
        char[] res = s.ToCharArray();
        int l = 0, r = length - 1;
        while(l < r){
            while(l < r && !IsAlpha(res[l])){
                ++ l;
            }
            while(r > l && !IsAlpha(res[r])){
                -- r;
            }
            char temp = res[l];
            res[l] = res[r];
            res[r] = temp;
            ++ l;
            -- r;
        }
        return new string(res);
    }

    public bool IsAlpha(char ch){
        return ch - 'a' < 26 && ch - 'a' >= 0 || ch - 'A' < 26 && ch - 'A' >= 0;
    }
}