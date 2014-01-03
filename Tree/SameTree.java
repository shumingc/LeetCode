//Given two binary trees, write a function to check if they are equal or not.

//Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(p==null){
            return q==null? true:false;
        }else if(q==null){
            return p==null? true:false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    public boolean isSameTreeIterate(TreeNode p, TreeNode q) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(p);
        s.push(q);
        while(!s.empty()){
            p = s.pop();
            q = s.pop();
            if(p == null && q == null) continue;
            if(p == null || q == null) return false;
            if(p.val != q.val) return false;
            s.push(p.left);
            s.push(q.left);
            s.push(p.right);
            s.push(q.right);
        }
        return true;
    }
}