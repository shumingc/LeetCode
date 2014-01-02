//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


//Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


//The largest rectangle is shown in the shaded area, which has area = 10 unit.

//For example,
//Given height = [2,1,5,6,2,3],
//return 10.
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stk = new Stack<Integer>();
        int[] h = new int[height.length + 1];
        for(int i = 0; i < height.length; i++){
            h[i] = height[i];
        }
        h[height.length] = 0;
        int result = 0;
        for(int i = 0; i < h.length; i++){
            if(stk.empty() || h[i] > h[stk.peek()]){
                stk.push(i);
            }else{
                int tmp = stk.pop();
                result = Math.max(result, h[tmp] * (stk.empty()? i: i - stk.peek() - 1));
                i--;
            }
        }
        return result;
    }
}