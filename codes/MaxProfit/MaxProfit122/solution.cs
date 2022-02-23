public class Solution {
    public int MaxProfit(int[] prices) {
        // 和121类似，但是这次需要计算所有递增子序列的首尾差之和
        int curMin = int.MaxValue;
        int ans = 0;
        for(int i = 0; i < prices.Length; ++ i){
            if(prices[i] < curMin){
                curMin = prices[i];
            } else if(prices[i] > curMin){
                ans += prices[i] - curMin;
                curMin = prices[i];
            }
        }
        return ans;
    }
}