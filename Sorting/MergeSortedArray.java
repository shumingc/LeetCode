//Given two sorted integer arrays A and B, merge B into A as one sorted array.

//Note:
//You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int a = m - 1;
        int b = n - 1;
        int i = m + n - 1;
        while(a >= 0 && b >= 0){
            if(A[a] >= B[b]){
                A[i] = A[a];
                a--;
            }else{
                A[i] = B[b];
                b--;
            }
            i--;
        }
        while(b >= 0){
            A[i] = B[b];
            b--;
            i--;
        }
    }
}