class NumMatrix {
public:
    vector<vector<int>> ans;
    int m, n;
    NumMatrix(vector<vector<int>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0){
            return ;
        }
        m = matrix.size(), n = matrix[0].size();
        ans = vector<vector<int>>(m, vector<int>(n));
        // 首先初始化第一行和第一列
        ans[0][0] = matrix[0][0];
        for(int j = 1; j < n; ++ j){
            ans[0][j] = matrix[0][j] + ans[0][j - 1];
        }
        for(int i = 1; i < m; ++ i){
            ans[i][0] = matrix[i][0] + ans[i - 1][0];
        }
        for(int i = 1; i < m; ++ i){
            for(int j = 1; j < n; ++ j){
                ans[i][j] = matrix[i][j] + ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1];
            }
        }
    }
    
    int sumRegion(int row1, int col1, int row2, int col2) {
        int minus1 = row1 == 0 ? 0 : ans[row1 - 1][col2];
        int minus2 = col1 == 0 ? 0 : ans[row2][col1 - 1];
        int plus = col1 == 0 || row1 == 0 ? 0 : ans[row1 - 1][col1 - 1];
        return ans[row2][col2] - minus1 - minus2 + plus;
    }
};

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */