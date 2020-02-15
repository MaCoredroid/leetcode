/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode less=new ListNode(-1);
        ListNode pointer1=less;
        ListNode more=new ListNode(-1);
        ListNode pointer2=more;
        while(head!=null)
        {
            if(head.val<x)
            {
                less.next=head;
                less=less.next;
            }
            else
            {
                more.next=head;
                more=more.next;
            }
            head=head.next;
        }
        more.next=null;
        less.next=pointer2.next;
        return pointer1.next;

        
    }
}