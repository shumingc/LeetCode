//Given an integer, convert it to a roman numeral.

//Input is guaranteed to be within the range from 1 to 3999.
public class Solution {
    public String intToRoman(int num) {
        int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom = new String[]{"M","CM","D","CD", "C","XC","L","XL","X","IX","V","IV","I"};
        String roman = "";
        while(num > 0){
            int start = 0;
            while(num/val[start] == 0) {
                start++;
            }
            for(int i = 0; i < num/val[start]; i++){
                roman += rom[start];
            }
            num %= val[start];
        }
        return roman;
    }
}