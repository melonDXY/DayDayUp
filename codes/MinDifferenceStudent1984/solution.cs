public class Solution {
    public int MinimumDifference(int[] nums, int k) {
        // 排序 + 滑动窗口
        int length = nums.Length;
        Array.Sort(nums);
        int ans = int.MaxValue;
        for(int i = 0; i + k - 1 < length; ++ i){
            ans = Math.Min(ans, nums[i + k - 1] - nums[i]);            
        }
        return ans;
    }
}