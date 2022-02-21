package codes.PushDominoes838;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    //有点难，利用队列存储正在运动的牌的状态，加一个时间数组同步时间
    public String pushDominoes(String dominoes) {
        char[] arrCards = dominoes.toCharArray();
        int cardsNums = arrCards.length;
        Deque<int[]> statusQueue = new ArrayDeque<>(); 
        int[] forceStatus = new int[cardsNums];
        //初始化骨牌状态
        for(int i = 0; i < cardsNums; i++){
            if(arrCards[i] == '.'){
                continue;
            }
            else{
                int dir = arrCards[i] == 'L' ? -1 : 1;
                statusQueue.add(new int[]{i, 1, dir});
                forceStatus[i] = 1;
            }
        }
        while(!statusQueue.isEmpty()){
            int[] item = statusQueue.pollFirst();
            int loc = item[0];
            int time = item[1];
            int direct= item[2];
            int forceIndex = loc + direct;
            //不需要推到，或越界跳过
            if(arrCards[loc] == '.' || forceIndex < 0 || forceIndex >= cardsNums){
                continue;
            }

            //首次受力一定为'.'，即一直是树立状态
            if(forceStatus[forceIndex] == 0){
                statusQueue.addLast(new int[]{forceIndex, time + 1, direct});
                forceStatus[forceIndex] = time + 1;
                arrCards[forceIndex] = direct==-1 ? 'L': 'R';
            }
            //多次受力，只可能是在同一时间受不同的力，所以状态更新为time+1，上个力已经将时间+1，同步时间需要+1
            else if(forceStatus[forceIndex] == time + 1){
                arrCards[forceIndex] = '.';
            }
            
        }
        return String.valueOf(arrCards);
    }
}
