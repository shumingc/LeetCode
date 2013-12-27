//There are two sorted arrays A and B of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int total = A.length + B.length;
        if(total%2 != 0){
            return find_kth(A, A.length, B, B.length, total/2 + 1);
        }else{
            return (find_kth(A, A.length, B, B.length, total/2)
                    + find_kth(A, A.length, B, B.length, total/2 + 1)) / 2;
        }
    }
    private double find_kth(int A[], int m, int B[], int n, int k){
        if(m > n) return find_kth(B, n, A, m, k);
        int a = A.length - m;
        int b = B.length - n;
        if(m == 0) return B[k-1+b];
        if(k == 1) return Math.min(A[a], B[b]);
        int pa = Math.min(k/2, m);
        int pb = k - pa;
        if(A[pa+a-1] < B[pb+b-1]){
            return find_kth(A, m - pa, B, n, k - pa);
        }else if(A[pa+a-1] > B[pb+b-1]){
            return find_kth(A, m, B, n - pb, k - pb);
        }else{
            return A[pa+a-1];
        }
    }
}