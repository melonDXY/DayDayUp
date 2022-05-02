#include<iostream>
#include<bits/stdc++.h>
using namespace std;
#define LL long long
int main(){
    int t;
    cin >> t;
    while(t -- > 0){
        int n, m;
        cin >> n >> m;
        // dp[i][0] 表示第i天在左边时最大值
        // dp[i][1] 表示第i天在右边时最大值
        vector<vector<LL>> dp(n, vector<LL>(2,0));
        vector<vector<LL>> park(n, vector<LL>(m));
        for(int i = 0; i < n; ++ i){
            LL rowSum = 0;
            // 输入每一天的公园值
            for(int j = 0; j < m; ++ j){
                cin >> park[i][j];
                rowSum += park[i][j];
            }
            if(i == 0){
                dp[0][1] = rowSum;
            } else {
                dp[i][0] = dp[i - 1][1] + rowSum;
                dp[i][1] = dp[i - 1][0] + rowSum;
            }

            LL leftMax = 0, rightMax = 0;
            LL leftSum = 0, rightSum = 0;
            for(int j = 0; j < m; ++ j){
                leftSum += park[i][j];
                rightSum += park[i][m - j - 1];
                leftMax = max(leftMax, leftSum);
                rightMax = max(rightMax, rightSum);
            }
            if(i == 0){
                dp[0][0] = max(0LL, leftMax);
            } else {
                dp[i][0] = max(dp[i - 1][0] + leftMax, dp[i][0]);
                dp[i][1] = max(dp[i - 1][1] + rightMax, dp[i][1]);
            }
        }
        cout << max(dp[n - 1][0], dp[n - 1][1]) << endl;

    }
    return 0;
}