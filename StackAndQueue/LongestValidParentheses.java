//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

//For "(()", the longest valid parentheses substring is "()", which has length = 2.

//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> lefts = new Stack<Integer>();
        int last = -1, maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                lefts.push(i);
            }else{
                if(lefts.empty()){
                    last = i;
                }else{
                    lefts.pop();
                    if(lefts.empty()){
                        maxLen = Math.max(maxLen, i - last);
                    }else{
                        maxLen = Math.max(maxLen, i - lefts.peek() );
                    }
                }
            }
        }
        return maxLen;
    }
}