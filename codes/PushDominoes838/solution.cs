public class Solution {
    public string PushDominoes(string dominoes) {
        // 模拟推牌过程
        char[] res = dominoes.ToCharArray();
        int length = dominoes.Length;
        int i = 0;
        // 将初始左状态设置为L
        char leftState = 'L';
        while(i < length){
            int j = i;
            // 1. 寻找连续不倒的区间
            while(j < length && res[j] == '.'){
                ++ j;
            }
            // 2. 判断右状态: (1) 如果超出长度则设为R (2)未超出则读取此状态
            char rightState = j < length ? res[j] : 'R';
            // 3. 根据左右状态更新区间内状态
            //   (1)左右状态相同，则区间内状态也相同
            //   (2)为RL，则向中间倒
            //   (3)为LR，则中间不倒
            if(leftState == rightState){
                while(i < j){
                    res[i ++ ] = leftState;
                }
            } else if(leftState == 'R' && rightState == 'L'){
                int k = j - 1;
                while(i < k){
                    res[k --] = rightState;
                    res[i ++] = leftState;
                }
            }
            leftState = rightState;
            i = j + 1;
        }
        return new string(res);
    }
}