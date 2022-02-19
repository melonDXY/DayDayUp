public class Solution {
    public int MaxProfit(int[] prices) {
        // 维护一个dp数组，为到第n天最大盈利
        // 设置三个状态：
        // 0: 持有一支股票，累计收益f[day][0] = max(f[day - 1][2] - price[day], f[day - 1][0])
        // 1: 不持有股票，处于冷冻期，累计收益f[day][1] = f[day - 1][0] + price[day]
        // 2: 不持有股票，不处于冷冻期，累计收益f[day][2] = max(f[day - 1][2], f[day - 1][1])
        // 所以n天后的最终收益应该是 max(f[n][1], f[n][2]) ==> 最后一天持有股票没有意义
        if(prices.Length == 0){
            return 0;
        }
        int n = prices.Length;
        int profit0 = 0 - prices[0],profit1 = 0,profit2 = 0;
        for(int day = 1; day < n; ++ day){
            int newProfit0 = Math.Max(profit2 - prices[day], profit0);
            int newProfit1 = profit0 + prices[day];
            int newProfit2 = Math.Max(profit1, profit2);
            profit0 = newProfit0;
            profit1 = newProfit1;
            profit2 = newProfit2;
        }
        return Math.Max(profit1, profit2);
    }
}