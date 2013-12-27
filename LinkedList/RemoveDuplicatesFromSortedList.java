//Given a sorted linked list, delete all duplicates such that each element appear only once.

//For example,
//Given 1->1->2, return 1->2.
//Given 1->1->2->3->3, return 1->2->3.

//Discuss

//
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
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode runner = cur.next;
        while(runner != null){
            if(runner.val == cur.val){
                runner = runner.next;
                cur.next = runner;
            }else{
                cur.next = runner;
                cur = runner;
                runner = runner.next;
            }
        }
        return head;
    }
}