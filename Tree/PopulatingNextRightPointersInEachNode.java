//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

//Initially, all next pointers are set to NULL.

//Note:

//You may only use constant extra space.
//You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(root==null){
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        if(left!=null){
            left.next = right;
        }
        if(right!=null){
            right.next = root.next==null? null: root.next.left;
        }
        connect(left);
        connect(right);
    }
}