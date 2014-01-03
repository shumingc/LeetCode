//Follow up for problem "Populating Next Right Pointers in Each Node".

//What if the given tree could be any binary tree? Would your previous solution still work?

//Note:

//You may only use constant extra space.
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
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode next = null; // the first node of next level
            TreeLinkNode prev = null; // previous node on the same level
            while (node != null) {
                if(next==null){
                    next = (node.left==null? node.right:node.left);
                }
                if (node.left != null) {
                    if(prev!=null){
                        prev.next = node.left;
                    }
                    prev = node.left;
                }

                if (node.right != null) {
                    if(prev!=null){
                        prev.next = node.right;
                    }
                    prev = node.right;
                }

                node = node.next;
            }
            node = next;
        }
    }
}