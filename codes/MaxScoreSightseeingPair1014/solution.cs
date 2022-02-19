public class Solution {
    public int MaxScoreSightseeingPair(int[] values) {
        // 由于a到b等于b到a，所以每次只需要往后搜索一对景点即可
        // 对每个位置都更新一次ans
        // 不过只这样就会超时
        // 对于公式 values[start] + values[end] + start - end，拆成values[start] + start 和 values[end]  - end两个部分
        // 这样的话，一次遍历即可将两部分最大值找出
        int startMax = values[0], ans = 0;
        for(int i = 1; i < values.Length; ++ i){
            ans = Math.Max(startMax + values[i] - i, ans);
            startMax = Math.Max(startMax, values[i] + i);
        }
        return ans;
    }
}