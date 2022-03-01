public class Solution {
    int[] deltaNum;// 记录楼人数的变化
    int full, num; // 记录满楼的数目，记录楼总数
    int ans = 0, cnt = 0;// 记录答案和本次计数
    public int MaximumRequests(int n, int[][] requests) {
        num = n;
        full = n;
        deltaNum = new int[n];
        // 开始搜索
        DFS(requests, 0);
        return ans;
    }

    // 从request[pos]开始开始搜索
    public void DFS(int[][] requests, int pos) {
        // 已经搜索完毕
        if(pos == requests.Length){
            // 所有楼满
            if(full == num){
                ans = Math.Max(cnt, ans);
            }
            return ;
        }

        // 不搜索此节点
        DFS(requests, pos + 1);

        // 搜索此节点
        int f = full;
        ++ cnt;
        int[] curRequest = requests[pos];
        int x = curRequest[0], y = curRequest[1];
        // 出楼前或入楼前 若此楼满，则不满楼 -1
        // 出楼后或如楼后 若此楼满，则不满楼 +1
        // 出x楼
        full -= deltaNum[x] == 0 ? 1 : 0;
        -- deltaNum[x];
        full += deltaNum[x] == 0 ? 1 : 0;
        // 入y楼
        full -= deltaNum[y] == 0 ? 1 : 0;
        ++ deltaNum[y];
        full += deltaNum[y] == 0 ? 1 : 0;
        // 搜索下个位置
        DFS(requests, pos + 1);

        // 还原状态
        -- cnt;
        full = f;
        -- deltaNum[y];
        ++ deltaNum[x];
    }
}