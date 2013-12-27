//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

//For example,
//Given 1->2->3->3->4->4->5, return 1->2->5.
//Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null){
            boolean duplicated = false;
            while(cur.next != null && cur.val == cur.next.val){
                duplicated = true;
                cur = cur.next;
            }
            if(duplicated){
                cur = cur.next;
                continue;
            }
            pre.next = cur;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur;
        return dummy.next;
    }
}