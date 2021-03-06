//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//You may assume no duplicate exists in the array.
public class Solution {
    public int search(int[] A, int target) {
        int first = 0;
        int last = A.length;
        while(first != last){
            int mid = (first + last)/2;
            if(A[mid] == target) return mid;
            if(A[first] <= A[mid]){
                if(A[first] <= target && target < A[mid]){
                    last = mid;
                }else{
                    first = mid + 1;
                }
            }else{
                if(A[mid] < target && target <= A[last-1]){
                    first = mid + 1;
                }else{
                    last = mid;
                }
            }
        }
        return -1;
    }
}