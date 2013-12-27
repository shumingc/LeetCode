//Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

//If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

//You may not alter the values in the nodes, only nodes itself may be changed.

//Only constant memory is allowed.

//For example,
//Given this linked list: 1->2->3->4->5

//For k = 2, you should return: 2->1->4->3->5

//For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode end = head;
        while(end != null){
            for(int i = 1; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) break;
            prev = reverse(prev, prev.next, end);
            end = prev.next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode prev, ListNode begin, ListNode end){
        ListNode end_next = end.next;
        ListNode p = begin;
        ListNode cur = p.next;
        ListNode next = cur.next;
        while(cur != end_next){
            cur.next = p;
            p = cur;
            cur = next;
            next = next==null? null:next.next;
        }
        begin.next = end_next;
        prev.next = end;
        return begin;
    }
}