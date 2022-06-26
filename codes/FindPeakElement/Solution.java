package codes.FindPeakElement;

public class Solution {
    public int findPeek(int[] nums ,int left, int right){
        if (left > right) return -1;
        int mid = (left + right)/2;
        if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
            return mid;
        } 
        int result = findPeek(nums, left, mid - 1);
        if (result != -1){
            return result;
        }else{
            return findPeek(nums, mid + 1, right);
        }
        
        
    }
    public int findPeakElement (int[] nums) {
        // write code here
        int numsLength = nums.length;
        if(numsLength == 1){
            return 0;
        }
        if(nums[0] > nums[1]) return 0;
        if(nums[numsLength - 1] > nums[numsLength - 2]) return numsLength - 1;
        return findPeek(nums, 0, numsLength - 1);

    }
}
