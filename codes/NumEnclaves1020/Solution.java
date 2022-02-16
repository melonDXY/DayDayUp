package codes.NumEnclaves1020;

public class Solution {
	private static int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	private int rows;
	private int cols;
	private boolean[][] visited;
	
	
	public int numEnclaves(int[][] grid) {
		rows = grid.length;
		cols = grid[0].length;
		visited = new boolean[rows][cols];
		
		for(int i = 0; i<rows; i++){
			dfs(grid, i, 0);
			dfs(grid, i, cols - 1);
		}
		for(int j = 1; j<cols-1; j++){
			dfs(grid, 0, j);
			dfs(grid, rows-1, j);
		}
		int ans = 0;
		
		for(int m = 1; m<rows-1; m++){
			for(int n = 1; n < cols-1; n++){
				if(grid[m][n] == 1 && !visited[m][n]){
					ans++;
				}
			}
		}
		
		return ans;
	}
	
	public void dfs(int[][] grid, int row,int col) {
		if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0 || visited[row][col]){
			return;
		}
		visited[row][col] = true;
		for(int[] dir : dirs){
			dfs(grid, row + dir[0], col + dir[1]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
