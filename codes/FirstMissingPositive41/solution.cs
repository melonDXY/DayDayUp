public class Solution {
    public int FirstMissingPositive(int[] nums) {
        int length = nums.Length;
        for(int i = 0; i < length; ++ i){
            if(nums[i] <= 0){
                nums[i] = length + 1;
            }
        }
        for(int i = 0; i < length; ++ i){
            int num = Math.Abs(nums[i]);
            if(num <= length){
                nums[num - 1] = -Math.Abs(nums[num - 1]);
            }
        }
        for(int i = 0; i < length; ++ i){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return length + 1;
    }
}