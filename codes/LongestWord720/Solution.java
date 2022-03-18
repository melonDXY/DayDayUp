package codes.LongestWord720;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestWord(String[] words) {
        String target = "";
        Arrays.sort(words, (a, b)->{
            if(a.length() != b.length()){
                return a.length() - b.length();
            }else{
                return b.compareTo(a);
            }
        });

        Set<String> candicate = new HashSet<String>();
        candicate.add(target);
        for (String word : words) {
            //理论上要防止索引错误
            if(word.length() == 0){
                continue;
            }
            String tmp = word.substring(0, word.length()-1);    
            if(candicate.contains(tmp)){
                candicate.add(word);
                target = word;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        String[] words = {"w","wo","wor","worl","world"};
        Solution solution = new Solution();
        System.out.println(solution.longestWord(words));
    }
}
