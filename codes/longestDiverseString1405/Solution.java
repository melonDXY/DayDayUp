package codes.longestDiverseString1405;

import java.util.Arrays;

public class Solution {
	class Pair{
		int freq;
		char sym;
		
		public Pair(char sym, int freq) {
			// TODO Auto-generated constructor stub
			this.freq = freq;
			this.sym = sym;
		}
	}
	
	public String longestDiverseString(int a, int b, int c) {
		StringBuilder ans = new StringBuilder();
		Pair[] arr = {new Pair('a', a), new Pair('b', b), new Pair('c', c)};
		
		while(true){
			//java lambda 公式 (p1,p2) -> p2.freq - p1.freq) 替代Compare接口实现 将数组按照pair.freq降序排列 
			//-p1.freq "-"指降序排列
			Arrays.sort(arr, (p1,p2) -> p2.freq - p1.freq);
			boolean hasNext = false;
			
			//里循环：按照当前剩余数量最多的字母依次判断是否符合条件并填入字符串
			for(Pair pair : arr){
				if(pair.freq <= 0){
					break;
				}
				int length = ans.length();
				if(length >= 2 && ans.charAt(length-2) == pair.sym && ans.charAt(length-1) == pair.sym){
					continue;
				}
				ans.append(pair.sym);
				pair.freq--;
				hasNext = true;
				break;
			}
			if(!hasNext){
				break;
			}
		}
		
		return ans.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
