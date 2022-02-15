public class Solution {
    public IList<int> LuckyNumbers (int[][] matrix) {
        IList<int> res = new List<int>();
        int m = matrix.Length, n = matrix[0].Length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];
        Array.Fill(minRow, int.MaxValue);

        // 装载
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                minRow[i] = Math.Min(matrix[i][j], minRow[i]);
                maxCol[j] = Math.Max(matrix[i][j], maxCol[j]);
            }
        }
        // 构造答案
        for(int i = 0; i < m; ++ i){
            for(int j = 0; j < n; ++ j){
                if(matrix[i][j] == maxCol[j] && matrix[i][j] == minRow[i]){
                    res.Add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}