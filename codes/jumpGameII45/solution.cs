public class Solution {
    public int Jump(int[] nums) {
        // 假如从0开始起跳，那么在0可达到范围内再起跳都是第二次跳跃

        int l = nums.Length;
        if(l == 1){
            return 0;
        } else if(nums[0] >= l - 1){
            return 1;
        }
        int end = nums[0];
        int curRange = nums[0];
        int count = 0, i = 0;
        while(i < l){
            ++ count;
            end = curRange;
            if(end >= l - 1){
                return count;
            }
            while(i <= end){
                curRange = Math.Max(curRange, nums[i] + i);
                ++ i;
            }
        }
        return count;
    }
}
