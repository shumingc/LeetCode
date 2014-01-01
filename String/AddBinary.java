//Given two binary strings, return their sum (also a binary string).

//For example,
//a = "11"
//b = "1"
//Return "100".

public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();
        int carry = 0;
        for(int i1 = a.length() - 1, i2 = b.length() - 1;i1 >= 0 || i2 >= 0; i1--, i2--){
            int ai = i1 >= 0? a.charAt(i1) - '0' : 0;
            int bi = i2 >= 0? b.charAt(i2) - '0' : 0;
            int val = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            result.insert(0, val);
        }
        if(carry == 1){
            result.insert(0, carry);
        }
        return result.toString();
    }
}