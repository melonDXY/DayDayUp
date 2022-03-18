public class Solution {
    public bool IsValid(string s) {
        Stack<char> stack = new Stack<char>();
        char[] arr = s.ToCharArray();
        int cnt = 0;
        foreach(char ch in s){
            if(ch == '(' || ch == '{' || ch == '['){
                ++ cnt;
                stack.Push(ch);
            } else {
                if(stack.Count > 0){
                   char curTop = stack.Pop();
                    if(ch == ')'){
                        if(curTop != '(')
                            return false;
                    } else if(ch == '}'){
                        if(curTop != '{')
                            return false;
                    } else if(ch == ']'){
                        if(curTop != '[')
                            return false;
                    } else {
                        return false;
                    }
                    -- cnt; 
                } else {
                    return false;
                }
                
                
            }
        }
        return cnt == 0 ;
    }
}