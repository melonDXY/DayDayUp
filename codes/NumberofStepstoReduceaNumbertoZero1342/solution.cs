public class Solution {
    // 递归解决
    public int NumberOfSteps(int num) {
        if(num == 0){
            return 0;
        } else if(num == 1){
            return 1;
        }
        return num % 2 == 0 ? 1 + NumberOfSteps(num / 2) : 1 + NumberOfSteps(num - 1);
    }
}