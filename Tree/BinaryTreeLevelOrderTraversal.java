//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

//For example:
//Given binary tree {3,9,20,#,#,15,7},
//    3
//   / \
//  9  20
//    /  \
//   15   7
//return its level order traversal as:
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


//OJ's Binary Tree Serialization:
//The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

//Here's an example:
//   1
//  / \
// 2   3
//    /
//   4
//    \
//     5
//The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
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
            result.add(level);
            temp = current_level;
            current_level = next_level;
            next_level = temp;
        }
        return result;
    }
}