package codes.simplifiedFractions1447;

import java.util.List;import java.lang.reflect.GenericDeclaration;
import java.util.ArrayList;

public class Solution {
	
	public List<String> simplifiedFractions(int n) {
		List<String> ans = new ArrayList<String>();//ans 默认为=[]
		
		for(int mom=2;mom <= n; mom++){
			for(int son=1;son < mom; son++){
				if(gcd(son, mom)==1){
					//ans.add(son + "/" + mom);  StringBuilder 拼接字符串更快
					ans.add(new StringBuilder(String.valueOf(son)).append("/").append(mom).toString());
				}
			}
		}
		
		return ans;
	}
	
	public int gcd(int mSon, int mMom) {
		if(mMom % mSon == 0){
			return mSon;
		}
		return gcd(mMom % mSon, mSon);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.simplifiedFractions(10));

	}

}
