/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
        {
            return;
        }
        ListNode pre=null;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        ListNode prehead=null;
        ListNode curhead=slow;
        ListNode nexthead=null;
        while(curhead!=null)
        {
            nexthead=curhead.next;
            curhead.next=prehead;
            prehead=curhead;
            curhead=nexthead;
        }
        ListNode header=new ListNode(-1);
        while(head!=null&&prehead!=null)
        {
            header.next=head;
            head=head.next;
            header.next.next=prehead;
            prehead=prehead.next;
            header=header.next.next;
        }
        if(prehead!=null)
        {
            header.next=prehead;
        }
        head=header.next;
    }
}