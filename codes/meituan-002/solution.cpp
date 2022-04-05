#include<iostream>
#include<set>
#include<map>
using namespace std;

int presum[50005];//前缀和
set<int> s;//查询分割点左右边界
map<int, int> mp;//记录区间和

int main()
{
    int n;
    cin >> n;
    // 计算前缀和
    for(int i = 1; i <= n; ++ i){
        cin >> presum[i];
        presum[i] += presum[i - 1];
    }
    s.insert(0);
    s.insert(n + 1);

    while(n -- ){
        int pos;
        cin >> pos;
        auto idx = s.lower_bound(pos);//找到集合中大于等于pos的第一个值
        int right = *idx, left = *(--idx);//找到当前左边界和右边界
        int cursum = presum[right - 1] - presum[left];// 当前区间和
        // 如果当前和不是最大的和
        if(mp.find(cursum) != mp.end()){
            // 只有一个，则删除
            if(mp[cursum] == 1){
                mp.erase(cursum);
            } else {
                // 否则减一
                -- mp[cursum];
            }
        }
        //计算两边的区间和
        int left_sum = presum[pos - 1] - presum[left];// 左区间和
        int right_sum = presum[right - 1] - presum[pos];// 右区间和
        s.insert(pos);
        // 加入mp中
        ++ mp[left_sum];
        ++ mp[right_sum];
        // 输出mp中最大的值
        cout << mp.rbegin()->first << endl;
    }
    return 0;
}