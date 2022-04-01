class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        unordered_map<int, int> cnt;
        for(int x : arr){
            ++ cnt[x];
        }
        vector<int> vals;
        for(auto x : cnt){
            vals.push_back(x.first);
        }

        sort(vals.begin(), vals.end(), [](int a, int b){return abs(a) < abs(b);});

        for(int x : vals){
            if(cnt[x * 2] < cnt[x]){
                return false;
            }
            else
            {
                cnt[x * 2] -= cnt[x];
            }
        }
        return true;
    }
};