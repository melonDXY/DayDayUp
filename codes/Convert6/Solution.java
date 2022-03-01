package codes.Convert6;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String convert(String s, int numRows){
        if(numRows == 1){
            return s;
        }else{
            int c = 0;
            int flag = 1;
            int row = 0;
            int col = 1;
            String key = " + ";
            Map<String, Character> mMap = new HashMap<String, Character>();

            char[] cArr = s.toCharArray();
            for(int i = 0; i<cArr.length; i++){
                if(c < numRows){
                    if(flag == 1){
                        row += flag;
                        key = String.format("%d+%d", row, col);
                        mMap.put(key, cArr[i]);  
                        c++;
                        continue;
                    }
                    if(flag == -1){
                        row += flag;
                        col += 1;
                        key = String.format("%d+%d", row, col);
                        mMap.put(key, cArr[i]);
                        c++;
                        continue;
                    }
                }
                flag = flag*-1;
                if(flag == 1){
                    row += flag;
                    key = String.format("%d+%d", row, col);
                    mMap.put(key, cArr[i]);  
                    c=2;
                    continue;
                }
                if(flag == -1){
                    row += flag;
                    col += 1;
                    key = String.format("%d+%d", row, col);
                    mMap.put(key, cArr[i]);
                    c=2;
                    continue;
                }
            }
            StringBuilder ans = new StringBuilder();
            for(int ri = 1; ri <= numRows; ri++){
                    for(int j = 1; j <= col; j++){
                        if(mMap.get(ri+"+"+j) != null){
                            ans.append(mMap.get(ri+"+"+j));
                        }
                    }
                }
            return ans.toString();
        }
    }




    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        Solution solution = new Solution();
        System.out.println(solution.convert(s, numRows));
    //     int c = 0;
    //     int flag = 1;
    //     int row = 0;
    //     int col = 1;
    //     String key = " + ";
    //     Map<String, Character> mMap = new HashMap<String, Character>();

    //     char[] cArr = s.toCharArray();
    //     for(int i = 0; i<cArr.length; i++){
    //         if(c < numRows){
    //             if(flag == 1){
    //                 row += flag;
    //                 key = String.format("%d+%d", row, col);
    //                 mMap.put(key, cArr[i]);  
    //                 c++;
    //                 continue;
    //             }
    //             if(flag == -1){
    //                 row += flag;
    //                 col += 1;
    //                 key = String.format("%d+%d", row, col);
    //                 mMap.put(key, cArr[i]);
    //                 c++;
    //                 continue;
    //             }
    //         }
    //         flag = flag*-1;
    //         if(flag == 1){
    //             row += flag;
    //             key = String.format("%d+%d", row, col);
    //             mMap.put(key, cArr[i]);  
    //             c=2;
    //             continue;
    //         }
    //         if(flag == -1){
    //             row += flag;
    //             col += 1;
    //             key = String.format("%d+%d", row, col);
    //             mMap.put(key, cArr[i]);
    //             c=2;
    //             continue;
    //         }
    //     }
        
    //     StringBuilder ans = new StringBuilder();
    //     for(int i = 1; i <= numRows; i++){
    //         for(int j = 1; j <= col; j++){
    //             if(mMap.get(i+"+"+j) != null){
    //                 ans.append(mMap.get(i+"+"+j));
    //             }
    //         }
    //     }
    //     System.out.println(ans.toString());
    }
}
