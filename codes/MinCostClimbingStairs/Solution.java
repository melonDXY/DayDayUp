package codes.MinCostClimbingStairs;

public class Solution {
    
    public int minCostClimbingStairs(int[] cost) {

        int costMin_i0 = 0;//i-1前阶花费
        int costMin_i1 = Math.min(cost[0], cost[1]);//i阶花费
        int minCost = costMin_i1;
        for(int i = 2; i<cost.length; i++){
            //i-1阶前最小花费加上i-1阶花费 or i 阶前花费加上i阶花费
            minCost = Math.min(cost[i]+costMin_i1, cost[i-1]+costMin_i0);
            costMin_i0 = costMin_i1;
            costMin_i1 = minCost;
        }
        return minCost;
        
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
