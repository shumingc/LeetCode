//Validate if a given string is numeric.

//Some examples:
//"0" => true
//" 0.1 " => true
//"abc" => false
//"1 a" => false
//"2e10" => true
//Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        return s.matches("[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?");
    }
    public boolean isNumberState(String s) {
        s = s.trim();
        if(s.length() == 0) return false;
        int i = 0, e = s.length() - 1;
        if(s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while(i <= e){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                num = true;
            }else if(c == '.'){
                if(exp || dot) return false;
                dot = true;
            }else if(c == 'e'){
                if(exp || num == false) return false;
                exp = true;
                num = false;
            }else if(c == '+' || c == '-'){
                if(s.charAt(i - 1) != 'e') return false;
            }else{
                return false;
            }
            i++;
        }
        return num;
    }
}