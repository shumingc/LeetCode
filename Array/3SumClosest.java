//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//    For example, given array S = {-1 2 1 -4}, and target = 1.

 //   The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(num);
        int min_gap = Integer.MAX_VALUE;
        int result = 0;
        for(int i = 0; i < num.length -2; i++){
            int first = i;
            int second = i + 1;
            int third = num.length - 1;
            int a = num[first];
            int b = num[second];
            int c = num[third];
            while(second < third){
                int sum = a + b + c;
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    int gap = Math.abs(sum - target);
                    if(gap < min_gap){
                        min_gap = gap;
                        result = sum;
                    }
                    second++;
                    b = num[second];
                }else{
                    int gap = Math.abs(sum - target);
                    if(gap < min_gap){
                        min_gap = gap;
                        result = sum;
                    }
                    third--;
                    c = num[third];
                }
            }
        }
        return result;
    }
}