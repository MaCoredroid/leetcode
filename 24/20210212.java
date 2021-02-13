/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode first=head;
        ListNode second=head.next;
        ListNode prev=dummy;
        while(true)
        {
            ListNode next=null;
            if(second.next!=null)
            {
                next=second.next;
            }
            prev.next=second;
            second.next=first;
            first.next=next;
            if(next==null||next.next==null)
            {
                break;
            }
            prev=first;
            first=next;
            second=next.next;
            next=second.next;
        }
        return dummy.next;
    }
}