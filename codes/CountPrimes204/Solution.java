package codes.CountPrimes204;

import java.util.Arrays;

public class Solution {

    //小于n的质数个数
    public int countPrimes(int n) {
        int ans = 0;
        int[] primes = new int[n];
        Arrays.fill(primes, 1);

        for (int i = 2; i < n; i++){
            if (primes[i] == 1) {
                ans++;
            }
            if ((long)i*i < n){
                for(int j = i*i; j<n; j+=i) {
                    primes[j] = 0;
                }
            }
            
        }
        return ans;

    }
}
