public class Solution {
    public int SingleNonDuplicate(int[] nums) {
        // 异或操作(但是O(n) 87% 28%)
        //int ans = 0;
        //foreach(int num in nums){
        //    ans ^= num;
        //}
        //return ans;
        
        // 二分, 根据有序的特点，一组一组去查看(但变慢了)
        int l = 0, r = nums.Length - 1;
        while(l < r){
            int mid = (r - l) / 2 + l;//避免溢出
            // 异或运算 免去+ - 号的桎梏
            if(nums[mid] == nums[mid ^ 1]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}