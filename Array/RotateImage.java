//You are given an n x n 2D matrix representing an image.

//Rotate the image by 90 degrees (clockwise).

//Follow up:
//Could you do this in-place?
public class Solution {
    public void rotate(int[][] matrix) {
        for(int layer = 0; layer < matrix.length/2; layer++){
            int first = layer;
            int last = matrix.length - layer - 1;
            for(int i = first; i < last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[first + offset][last];
                matrix[first + offset][last] = top;
            }
        }
    }
}