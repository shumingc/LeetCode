//Given a binary tree, find its minimum depth.

//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Stack<Pair> s = new Stack<Pair>();
        s.push(new Pair(root, 1));
        int result = Integer.MAX_VALUE;
        while(!s.empty()){
            TreeNode n = s.peek().node;
            int depth = s.peek().depth;
            s.pop();
            if(n.left == null && n.right == null){
                result = Math.min(result, depth);
            }
            if(n.left != null && depth < result){
                s.push(new Pair(n.left, depth + 1));
            }
            if(n.right != null && depth < result){
                s.push(new Pair(n.right, depth + 1));
            }
        }
        return result;
    }
    class Pair{
        TreeNode node;
        int depth;
        public Pair(TreeNode n, int d){
            node = n;
            depth = d;
        }
    }
}

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        d = Integer.MAX_VALUE;
        helper(root, 1);
        return d;
    }
    private int d;
    private void helper(TreeNode root, int cur){
        if(root != null){
            if(root.left == null && root.right == null){
                if(cur < d){
                    d = cur;
                }
                return;
            }
            if(cur < d){
                helper(root.left, cur + 1);
                helper(root.right, cur + 1);
            }
        }
    }
}