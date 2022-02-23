public class Solution {
    public int MaxProfit(int[] prices) {
        // profit = price[j] - price[i]
        // 维护一个起始的最低值
        int min = int.MaxValue, profit = 0;
        for(int i = 0; i < prices.Length; ++ i){
            if(min > prices[i]){
                // 遇到更小值
                min = prices[i];
            } else if(prices[i] - min > profit){
                profit = prices[i] - min;
            }
        }
        return profit;
    }
}