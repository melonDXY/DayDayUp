class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int ans = 0;
        if(k <= 1){
            return ans;
        }
        int startPos = 0;
        int curRes = 1;
        for(int endPos = 0; endPos < nums.size(); ++ endPos){
            if(nums[endPos] >= k){
                startPos = endPos + 1;
                curRes = 1;
            } else {
                ++ ans;
                curRes = curRes * nums[endPos];
                if(curRes < k){
                    ans += endPos - startPos;
                } else {
                    while(curRes >= k){
                        if(startPos == endPos){
                            curRes = nums[endPos];
                            break;
                        } else {
                            curRes = curRes / nums[startPos];
                            ++ startPos;
                        }
                    }
                    ans += endPos - startPos;
                }
            }
        }
        return ans;
    }
};