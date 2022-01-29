public class Solution {
    //根据题目提示，n<= 37, 故创造38长度数组进行记录，递推地求解 返回arr[n]
    // 边界即：arr[0] = 0
    // 有时间损耗，其实使用三个变量，递推到n即可输出，可以进一步减少空间和时间的损耗
    public int Tribonacci(int n) {
        int[] arrs = new int[38];
        arrs[0] = 0;
        arrs[1] = 1;
        arrs[2] = 1;
        for(int i = 3; i < 38; ++ i){
            arrs[i] = arrs[i - 3] + arrs[i - 2] + arrs[i - 1];
        }
        return arrs[n];
    }
}