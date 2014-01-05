//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        DFS(n, k, 1, cur, res);
        return res;
    }
    private void DFS(int n, int k, int start, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        if(cur.size() == k){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            cur.add(i);
            DFS(n, k, i+1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}