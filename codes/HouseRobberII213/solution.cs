public class Solution {
    public int Rob(int[] nums) {
        int l = nums.Length;
        if(l == 0){
            return 0;
        } else if(l == 1){
            return nums[0];
        }
        return Math.Max(RobRange(nums, 0, l - 1), RobRange(nums, 1, l));
    }

    public int RobRange(int[] nums, int start, int end){
        int pre1 = 0, pre2 = 0;
        int ans = 0;
        for(int i = start; i < end; ++ i){
            ans = Math.Max(nums[i] + pre2, pre1);
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}