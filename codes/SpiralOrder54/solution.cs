public class Solution {
    public IList<int> SpiralOrder(int[][] matrix) {
        List<int> res = new List<int>();
        int r1 = 0, r2 = matrix.Length - 1;
        if(r2==-1) return res;
            int c1 = 0, c2 = matrix[0].Length - 1;
            while(r1<=r2 && c1<=c2)
            {
                for (int i = c1; i <= c2; i++) res.Add(matrix[r1][i]);
                for (int i = r1 + 1; i <=r2; i++) res.Add(matrix[i][c2]);
                if(r1<r2 && c1<c2)
                {
                    for (int i = c2 - 1; i>= c1; i--) res.Add(matrix[r2][i]);
                    for (int i = r2 - 1; i > r1; i--) res.Add(matrix[i][c1]);
                }
                r1++;
                r2--;
                c1++;
                c2--;
            }
            return res;
    }
}