public class Solution {
    public int ClimbStairs(int n) {
        // 状态转移方程 f(n) = f(n - 1) + f(n - 2)
        // pre1表示当前台阶的前一阶台阶（即n-1），pre2表示当前台阶的前两阶台阶（即n-2）
        // 由于第一次计算第一阶台阶，所以将pre1、pre2初始化为第0阶和第-1阶
        int pre1 = 1, pre2 = 0;
        // 当前台阶为第一阶，curN表示当前为第几阶梯台阶
        int curN = 1;
        int ans = 0;
        while(curN <= n){
            //使用三个变量，用滚动数组的方式计算f(n)
            ans = pre1 + pre2;
            pre2 = pre1;
            pre1 = ans;
            ++ curN;
        }
        return ans;
    }
}