public class Solution {
    public long SubArrayRanges(int[] nums) {
        int length = nums.Length;
        long res = 0;
        for(int i = 0; i < length; ++ i){
            int max = int.MinValue, min = int.MaxValue;
            for(int j = i; j >= 0; -- j){
                max = Math.Max(nums[j], max);
                min = Math.Min(nums[j], min);
                res += max - min;
            }
        }
        return res;
    }
}