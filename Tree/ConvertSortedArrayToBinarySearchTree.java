//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return helper(num, 0, num.length - 1);
    }
    private TreeNode helper(int[] num, int first, int last){
        int length = last - first + 1;
        if(length <= 0) return null;
        if(length == 1) return new TreeNode(num[first]);
        int mid = first + length/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, first, mid - 1);
        node.right = helper(num, mid + 1, last);
        return node;
    }
}