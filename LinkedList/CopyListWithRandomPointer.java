//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

//Return a deep copy of the list.
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode new_head = new RandomListNode(0);
        cur = head;
        RandomListNode new_cur = new_head;
        while(cur != null){
            new_cur.next = cur.next;
            new_cur = new_cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return new_head.next;
    }
}