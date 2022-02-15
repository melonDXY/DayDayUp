public class Solution {
    public static int[][] dirs = {new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1}};
    public int NumEnclaves(int[][] grid) {
        // 从边上开始找，用广度优先搜索的方法，将可达1改为0，再遍历
        int m = grid.Length, n = grid[0].Length;
        // 队列保存1的位置
        Queue<Tuple<int, int>> pos = new Queue<Tuple<int, int>>();
        // 遍历矩阵，找到边上1的位置
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                    if(grid[i][j] == 1){
                        pos.Enqueue(new Tuple<int, int>(i, j));
                    }
                } else {
                    continue;
                }
            }
        }
        // 遍历队列
        while(pos.Count > 0){
            Tuple<int, int> curPos = pos.Dequeue();
            if(grid[curPos.Item1][curPos.Item2] == 0){
                continue;
            } else {
                grid[curPos.Item1][curPos.Item2] = 0;
                // 入队它周围的1
                foreach(int[] curDir in dirs){
                    if(curPos.Item1 + curDir[0] >= 0 && curPos.Item1 + curDir[0] < m && curPos.Item2 + curDir[1] >= 0 && curPos.Item2 + curDir[1] < n){
                        pos.Enqueue(new Tuple<int, int>(curPos.Item1 + curDir[0], curPos.Item2 + curDir[1]));
                    }
                }
            }
        }

        // 计数飞地
        int count = 0;
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                if(grid[i][j] == 1){
                    ++ count;
                }
            }
        }
        return count;
    }
}