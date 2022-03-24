class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        // 限定起始和结束，初始化
        int rangeMax = n * n;
        int curNum = 1;
        vector<vector<int>> matirx(n, vector<int>(n));
        int row = 0, col = 0;
        vector<vector<int>> dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};// 分别向右、下、左、上四个方向走
        int dirOrder = 0;
        while(curNum <= rangeMax){
            matirx[row][col] = curNum;
            ++ curNum;
            int nextRow = row + dirs[dirOrder][0], nextCol = col + dirs[dirOrder][1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matirx[nextRow][nextCol] > 0){
                dirOrder = (dirOrder + 1) % 4;
            }
            row = row + dirs[dirOrder][0];
            col = col + dirs[dirOrder][1];
        }
        return matirx;
    }
};