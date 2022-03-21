class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if(n == 0)
            return 0;
        vector<int> raise(n + 1, 0);
        int len = 1;
        raise[len] = nums[0];
        for(int i = 1; i < n; ++ i){
            if(nums[i] > raise[len]){
                raise[++ len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while(l <= r){
                    int mid = (l + r) >> 1;
                    if(raise[mid] < nums[i]){
                        l = mid + 1;
                        pos = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                raise[pos + 1] = nums[i];
            }
        }
        return len;
    }
};