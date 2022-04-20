class Solution {
public:
    int lengthLongestPath(string input) {
        stack<int> pathLength;
        int curLevelCnt = 0, filepathSum = 0, maxL = 0;
        int curLevel = 0;
        bool isFile = false;
        for(char curChar : input){
            if(curChar == '\n'){
                int level = curLevel;
                while(pathLength.size() > level){
                    filepathSum -= pathLength.top();
                    pathLength.pop();
                }
                if(!isFile){
                    pathLength.push(curLevelCnt);
                    filepathSum += curLevelCnt;
                } else {
                    maxL = max(maxL, filepathSum + curLevelCnt + curLevel);
                }
                curLevel = 0;
                curLevelCnt = 0;
                isFile = false;
            } else if(curChar == '\t'){
                ++ curLevel;
            } else {
                ++ curLevelCnt;
                if(curChar == '.'){
                    isFile = true;
                }
            }
        }
        int level = curLevel;
        while(pathLength.size() > level){
            filepathSum -= pathLength.top();
            pathLength.pop();
        }
        if(isFile){
            maxL = max(maxL, filepathSum + curLevelCnt + curLevel);
        }
        return maxL;
    }
};