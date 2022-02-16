package codes.ClimbingStairs70;

public class Solution {
	
	//爬楼梯方法
	//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	
	//重点：方法数通过数学公式得出：到n阶的方法数是，n-1阶与n-2阶的方法数之和，进而转成求斐波那契数列，（初始值不同）

	public int climbStairs(int n) {
		//int count=0;
		if(n==1){
			return 1;
		}
		else if (n==2) {
			return 2;
		}
		else {
			int p=1,q=2,r=0;
			for(int i=3;i<=n;i++){
				r=p+q;
				p=q;
				q=r;
			}
			
			return r;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
