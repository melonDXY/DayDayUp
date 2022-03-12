public class Solution {
    public string NearestPalindromic(string n) {
        // 获得数字
        long num = long.Parse(n), ans = -1, difference = long.MaxValue;
        // 获取候选
        IList<long> candidates = GetCandidates(n);
        foreach(long candidate in candidates){
            long curDifference = Math.Abs(candidate - num);
            if(curDifference != 0){
                if(ans == -1 || curDifference < difference || curDifference == difference && candidate < ans){
                    ans = candidate;
                    difference = Math.Min(difference, curDifference);
                }
            }
        }
        return ans.ToString();

    }

    public IList<long> GetCandidates(string n){
        int length = n.Length;
        IList<long> candidates = new List<long>();
        // 添加最大最小两个边界的回文数
        candidates.Add((long)Math.Pow(10, length - 1) - 1);
        candidates.Add((long)Math.Pow(10, length) + 1);
        // 找到前半段(奇数则包括中间值，偶数则为前半段)
        long preNums = long.Parse(n.Substring(0, (length + 1) / 2));
        // 添加 前半段 + reversed前半段，以及 前半段 - 1 + reversed（前半段 - 1）
        for(long pre = preNums - 1; pre <= preNums + 1; ++ pre){
            StringBuilder sb = new StringBuilder();
            string preString = pre.ToString();
            sb.Append(preString);
            // string sufString = preString.Substring(0, sufL);
            // char[] sufChars = sufString.ToCharArray();
            // Array.Reverse(sufChars);
            // sb.Append(new string(sufChars));
            StringBuilder sufB = new StringBuilder();
            for(int j = preString.Length - 1 - (length & 1); j >= 0; -- j){
                sufB.Append(preString[j]);
            }
            sb.Append(sufB);
            string candidate = sb.ToString();
            candidates.Add(long.Parse(candidate));
        }
        return candidates;
    }
}