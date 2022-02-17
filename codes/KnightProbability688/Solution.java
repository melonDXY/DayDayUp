package codes.KnightProbability688;

public class Solution {
    private static final int[][] dirs = {{-2,-1}, {-1, -2}, {1,-2}, {2,-1}, {2,1}, {1,2}, {-1,2}, {-2,1}};
    //记忆递归搜索
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] pMemo = new double[k+1][n][n];
        return dfs(n, k, row, column, pMemo);
    }

    public double dfs(int n, int k, int row, int column, double[][][] pMemo){
        if(row < 0 || column < 0 || row >= n || column >= n){
            return 0;
        }
        if(k == 0){
            return 1;
        }

        //在同一步中有探索过的概率不重复计算 WHQASKLSTTDWZJNL
        if( pMemo[k][row][column] != 0){
            return pMemo[k][row][column];
        }

        //没有则计算
        double ans = 0;
        for(int[] dir : dirs){
            ans += dfs(n, k-1, row + dir[0], column+dir[1], pMemo)/8;//要除8（独立事件概率）
        }
        pMemo[k][row][column] = ans;//存储当前步骤概率
        return ans;
    }


    //动态规划，算了n*n个格子的0-k步的概率，返回第i，j个格子k的概率。
    public double knightProbabilityDG(int n, int k, int row, int column){
        double[][][] dfs = new double[k+1][n][n];

        for(int step = 0; step <= k; step++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(step ==0){
                        dfs[step][i][j] = 1;
                        continue;
                    }

                    for(int[] dir : dirs){
                        int x = i+dir[0];
                        int y = j+dir[1];
                        if(x < 0 || y < 0 || x >= n || y >= n){
                            continue;
                        }
                        dfs[step][i][j] += dfs[step-1][x][y]/8;//要除8（独立事件概率）
                    }
                }
            }
        }

        return dfs[k][row][column];
    }
}
