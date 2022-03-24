package codes.StackPop;

import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
      Stack<Integer> myStack = new Stack<Integer>();
      int pushP = 0;
      int popP = 0;
      while(pushP < pushA.length){
        if(pushA[pushP] == popA[popP]) {
          pushP++;
          popP++;
          while(!myStack.empty() && myStack.peek() == popA[popP]) {
            myStack.pop();
            popP++;
          }
        }
        else{
          myStack.push(pushA[pushP]);
          pushP++;
        }
      }
      return myStack.empty();
    }
}