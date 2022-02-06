package codes.DayDayUp.codes.fib509tribonacci1137;


public class Solution {
	
	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	private int getFib(int n) {
		int p=0,q=1,r=0;
		if(n<2){
			return n;
		}
		else {
			for(int i=2;i<=n;i++){
				r=p+q;
				p=q;
				q=r;
			}
			return r;
		}
		
	}
	
	private int getTribonacci(int n) {
			switch (n){
	        case 0:
	        return 0;
	        case 1:
	        return 1;
	        case 2:
	        return 1;

	        default:
	        int p=0,q=1,r=1,s=0;
	        for(int i=3;i<=n;i++){
	            s = p + q + r;
	            p=q;
	            q=r;
	            r=s;
	        }
	        return s;
	    }
		
	}
	

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getTribonacci(5));
}
}
