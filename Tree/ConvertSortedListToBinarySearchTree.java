//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
       return helper(head, listLen(head));
    }
    private TreeNode helper(ListNode head, int len){
        if(len == 0) return null;
        if(len == 1) return new TreeNode(head.val);
        int mid = len/2;
        TreeNode root = new TreeNode(nth(head, mid + 1).val);
        root.left = helper(head, len/2);
        root.right = helper(nth(head, mid + 2), (len-1)/2);
        return root;
    }
    private int listLen(ListNode head){
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        return len;
    }
    private ListNode nth(ListNode head, int n){
        ListNode p = head;
        while(--n > 0){
            p = p.next;
        }
        return p;
    }
}