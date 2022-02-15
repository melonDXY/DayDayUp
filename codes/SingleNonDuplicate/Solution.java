package codes.DayDayUp.codes.SingleNonDuplicate;

public class Solution {
	
	//单独数字只可能在i+2的位置
	public int singleNonDuplicate(int[] nums) {
        boolean ans = true;
        for(int i=0; i+1<nums.length; i = i+2){
            if(nums[i] != nums[i+1]){
                ans = false;
                return nums[i];
            }
        }
        if (ans){
            return nums[nums.length-1];//单独的数字在最后一位
        }
        else{
            return -1;//只有两种情况
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
