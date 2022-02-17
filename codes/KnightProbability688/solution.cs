public class Solution {
    // 记录方向
    static int[][] dirs = {new int[]{-2, -1}, new int[]{-2, 1}, new int[]{-1, 2}, new int[]{1, 2}, new int[]{2, 1}, new int[]{2, -1}, new int[]{1, -2}, new int[]{-1, -2}};
    public double KnightProbability(int n, int k, int row, int column) {
        // 使用动规解题 dp[k][i][j]从（i，j）出发的第k步，骑士仍在棋盘内的概率
        double[,,] dp = new double[k + 1,n,n];
        for(int step = 0; step <= k; ++ step){
            for(int i = 0; i < n; ++ i){
                for(int j = 0; j < n; ++ j){
                    if(step == 0){
                        dp[step, i, j] = 1;
                    } else {
                        foreach(int[] dir in dirs){
                            int next_i = i + dir[0], next_j = j + dir[1];
                            if(next_i >= 0 && next_i < n && next_j >= 0 && next_j < n){
                                // 从i,j出发a步后在棋盘的概率 = 从ni,nj（一步后可达i,j）出发使用a-1步后仍在棋盘概率的和的八分之一
                                dp[step, i, j] += dp[step - 1, next_i, next_j] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k, row, column];
    }
}