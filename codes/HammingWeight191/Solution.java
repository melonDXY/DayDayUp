package codes.HammingWeight191;

public class Solution {
    //计算二进制位1的个数
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n-1);
            ans++;
        }
        return ans;
    }
}
