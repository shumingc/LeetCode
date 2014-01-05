//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

//An example is the root-to-leaf path 1->2->3 which represents the number 123.

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
    public int sumNumbers(TreeNode root) {
        return DFS(root, 0);
    }
    private int DFS(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return sum*10 + root.val;
        }
        return DFS(root.left, sum*10 + root.val) + DFS(root.right, sum*10 + root.val);
    }
}