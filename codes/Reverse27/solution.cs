public class Solution {
    public int Reverse(int x) {
        int reversedValue = 0;
        while(x != 0){
            if(reversedValue < int.MinValue / 10 || reversedValue > int.MaxValue / 10){
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            reversedValue = reversedValue * 10 + digit;
        }
        return reversedValue;
    }
}