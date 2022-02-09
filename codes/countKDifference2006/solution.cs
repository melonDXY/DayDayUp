public class Solution {
    public int CountKDifference(int[] nums, int k) {
        int res = 0, n = nums.Length;
        Dictionary<int, int> count = new Dictionary<int, int>();
        foreach(int num in nums){
            // 对每个新进的num都进行一次计算，以此替代乘法，并达成只遍历一次的目的
            res += (count.ContainsKey(num + k) ? count[num + k] : 0) + (count.ContainsKey(num - k) ? count[num - k] : 0);
            if(!count.ContainsKey(num)){
                count.Add(num, 0);
            }
            ++ count[num];
            
        }
        return res;
    }
}