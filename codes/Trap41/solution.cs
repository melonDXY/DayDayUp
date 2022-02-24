public class Solution {
    public int Trap(int[] height) {
        // 使用双指针实现计算
        // 当左边高度 < 右边高度时，计算左边高度能接下来的雨水，同理 计算右边高度能接下来的雨水
       int drips = 0;
       int left = 0, right = height.Length - 1;
       int leftMax = 0, rightMax = 0;
       while(left < right){
           // 一直更新当前左右两边最高的高度
           leftMax = Math.Max(height[left], leftMax);
           rightMax = Math.Max(height[right], rightMax);
           if(height[left] < height[right]){
               drips += leftMax - height[left];
               ++ left;
           } else {
               drips += rightMax - height[right];
               -- right;
           }
       }
       return drips;
    }
}