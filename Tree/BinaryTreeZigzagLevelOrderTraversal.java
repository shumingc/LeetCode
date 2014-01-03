//Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> current_level = new LinkedList<TreeNode>();
        Queue<TreeNode> next_level = new LinkedList<TreeNode>();
        Queue<TreeNode> temp;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        boolean zig = true;
        if(root == null) return result;
        current_level.add(root);
        while(current_level.size() != 0){
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(current_level.size() != 0){
                TreeNode node = current_level.peek();
                current_level.poll();
                if(zig){
                    level.add(node.val);
                }else{
                    level.add(0, node.val);
                }
                if(node.left != null){
                    next_level.add(node.left);
                }
                if(node.right != null){
                    next_level.add(node.right);
                }
            }
            result.add(level);
            temp = current_level;
            current_level = next_level;
            next_level = temp;
            zig = !zig;
        }
        return result;
    }
}