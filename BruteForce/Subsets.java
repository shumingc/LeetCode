//Given a set of distinct integers, S, return all possible subsets.

//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> cur = new Stack<Integer>();
        helper(S, 0, cur, res);
        return res;
    }
    private void helper(int[] S, int step, Stack<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if(S.length == step){
            res.add(new ArrayList(cur));
            return;
        }
        helper(S, step + 1, cur, res);
        cur.push(S[step]);
        helper(S, step + 1, cur, res);
        cur.pop();
    }
}