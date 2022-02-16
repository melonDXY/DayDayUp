public class Solution {
    public int MaxSubArray(int[] nums) {
        // f(n) = max(f(n-1) + nums[n], nums[n])
        int pre = 0, ans = nums[0];
        foreach(int num in nums){
            // 先更新dp数组，再用数组的值更新答案
            pre = Math.Max(pre + num, num);
            ans = Math.Max(pre, ans);
        }
        return ans;
    }
}