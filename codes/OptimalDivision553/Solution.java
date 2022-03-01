package codes.OptimalDivision553;

public class Solution {
    public String optimalDivision(int[] nums) {
        int numsLen = nums.length;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numsLen - 1; i++){
            ans.append(nums[i]);
            ans.append("/");
        }
        ans.append(nums[numsLen-1]);
        if(numsLen > 2){
            ans.insert(ans.indexOf("/")+1,"(");
            ans.append(")");
        }
        return ans.toString();
    }
}
