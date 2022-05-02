class Solution {
public:
    string largestNumber(vector<int>& nums) {
        string ans = "";
        sort(nums.begin(), nums.end(), [](const int &x, const int &y){
            string a = to_string(x);
            string b = to_string(y);
            return a + b > b + a;
        });
        if(nums[0] == 0){
            return "0";
        }
        for(auto x : nums){
            ans += to_string(x);
        }
        return ans;
    }
};