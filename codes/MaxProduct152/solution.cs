public class Solution {
    public int MaxProduct(int[] nums) {
        // 考虑正负性，从max * 负数必定是min的角度出发，维护两个值，一个max，一个min
        // 由于c#没有同时比较三个大小的max函数，故迂回进行处理 ==> 在遇到负数时交换max和min
        int curMax = nums[0], curMin = nums[0], ans = nums[0];
        for(int i = 1; i < nums.Length; ++ i){
            if(nums[i] < 0){
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.Max(nums[i], nums[i] * curMax);
            curMin = Math.Min(nums[i], nums[i] * curMin);
            ans = Math.Max(curMax, ans);
        }
        return ans;
    }
}