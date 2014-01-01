//Write a function to find the longest common prefix string amongst an array of strings.
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = "";
        int pos = 0;
        while(true){
            char c = ' ';
            int i = 0;
            for(; i < strs.length && pos < strs[0].length(); i++){
                if(i == 0) c = strs[0].charAt(pos);
                if(strs[i].length() == pos || strs[i].charAt(pos) != c){
                    break;
                }
            }
            if(i != strs.length){
                break;
            }
            prefix += c;
            pos++;
        }
        return prefix;
    }
}