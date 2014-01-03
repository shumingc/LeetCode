//Given inorder and postorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || inorder.length != postorder.length) return null;
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int in_first, int in_last,
                            int[] postorder, int post_first, int post_last){
        if(in_first > in_last || post_first > post_last) return null;
        TreeNode root = new TreeNode(postorder[post_last]);
        int i = in_first;
        for(; i <= in_last; i++ ){
            if(inorder[i] == root.val) break;
        }
        int leftsize = i - in_first;
        root.left = build(inorder, in_first, in_first + leftsize - 1,
                            postorder, post_first, post_first + leftsize - 1);
        root.right = build(inorder, in_first + leftsize + 1, in_last,
                            postorder, post_first + leftsize, post_last - 1);
        return root;
    }
}