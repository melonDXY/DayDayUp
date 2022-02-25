package codes.FindBall1706;

public class Solution {
    private int m;
    private int n;
    private int[][] g;

    public int getNext(int x){
        int row = 0;
        int col = x;

        while (row < this.m){
            int next = x + g[row][col];
            if(next < 0 || next >= n){
                return -1;
            }else if(g[row][col] != g[row][next]){
                return -1;
            }
            row++;
            col = next;
        }
        return col;

    }
    public int[] findBall(int[][] grid){
        this.n = grid[0].length;
        this.m = grid.length;
        this.g = grid;
        int[] ans = new int[this.n];
        for(int i = 0; i < n; i++){
            ans[i] = getNext(i);
        }
        return ans;
    }

}