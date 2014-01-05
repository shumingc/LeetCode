//Given a collection of integers that might contain duplicates, S, return all possible subsets.

//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < num.length; i++){
            if(!map.containsKey(num[i])){
                map.put(num[i], 0);
            }
            map.put(num[i], map.get(num[i]) + 1);
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> cur = new Stack<Integer>();
        int[] newNum = new int[map.size()];
        newNum[0] = num[0];
        for(int i = 1, j = 1; i < num.length; i++){
            if(num[i] != num[i-1]){
                newNum[j] = num[i];
                j++;
            }
        }
        helper(newNum, 0, cur, res, map);
        return res;
    }
    private void helper(int[] num, int step, Stack<Integer> cur, ArrayList<ArrayList<Integer>> res,
                        HashMap<Integer, Integer> map){
        if(num.length == step){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i <= map.get(num[step]); i++){
            for(int j = 0; j < i; j++){
                cur.push(num[step]);
            }
            helper(num, step + 1, cur, res, map);
            for(int j = 0; j < i; j++){
                cur.pop();
            }
        }
    }
}