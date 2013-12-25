//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

//The replacement must be in-place, do not allocate extra memory.

//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length == 0 || num.length == 1) return;
        int last = num.length - 1;
        while(last-1>= 0 && num[last-1] >= num[last]){
            last--;
        }
        if(last == 0){
            reverse(num, 0, num.length - 1);
            return;
        }
        int pivot = last - 1;
        int change = num.length - 1;
        while(num[change] <= num[pivot]){
            change--;
        }
        int temp = num[pivot];
        num[pivot] = num[change];
        num[change] = temp;
        reverse(num, last, num.length - 1);
    }
    private void reverse(int[] num, int first, int last){
        while(first < last){
            int temp = num[first];
            num[first] = num[last];
            num[last] = temp;
            first++;
            last--;
        }
    }
}