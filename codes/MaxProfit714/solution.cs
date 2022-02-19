public class Solution {
    public int MaxProfit(int[] prices, int fee) {
        // 统一卖股票的时候支付fee
        int profit0 = 0 - prices[0];// 持有股票
        int profit1 = 0;// 不持有股票
        for(int day = 1; day < prices.Length; ++ day){
            int newProfit0 = Math.Max(profit0, profit1 - prices[day]);
            int newProfit1 = Math.Max(profit1, profit0 + prices[day] - fee);
            profit0 = newProfit0;
            profit1 = newProfit1;
        }
        return profit1;
    }
}