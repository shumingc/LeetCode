//Implement wildcard pattern matching with support for '?' and '*'.

//'?' Matches any single character.
//'*' Matches any sequence of characters (including the empty sequence).

//The matching should cover the entire input string (not partial).

//The function prototype should be:
//bool isMatch(const char *s, const char *p)

//Some examples:
//isMatch("aa","a") → false
//isMatch("aa","aa") → true
//isMatch("aaa","aa") → false
//isMatch("aa", "*") → true
//isMatch("aa", "a*") → true
//isMatch("ab", "?*") → true
//isMatch("aab", "c*a*b") → false
public class Solution {
    public boolean isMatch(String s, String p) {
        if( s == null || p == null) return false;
        int count = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*'){
                count++;
            }
        }
        if(count > s.length()) return false;
        boolean[] matches = new boolean[s.length() + 1];
        matches[0] = true;
        int pid = 0, firstMatch = 0;
        while(pid < p.length()){
            if(pid > 0 && p.charAt(pid) == '*' && p.charAt(pid-1) == '*') {
                pid++;
                continue;
            }
            if(p.charAt(pid) == '*'){
                for(int i =firstMatch + 1; i <= s.length(); i++){
                    matches[i] = true;
                }
            }else{
                int match = -1;
                for (int i = s.length(); i > firstMatch; i--){
                    matches[i] = (p.charAt(pid) == s.charAt(i-1) || p.charAt(pid) == '?') && matches[i-1];
                    if(matches[i]) match = i;
                }
                if(match < 0) return false;
                firstMatch = match;
            }
            pid++;
        }
        return matches[s.length()];
    }
}