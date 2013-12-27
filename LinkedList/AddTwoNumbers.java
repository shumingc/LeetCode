//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode result = new ListNode(-1);
        ListNode pre = result;
        int carry = 0;
        for(ListNode h1 = l1, h2 = l2; h1 != null || h2 != null;
             h1 = h1==null? null: h1.next, h2 = h2==null? null : h2.next, pre = pre.next ){
            carry += (h1==null? 0 : h1.val) + (h2==null? 0 : h2.val);
            pre.next = new ListNode(carry % 10);
            carry /= 10;
        }
        if(carry > 0){
            pre.next = new ListNode(carry);
        }
        return result.next;
    }
}