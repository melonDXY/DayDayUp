package codes.FindCenter1791;

public class Solution {
    //星星图，必有元素相同，比较前两项中相同元素即可（n>=3），时间最短了，但是内存消耗怎么优化不清楚
    public int findCenter(int[][] edges) {
        // int x,a,b;
        // x = edges[0][0];
        // //y = edges[0][1];
        // a = edges[1][0];
        // b = edges[1][1];

        if(edges[0][0]==edges[1][0]){
            return edges[0][0];
        }
        else if(edges[0][0]==edges[1][1]){
            return edges[0][0];
        }
        // else if(y==a){
        //     return y;
        // }
        else{
            return edges[0][1];
        }

    }
}
}
