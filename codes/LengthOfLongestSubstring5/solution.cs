public class Solution {
    public int LengthOfLongestSubstring(string s) {
        Dictionary<char, int> keyIndex = new Dictionary<char, int>();
        int startPos = 0, ans = 0;
        int length = s.Length;
        if(length == 0 || length == 1){
            return length;
        }
        keyIndex.Add(s[0], 0);
        for(int i = 1; i < length; ++ i){
            if(keyIndex.ContainsKey(s[i])){
                if(startPos > keyIndex[s[i]]){
                    keyIndex[s[i]] = i;
                } else {
                    ans = Math.Max(ans, i - startPos);
                    startPos = keyIndex[s[i]] + 1;
                    keyIndex[s[i]] = i;
                }
            } else {
                keyIndex.Add(s[i], i);
            }
        }
        ans = Math.Max(ans, length - startPos);

        return ans;
    }
}