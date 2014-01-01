//Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        int start = 0;
        int maxLen = 1;
        for(int i = 0; i < len; i++){
            f[i][i] = true;
            for(int j = 0; j < i; j++){
                f[j][i] = (s.charAt(i) == s.charAt(j) && (j == i - 1||f[j+1][i-1]));
                if(f[j][i]&&i-j+1>maxLen){
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}