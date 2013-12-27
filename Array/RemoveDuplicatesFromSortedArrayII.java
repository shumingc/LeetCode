//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice?
//For example,
//Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0) return 0;
        int index = 0;
        int occur = 1;
        for(int i = 1; i < A.length; i++){
            if(A[index] == A[i]){
                if(occur < 2){
                   index++;
                   A[index] = A[i];
                   occur++;
                }
            }else{
                index++;
                A[index] = A[i];
                occur = 1;
            }
        }
        return index + 1;
    }
}