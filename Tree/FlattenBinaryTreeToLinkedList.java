//Given a binary tree, flatten it to a linked list in-place.
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
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private TreeNode flatten(TreeNode root, TreeNode tail){
        if(root == null) return tail;
        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }
    public void flatten2(TreeNode root) {
        if(root == null) return;
        if(root.left != null) flatten(root.left);
        if(root.right != null) flatten(root.right);
        if(root.left == null) return;
        TreeNode p = root.left;
        while(p.right != null) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    public void flattenIterate(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.empty()){
            TreeNode p = s.pop();
            if(p.right != null) s.push(p.right);
            if(p.left != null) s.push(p.left);
            p.left = null;
            if(!s.empty()){
                p.right = s.peek();
            }
        }
    }
}