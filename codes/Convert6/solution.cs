public class Solution {
    public string Convert(string s, int numRows) {
        // 边界情况优化
        int length = s.Length;
        if(numRows == 1 || numRows >= length){
            return s;
        }
        // 开始构造
        StringBuilder sb = new StringBuilder();
        int t = numRows * 2 - 2;// 周期
        for(int row = 0; row < numRows; ++ row){// 枚举行数
            for(int firstIndex = 0; firstIndex < length - row; firstIndex += t){// 枚举每个周期的第一个坐标
                // 首字符
                sb.Append(s[row + firstIndex]);
                // 第二个字符，该字符在中间行，
                if(row > 0 && row < numRows - 1 && firstIndex + t - row < length){
                    sb.Append(s[firstIndex + t - row]);
                }
            }
        }
        return sb.ToString();
    }
}