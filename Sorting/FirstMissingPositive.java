//Given an unsorted integer array, find the first missing positive integer.

//For example,
//Given [1,2,0] return 3,
//and [3,4,-1,1] return 2.

//Your algorithm should run in O(n) time and uses constant space.

public class Solution {
    public int firstMissingPositive(int[] A) {
        sort(A);
        for(int i = 0; i < A.length; i++){
            if(A[i] != i + 1){
                return i + 1;
            }
        }
        return A.length + 1;
    }
    private void sort(int[] A){
        for(int i = 0; i < A.length; i++){
            while(A[i] != i + 1){
                if(A[i] <= 0 || A[i] > A.length || A[i] == A[A[i] - 1]){
                    break;
                }
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
    }
}