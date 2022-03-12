public class Solution {
    public int AddDigits(int num) {
        if(num < 10){
            return num;
        }
        int next = num % 10;
        while(num >= 10){
            num = num / 10;
            next += num % 10;
        }
        return AddDigits(next);
    }
}