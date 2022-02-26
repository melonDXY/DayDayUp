public class Solution {
    public int MaximumDifference(int[] nums) {
        int res = -1, preMin = nums[0];
        for(int i = 1; i < nums.Length; ++ i){
            if(nums[i] > preMin){
                res = Math.Max(nums[i] - preMin, res);
            } else {
                preMin = nums[i];
            }
        }
        return res;
    }
}