#include <iostream>
#include <vector>
using namespace std;

class Solution
{
public:
    /*01背包问题变种,返回值用long long,防止溢出*/
    long long getMoreHappiness(int X, vector<vector<int>>& games)
    {
        //空间压缩
        int n = games.size();
        long long happy4free = 0;
        for(int i=0; i<n; ++i)
        {
            //新的价格计算公式
            int price = games[i][1] + games[i][1] - games[i][0];
            if(price < 0) 
            {
                X -= price;
                happy4free += games[i][2];
            }
        }
        vector<long long> dp(X+1, 0);
        for(int i=0; i<n; ++i)
        {
            int price = games[i][1] + games[i][1] - games[i][0];
            if(price < 0) continue;
            for(int j=X; j>=price; --j)
            {
                dp[j] = max(dp[j], dp[j-price] + games[i][2]);
            }
        }
        return dp[X] + happy4free;
    }
};

int main()
{
    int n, X;
    cin>>n>>X;
    vector<vector<int>> games(n, vector<int>(3));
    for(int i=0; i<n; ++i)
    {
        for(int j=0; j<3; ++j)
        {
            cin>>games[i][j];
        }
    }
    Solution cjw;
    cout<<cjw.getMoreHappiness(X, games)<<endl;
    return 0;
}