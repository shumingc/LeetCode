//two elements of a binary search tree (BST) are swapped by mistake.

//Recover the tree without changing its structure.

//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode node = root;
        while(!s.empty() || node != null){
            if(node != null){
                s.push(node);
                node = node.left;
            }else{
                node = s.pop();
                inorder.add(node);
                node = node.right;
            }
        }
        int i = 0;
        while(inorder.get(i).val < inorder.get(i+1).val) i++;
        TreeNode n1 = inorder.get(i);
        i = inorder.size() - 1;
        while(inorder.get(i).val > inorder.get(i - 1).val) i--;
        TreeNode n2 = inorder.get(i);
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
}