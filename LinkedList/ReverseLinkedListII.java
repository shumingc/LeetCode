////Reverse a linked list from position m to n. Do it in-place and in one-pass.

//For example:
//Given 1->2->3->4->5->NULL, m = 2 and n = 4,

//return 1->4->3->2->5->NULL.

//Note:
//Given m, n satisfy the following condition:
//1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m >= n) return head;
        ListNode h = new ListNode(0);
        h.next =  head;
        int count = 0;
        ListNode p = h, pm = null, pn = null;
        while(p != null){
            if(count == m - 1){
                pm = p;
            }
            if(count == n){
                pn = p;
                break;
            }
            p = p.next;
            count ++;
        }
        p = pm;
        pm = pm.next;
        p.next = pn;
        p = pm.next;
        pm.next = pn.next;
        ListNode q = p.next;
        while(pm != pn){
            p.next = pm;
            pm = p;
            p = q;
            if(q != null){
                q = q.next;
            }
        }
        return h.next;
    }
}