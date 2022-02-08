package codes.DayDayUp.codes.countKDifference2006;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	//给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
	//1 <= nums.length <= 200;1 <= nums[i] <= 100;1 <= k <= 99;
	//将绝对值问题转为距离问题，考虑最大距离为99，且数的最大值为100；适用桶的方法（简单哈希存储+坐标轴），符合条件的对数按照排列组合的思想计算
	public int countKDifference(int[] nums, int k){
		int ans = 0;
		int[] butt= new int[101];//整型数组默认为0；
		for(int i : nums){
			butt[i] += 1;
		}
		
		for(int j=1;j+k<101;j++){
			ans += butt[j] * butt[j+k];
		}
		
		return ans;
	}
	
	//使用哈希表减少内存损耗（并没有减少）
	public int countKDifferenceHash(int[] nums, int k){
		int ans = 0;
		Map<Integer, Integer> butt = new HashMap<Integer,Integer>();
		for(int i : nums){
			butt.put(i, butt.getOrDefault(i, 0)+1);
		}
		
		for(int j=1;j+k<101;j++){
			if(butt.get(j) == null || butt.get(j+k)==null){
				continue;
			}
			ans += butt.get(j) * butt.get(j+k);
		}
		
		return ans;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,1};
		int k = 1;
		Solution solution = new Solution();
		System.out.println(solution.countKDifference(nums, k));
	}

}
