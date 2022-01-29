public class Solution {
    //定义广搜的方向
    int[][] direction = {new int[]{-1,0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};

    public int[][] HighestPeak(int[][] isWater) {
        // 获取矩阵信息，用于边界判断
        int m = isWater.Length, n = isWater[0].Length;
        int[][] ans = new int[m][];
        // 初始化答案矩阵,以-1作为未访问的标记
        for(int i = 0; i < m; ++ i){
            ans[i] = new int[n];
            Array.Fill(ans[i], -1);
        }

        // 队列存储待处理的水域点
        Queue<Tuple<int, int>> queue = new Queue<Tuple<int, int>>();
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                if(isWater[i][j] == 1){
                    ans[i][j] = 0;
                    queue.Enqueue(new Tuple<int, int>(i, j));
                }
            }
        }

        //以水域点为bfs搜索的起点
        while(queue.Count > 0){
            Tuple<int, int> pos = queue.Dequeue();
            foreach(int[] nextDir in direction){
                //获取下一个点
                int x = pos.Item1 + nextDir[0], y = pos.Item2 + nextDir[1];
                // 边界判断
                if(x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1){
                    ans[x][y] = ans[pos.Item1][pos.Item2] + 1;
                    queue.Enqueue(new Tuple<int, int>(x, y));
                }
            }
        }

        return ans;
    }
}