package codes.CountPrimeSetBits762;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < 21; i++) {
            Boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) primeList.add(i);
            isPrime = true;
        }
        
        for (int i = left ; i<=right; i++) {
            int count = Integer.bitCount(i);
            
            int tmp = i;
            while ( tmp != 0) {
                tmp = tmp & (tmp - 1);
                count++;
            }
            if (primeList.contains(count)) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Double double1=Math.pow(10, 6);
        System.out.println(Integer.toBinaryString(double1.intValue()));
    }
}
