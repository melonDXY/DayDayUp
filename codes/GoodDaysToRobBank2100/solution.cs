public class Solution {
    public IList<int> GoodDaysToRobBank(int[] security, int time) {
        IList<int> res = new List<int>();
        int length = security.Length;
        if(time == 0){
            for(int i = 0; i < security.Length; ++ i){
                res.Add(i);
            }
            return res;
        }
        bool[] preTime = new bool[length];
        bool[] afterTime = new bool[length];
        int cnt = 0;
        for(int i = 0; i < length - 1; ++ i){
            preTime[i] = cnt >= time ? true : false;
            if(security[i + 1] <= security[i])
                ++ cnt;
            else
                cnt = 0;
        }
        preTime[length - 1] = cnt >= time ? true : false;
        cnt = 0;
        for(int i = length - 1; i > 0; -- i){
            afterTime[i] = cnt >= time ? true : false;
            if(security[i] >= security[i - 1]){
                ++ cnt;
            } else {
                cnt = 0;
            }
        }
        afterTime[0] = cnt >= time ? true : false;
        for(int i = 0; i < length; ++ i){
            if(afterTime[i] && preTime[i]){
                res.Add(i);
            }
        }
        return res;
    }
}