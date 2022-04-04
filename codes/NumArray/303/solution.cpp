class NumArray {
public:
    vector<int> ans;
    int n;
    NumArray(vector<int>& nums) {
        if(nums.size() == 0){
            return ;
        }
        n = nums.size();
        ans = vector<int>(n);
        ans[0] = nums[0];
        for(int i = 1; i < n; ++ i){
            ans[i] = ans[i - 1] + nums[i];
        }
    }
    
    int sumRange(int left, int right) {
        return left == 0 ? ans[right] : ans[right] - ans[left - 1];
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */