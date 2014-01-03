//Given preorder and inorder traversal of a tree, construct the binary tree.

//Note:
//You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || preorder.length != inorder.length) return null;
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode buildTree(int[]preorder, int pre_first, int pre_last,
            int[] inorder, int in_first, int in_last){
        if(pre_first > pre_last || in_first > in_last) return null;
        TreeNode root = new TreeNode(preorder[pre_first]);
        int i = in_first;
        for(; i <= in_last; i++){
            if(inorder[i] == root.val) break;
        }
        int leftsize = i - in_first;
        root.left = buildTree(preorder, pre_first + 1, pre_first + leftsize,
            inorder, in_first, in_first + leftsize -1);
        root.right = buildTree(preorder, pre_first + leftsize + 1, pre_last,
            inorder, in_first + leftsize + 1, in_last);
        return root;
    }
}