public class Solution {
    public int Search(int[] nums, int target) {
        int length = nums.Length;
        if(length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target == nums[mid]) return mid;
            if(nums[mid] >= nums[0]){
                if(target < nums[mid] && target >= nums[0]){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[length - 1]){
                    l =  mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}