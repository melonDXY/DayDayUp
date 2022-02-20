package codes.IsOneBitCharacter717;

public class Solution {
    //按位判断是否是0，注意首位和倒数第二位的情况
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        boolean flag = false;
        for(int i = 0; i < n; i++){
            if(bits[i] == 0){
                flag = true;
                if(i+2 > n){
                    break;
                }
                continue;
            }
            else if(i + 2 == n){
                flag = false;
                break;
            }
            
            else{
                flag = false;
                i++;
            }
        }
        return flag;
    }
}
