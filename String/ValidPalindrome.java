//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.

//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.

//For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null || s.length()==0 || s.length() == 1){
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char a = s.charAt(i);
            char b = s.charAt(j);

            if(!Character.isLetterOrDigit(a)){
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(b)){
                j--;
                continue;
            }

            if(Character.toLowerCase(a)!=Character.toLowerCase(b)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}