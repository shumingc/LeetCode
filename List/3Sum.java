//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

//Note:
//Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//The solution set must not contain duplicate triplets.
//    For example, given array S = {-1 0 1 2 -1 -4},

 //   A solution set is:
 //   (-1, 0, 1)
 //   (-1, -1, 2)
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) return results;
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        int target = 0;
        for(int i = 0; i < num.length - 2; i++){
            for(int j = i+1; j < num.length; j++){
                int c = target - num[i] - num[j];
                if(Arrays.binarySearch(num, j+1, num.length, c) > 0){
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(num[i]);
                    r.add(num[j]);
                    r.add(c);
                    if(hs.add(r)){
                        results.add(r);
                    }
                }
            }
        }
        return results;
    }
    public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 3) return result;
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        int target = 0;
        for(int i = 0; i < num.length - 2; i++){
            int a = i;
            int b = i + 1;
            int c = num.length - 1;
            while(b < c){
                int sum = num[a] + num[b] + num[c];
                if(sum == target){
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(num[a]);
                    r.add(num[b]);
                    r.add(num[c]);
                    if(!hs.contains(r)){
                        hs.add(r);
                        result.add(r);
                    }
                    b++;
                    c--;
                }else if(sum < target){
                    b++;
                }else{
                    c--;
                }
            }
        }
        return result;
    }
}