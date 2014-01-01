//Implement atoi to convert a string to an integer.

//Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

//Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

//spoilers alert...
public class Solution {
    public int atoi(String str) {
        int num = 0;
        int sign = 1;
        int len = str.length();
        if(len == 0) return num;
        int i = 0;
        while(str.charAt(i) == ' ' && i < len) i++;
        if(i == len) return num;
        if(str.charAt(i) == '+') {
            i++;
        }else if(str.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        while(i < len){
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                break;
            }
            if(num > Integer.MAX_VALUE/10 ||
                    (num == Integer.MAX_VALUE/10 && (str.charAt(i) - '0') >  Integer.MAX_VALUE%10)){
                return sign == 1?  Integer.MAX_VALUE :  Integer.MIN_VALUE;
            }
            num = num * 10 + str.charAt(i) - '0';
            i++;
        }
        return num * sign;
    }
}