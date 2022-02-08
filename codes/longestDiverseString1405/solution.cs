public class Solution {
    public string LongestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        int MinA = Math.Min(a, (b + c + 1) * 2);
        int MinB = Math.Min(b, (a + c + 1) * 2);
        int MinC = Math.Min(c, (b + a + 1) * 2);
        int MaxL = MinA + MinB + MinC;
        Pair[] rest = {new Pair(MinA, 'a'), new Pair(MinB, 'b'), new Pair(MinC, 'c')};
        int pos = 0;
        while(pos < MaxL){
            Array.Sort(rest, (p1, p2) => p2.Freq - p1.Freq);
            foreach(Pair curPair in rest){
                if(pos >= 2 && res[pos - 1] == curPair.Ch && res[pos - 2] == curPair.Ch){
                    continue;
                }
                res.Append(curPair.Ch);
                -- curPair.Freq;
                break;
            }

            ++ pos;
        }
        return res.ToString();
    }

    class Pair{
        public int Freq {get; set;}
        public char Ch {get; set;}

        public Pair(int Freq, char Ch){
            this.Freq = Freq;
            this.Ch = Ch;
        }
    }
}