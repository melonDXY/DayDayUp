package codes.ReverseOnlyLetters917;

public class Solution {
    //双指针滑动匹配
    public String reverseOnlyLetters(String s) {
        char[] template = s.toCharArray();
        int start = 0;
        int end = template.length-1;
        while(start < end){
            //每次使用数组前都需要判断是否越界
            while(start < end && !(template[start] >= 65 && template[start] <= 90 || template[start] >= 97 && template[start] <= 122)){
                start++;
            }
            while(start < end && !(template[end] >= 65 && template[end] <= 90 || template[end] >= 97 && template[end] <= 122)){
                end--;
            }
            //swap
            char tmp = template[start];
            template[start] = template[end];
            template[end] = tmp;
            start++;
            end--;
        }

        return String.valueOf(template);
    }

    public static void main(String[] args) {
        String s = "ab-cd";
        Solution solution = new Solution();
        System.out.println(solution.reverseOnlyLetters(s));
        
    }
}
