package codes.sumOfUnique1748;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	private int[] data = {2,3,1,3,4,5};

	public Solution() {
		// TODO Auto-generated constructor stub
		
	}
	
	private int hashSolution(int[] nums) {
		
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		int ans = 0;
		for(int i : nums){
			counts.put(i, counts.getOrDefault(i, 0) + 1);
		}
		
		for(Map.Entry<Integer, Integer> entry : counts.entrySet()){
			if(entry.getValue() == 1){
				ans += entry.getKey();
			}
		}
//		System.out.println(ans);
		return ans;
	}
	
	//桶排序原理，（最简单的hash）
	private int ButtSoltion(int[] nums) {
		int[] counts = new int[100];//方法只能解决[0-100]的整数
		int ans = 0;
		//入桶
		for(int num : nums){
			counts[num-1]++;
		}
		for(int i=0; i<counts.length; i++){
			if(counts[i] == 1){
				ans = ans + i + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.ButtSoltion(solution.data));
		System.out.println(solution.hashSolution(solution.data));

	}

}
