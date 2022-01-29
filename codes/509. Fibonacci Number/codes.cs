public class Solution {
    // 递归解决
    public int Fib(int n) {
        if(n == 0){
            return 0;
        } else if (n == 1){
            return 1;
        }
        return Fib(n - 1) + Fib(n - 2);
    }
}