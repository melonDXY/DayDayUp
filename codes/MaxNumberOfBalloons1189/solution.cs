public class Solution {
    public int MaxNumberOfBalloons(string text) {
        int[] count = new int[5];
        foreach(char ch in text){
            if (ch == 'b') {
                ++ count[0];
            } else if (ch == 'a') {
                ++ count[1];
            } else if (ch == 'l') {
                ++ count[2];
            } else if (ch == 'o') {
                ++ count[3];
            } else if (ch == 'n') {
                ++ count[4];
            }
        }
        count[2] /= 2;
        count[3] /= 2;
        return count.Min();
    }
}