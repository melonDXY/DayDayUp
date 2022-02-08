public class Solution {
    public int DeleteAndEarn(int[] nums) {
        // 打家劫舍变形
        // 计数再进行解决
        int MaxVal = 0;
        foreach(int val in nums){
            MaxVal = Math.Max(MaxVal, val);
        }
        int[] neighbors = new int[MaxVal + 1];
        foreach(int val in nums){
            ++ neighbors[val];
        }
        return Rob(neighbors);
    }

    public int Rob(int[] nums){
        int pre1 = 0, pre2 = 0;
        int ans = 0;
        for(int i = 0; i < nums.Length; ++ i){
            ans = Math.Max(pre1, pre2 + nums[i] * i);
            pre2 = pre1;
            pre1 = ans;
        }
        return ans;
    }
}