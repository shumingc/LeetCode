//iven a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

//You may assume no duplicates in the array.
public class Solution {
    public int searchInsert(int[] A, int target) {
        int lower = lower_bound(A, target, 0, A.length - 1);
        return A[lower] < target? lower + 1 : lower;
    }
    public int lower_bound(int[] A, int target, int first, int last){
        while(first != last){
            int mid = (first + last) / 2;
            if(A[mid] < target){
                first = mid + 1;
            }else{
                last = mid;
            }
        }
        return first;
    }
}