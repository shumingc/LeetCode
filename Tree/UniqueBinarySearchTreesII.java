//Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

//For example,
//Given n = 3, your program should return all 5 unique BST's shown below.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        if(n == 0) return generate(1, 0);
        return generate(1, n);
    }
    private ArrayList<TreeNode> generate(int start, int end){
        ArrayList<TreeNode> subtrees = new ArrayList<TreeNode>();
        if(start > end){
            subtrees.add(null);
            return subtrees;
        }
        for(int k = start; k <= end; k++){
            ArrayList<TreeNode> leftSubs = generate(start, k - 1);
            ArrayList<TreeNode> rightSubs = generate(k + 1, end);
            for(TreeNode i : leftSubs){
                for(TreeNode j : rightSubs){
                    TreeNode node = new TreeNode(k);
                    node.left = i;
                    node.right = j;
                    subtrees.add(node);
                }
            }
        }
        return subtrees;
    }
}