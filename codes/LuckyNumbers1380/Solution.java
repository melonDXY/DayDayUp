package codes.LuckyNumbers1380;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public List<Integer> luckyNumbers(int[][] matrix) {
		int row_num = matrix.length;
		int col_num = matrix[0].length;
		int[] rows = new int[row_num];
		int[] cols = new int[col_num];
		Arrays.fill(rows, Integer.MAX_VALUE);
		
		//得到矩阵中每行最小值，每列最大值
		for(int i=0;i<row_num;i++){
			for(int j=0;j<col_num;j++){
				rows[i] = Math.min(rows[i], matrix[i][j]); //用单维数组控制行列
				cols[j] = Math.max(cols[j], matrix[i][j]);
			}
		}
		
		List<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < row_num; i++){
			for(int j = 0; j < col_num; j++){
				if(matrix[i][j] == rows[i] && matrix[i][j] == cols[j]){
					ans.add(matrix[i][j]);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
