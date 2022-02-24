public class Solution {
    public int[] FindBall(int[][] grid) {
        // 模拟
        int balls = grid[0].Length;
        int[] ans = new int[balls];
        // 初始化球的位置
        for(int i = 0; i < balls; ++ i){
            ans[i] = i;
        }
        // 每层更新ans
        for(int row = 0; row < grid.Length; ++ row){
            // 更新该层球状态
            for(int ballNum = 0; ballNum < balls; ++ ballNum){
                // ans[ballNum] != -1 ,即若球未被卡住，那么球未更新时位置应为： (row - 1, ans[ballNum])
                // ans[ballNum] == -1 ,即球被卡住，那么跳过
                if(ans[ballNum] != -1){
                    // 球所走的格子位置应为 (row, ans[ballNum])
                    // 需要权衡的状态是 dir[row, ans[ballNum] + dir[row, ans[ballNum]]] 和 dir[row, ans[ballNum]]是否相等
                    int col = ans[ballNum];
                    int nextCol = ans[ballNum] + grid[row][col];
                    if( nextCol >= balls || nextCol < 0 || grid[row][nextCol] != grid[row][col]){
                        ans[ballNum] = -1;
                    } else {
                        ans[ballNum] = nextCol; 
                    }
                }
            }
        }
        return ans;
    }
}