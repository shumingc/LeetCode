//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...

//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.

//Note: The sequence of integers will be represented as a string.
public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return null;
        String s = "1";
        for(int i = 1; i < n; i++){
            s = get_next(s);
        }
        return s;
    }
    private String get_next(String s){
        StringBuilder res = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == c){
                count++;
            }else{
                res.append(String.valueOf(count));
                res.append(c);
                count = 1;
                c = s.charAt(i);
            }
        }
        res.append(String.valueOf(count));
        res.append(c);
        return res.toString();
    }
}