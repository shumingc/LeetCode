//TGiven a binary tree, find the maximum path sum.

//The path may start and end at any node in the tree.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class Result {
        int val;
        public Result (int i){
            val = i;
        }
    }
    public int maxPathSum(TreeNode root) {
        Result res = new Result(Integer.MIN_VALUE);
        DFS(root, res);
        return res.val;
    }
    private int DFS(TreeNode root, Result res){
        if(root == null){
            return 0;
        }
        int l = DFS(root.left, res);
        int r = DFS(root.right, res);
        int sum = root.val;
        if(l > 0) sum += l;
        if(r > 0) sum += r;
        res.val = Math.max(res.val, sum);
        return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;
    }
}