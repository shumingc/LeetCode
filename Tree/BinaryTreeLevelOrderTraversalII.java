//Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> current_level = new LinkedList<TreeNode>();
        Queue<TreeNode> next_level = new LinkedList<TreeNode>();
        Queue<TreeNode> temp;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        current_level.add(root);
        while(current_level.size() != 0){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(current_level.size() != 0){
                TreeNode node = current_level.peek();
                current_level.poll();
                level.add(node.val);
                if(node.left != null){
                    next_level.add(node.left);
                }
                if(node.right != null){
                    next_level.add(node.right);
                }
            }
            result.add(0, level);
            temp = current_level;
            current_level = next_level;
            next_level = temp;
        }
        return result;
    }
}