//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

//Note:
//Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
//The solution set must not contain duplicate quadruplets.
 //   For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 //   A solution set is:
   // (-1,  0, 0, 1)
   // (-2, -1, 1, 2)
    //(-2,  0, 0, 2)
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 4) return result;
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 3; i++){
            for(int j = i+1; j < num.length - 2; j++){
                int a = i;
                int b = j;
                int c = j+1;
                int d = num.length - 1;
                while(c < d){
                    int sum = num[a] + num[b] + num[c] + num[d];
                    if(sum == target){
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(num[a]);
                        r.add(num[b]);
                        r.add(num[c]);
                        r.add(num[d]);
                        if(!hs.contains(r)){
                            hs.add(r);
                            result.add(r);
                        }
                        c++;
                        d--;
                    }else if(sum < target){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num.length < 4) return result;
        Arrays.sort(num);
        HashMap<Integer, ArrayList<Pair>> hm = new HashMap<Integer, ArrayList<Pair>>();
        HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < num.length - 1; i++){
            for(int j = i + 1; j < num.length; j++){
                int key = num[i] + num[j];
                Pair p = new Pair(i, j);
                if(!hm.containsKey(key)){
                    hm.put(key, new ArrayList<Pair>());
                }
                hm.get(key).add(p);
            }
        }
        for(int i = 2; i < num.length - 1; i++){
            for(int j = i + 1; j < num.length; j++){
                int k = target - num[i] - num[j];
                if(hm.containsKey(k)){
                    ArrayList<Pair> pairList = hm.get(k);
                    for(int c = 0; c < pairList.size(); c++){
                        Pair p = pairList.get(c);
                        if(i <= p.second) continue;
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(num[p.first]);
                        r.add(num[p.second]);
                        r.add(num[i]);
                        r.add(num[j]);
                        if(!hs.contains(r)){
                            hs.add(r);
                            result.add(r);
                        }
                    }
                }
            }
        }
        return result;
    }

    private class Pair {
        int first;
        int second;
        public Pair(int f, int s){
            first = f;
            second = s;
        }
    }
}