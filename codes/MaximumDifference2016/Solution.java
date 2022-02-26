package codes.MaximumDifference2016;

public class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int numsLen = nums.length;
        int min = nums[0];
        for(int i = 0; i < numsLen; i++){
            if(nums[i]>min){
                ans = Math.max(ans, nums[i] - min);
            }
            min = Math.min(nums[i], min);
        }

        return ans;
    }
}
