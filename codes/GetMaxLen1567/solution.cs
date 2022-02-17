public class Solution {
    public int GetMaxLen(int[] nums) {
        // 原理同上一题,区分正负号, 但是很容易很容易踩坑
        int negativeL = nums[0] < 0 ? 1 : 0;
        int positiveL = nums[0] > 0 ? 1 : 0;
        int ans = positiveL;
        for(int i = 1; i < nums.Length; ++ i){
            if(nums[i] > 0){
                ++ positiveL;
                negativeL = negativeL > 0 ? negativeL + 1 : 0;
            } else if(nums[i] < 0){
                int temp = positiveL;
                positiveL = negativeL > 0 ? negativeL + 1 : 0;
                negativeL = temp + 1;
            } else {
                //遇到0
                positiveL = 0;
                negativeL = 0;
            }
            ans = Math.Max(ans, positiveL);
        }
        return ans;
    }
}