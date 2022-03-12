public class Solution {
    public long SubArrayRanges(int[] nums) {
        // 范围和应为所有最大值的和 - 所有最小值的和
        // 使用单调栈
        // key : 以nums[i]为最小值的区间[j+1, k-1]，其中有(i - j) * (k - i)个以nums[i] 为最小值的子数组
        //       所以使用leftMin[i] 记录以num[i]为最小值的左侧区间下标, rightMin[i]记录右侧
        //       使用单调栈记录当前扫描范围内的最小值下标，每次扫描更新单调栈，并将当前下标入栈。
        //       最大值也同理，使用两次扫描，从前到后、从后到前，分别更新left和right数组
        int length = nums.Length;
        int[] minLeft = new int[length];
        int[] minRight = new int[length];
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];
        Stack<int> minStack = new Stack<int>();
        Stack<int> maxStack = new Stack<int>();

        for(int i = 0; i < length; ++ i){
            while(minStack.Count > 0 && nums[minStack.Peek()] > nums[i]){
                minStack.Pop();
            }
            minLeft[i] = minStack.Count > 0 ? minStack.Peek() : -1;
            minStack.Push(i);

            while(maxStack.Count > 0 && nums[maxStack.Peek()] <= nums[i]){
                maxStack.Pop();
            }
            maxLeft[i] = maxStack.Count > 0 ? maxStack.Peek() : -1;
            maxStack.Push(i);
        }
        minStack.Clear();
        maxStack.Clear();
        for(int i = length - 1; i >= 0; -- i){
            while(minStack.Count > 0 && nums[minStack.Peek()] >= nums[i]){
                minStack.Pop();
            }
            minRight[i] = minStack.Count > 0 ? minStack.Peek() : length;
            minStack.Push(i);

            while(maxStack.Count > 0 && nums[maxStack.Peek()] < nums[i]){
                maxStack.Pop();
            }
            maxRight[i] = maxStack.Count > 0 ? maxStack.Peek() : length;
            maxStack.Push(i);
        }
        long sumMax = 0, sumMin = 0;
        for(int i = 0; i < length; ++ i){
            sumMax += (long) (i - maxLeft[i]) * (maxRight[i] - i) * nums[i];
            sumMin += (long) (i - minLeft[i]) * (minRight[i] - i) * nums[i];
        }
        return sumMax - sumMin;
    }
}