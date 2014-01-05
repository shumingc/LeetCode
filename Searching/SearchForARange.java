//Given a sorted array of integers, find the starting and ending position of a given target value.

//Your algorithm's runtime complexity must be in the order of O(log n).

//If the target is not found in the array, return [-1, -1].

//For example,
//Given [5, 7, 7, 8, 8, 10] and target value 8,
//return [3, 4].
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int lower = lower_bound(A, target, 0, A.length - 1);
        int upper = upper_bound(A, target, 0, A.length - 1);
        if(A[lower] != target){
            return new int[] {-1, -1};
        }else{
            return new int[] {lower, upper};
        }
    }
    private int lower_bound(int[]A, int target, int first, int last){
        while(first != last){
            int mid = (first + last)/2;
            if(A[mid] < target){
                first = mid + 1;
            }else{
                last = mid;
            }
        }
        return first;
    }
    private int upper_bound(int[]A, int target, int first, int last){
        while(first != last){
            int mid = (first + last)/2 + 1;
            if(A[mid] > target){
                last = mid - 1;
            }else{
                first = mid;
            }
        }
        return last;
    }
}