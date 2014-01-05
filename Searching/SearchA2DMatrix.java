//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int first = 0;
        int last = m*n;
        while(first < last){
            int mid = (first + last) / 2;
            int val = matrix[mid/n][mid%n];
            if(val == target){
                return true;
            }else if(val < target){
                first = mid + 1;
            }else{
                last = mid;
            }
        }
        return false;
    }
}