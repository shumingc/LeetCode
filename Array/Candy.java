//There are N children standing in a line. Each child is assigned a rating value.

//You are giving candies to these children subjected to the following requirements:

//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum candies you must give?
public class Solution {
    public int candy(int[] ratings) {
        int size = ratings.length;
        int result = size;
        int[] increment = new int[size];
        int incc = 1;
        for(int i = 0; i < size; i++){
            if(i >= 1 && ratings[i] > ratings[i-1]){
                increment[i] = Math.max(incc, increment[i]);
                incc++;
            }else{
                incc = 1;
            }
        }
        incc = 1;
        for(int i = size - 1; i >= 0; i--){
            if(i < size -1 && ratings[i] > ratings[i+1]){
                increment[i] = Math.max(incc, increment[i]);
                incc++;
            }else{
                incc = 1;
            }
        }
        for(int i = 0; i < size; i++){
            result += increment[i];
        }
        return result;
    }
}