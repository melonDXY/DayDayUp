public class Solution {
    public int FindCenter(int[][] edges) {
        // 额 就很不优雅
        if(edges[1][0] == edges[0][0] ||edges[1][1] == edges[0][0]) return edges[0][0];
        return edges[0][1];
    }
}