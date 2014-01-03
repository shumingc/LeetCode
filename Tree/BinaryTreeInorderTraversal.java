//Given a binary tree, return the inorder traversal of its nodes' values.

//For example:
//Given binary tree {1,#,2,3},
 //  1
 //   \
 //    2
 //   /
 //  3
//return [1,3,2].
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(!s.empty() || node != null){
            if(node != null){
                s.push(node);
                node = node.left;
            }else{
                node = s.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}