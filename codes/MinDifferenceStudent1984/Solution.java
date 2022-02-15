package codes.DayDayUp.codes.MinDifferenceStudent1984;

import java.util.Arrays;

public class Solution {

    //排序后以k为滑动窗口找出最小差值
    public int minimumDifference(int[] nums, int k) {
        int ans = 100000;
        Arrays.sort(nums);
        if(k == 1){
            ans = 0;
        }
        for(int i=0;i<=nums.length-k;i++){
            int temp = nums[nums.length-i-1]-nums[nums.length-i-k];
            if(temp < ans){
                ans = temp;
            }
        }

        return ans; 
    }
    public static void main(String[] args) {
        
    }
    
}
