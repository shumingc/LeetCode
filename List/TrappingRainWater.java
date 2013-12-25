//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

//For example,
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
public class Solution {
    public int trap(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<Pair> s = new Stack<Pair>();
        int water = 0;
        for(int i = 0; i < A.length; i++){
            int height = 0;
            while(!s.empty()){
                Pair p = s.peek();
                int val = p.val;
                int index = p.index;
                water += (Math.min(val, A[i]) - height) * (i - index - 1);
                height = val;
                if(A[i] < val){
                    break;
                }else{
                    s.pop();
                }
            }
            s.push(new Pair(A[i], i));
        }
        return water;
    }
    private class Pair{
        int val;
        int index;
        public Pair(int v, int i){
            val = v;
            index = i;
        }
    }
}