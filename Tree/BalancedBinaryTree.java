//Given a binary tree, determine if it is height-balanced.

//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public boolean isBalanced(TreeNode root) {
        return balancedHeight(root) >= 0;
    }
    private int balancedHeight(TreeNode root){
        if(root == null) return 0;
        int left_height = balancedHeight(root.left);
        int right_height = balancedHeight(root.right);
        if(left_height < 0 || right_height < 0 || Math.abs(left_height - right_height) > 1)  return -1;
        return Math.max(left_height, right_height) + 1;
    }
}