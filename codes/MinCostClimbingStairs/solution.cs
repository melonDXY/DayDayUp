public class Solution {
    public int MinCostClimbingStairs(int[] cost) {
        int l = cost.Length;
        int cur = 0;
        int pre1 = 0, pre2 = 0;
        for(int i = 2; i <= l; ++ i){
            cur = Math.Min(pre1 + cost[i - 1], pre2 + cost[i - 2]);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }
}