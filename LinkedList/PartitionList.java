//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

//You should preserve the original relative order of the nodes in each of the two partitions.

//For example,
//Given 1->4->3->2->5->2 and x = 3,
//return 1->2->2->4->3->5.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left_dummy = new ListNode(0);
        ListNode right_dummy  = new ListNode(0);
        ListNode left_cur = left_dummy;
        ListNode right_cur = right_dummy;
        while(head != null){
            if(head.val < x){
                left_cur.next = head;
                left_cur = head;
            }else{
                right_cur.next = head;
                right_cur = head;
            }
            head = head.next;
        }
        left_cur.next = right_dummy.next;
        right_cur.next = null;
        return left_dummy.next;
    }
}